package combi

import scalaz._
import Scalaz._

trait TypeChecker {
  this: TypedGrammarNodes with GrammarNodes with LMSDriver with DBVars =>
  object TypeEnv extends Env {
    override type T[_] = ParserType
  }


  class ParserType(val first: Set[Char],
                   val follow: Set[Char],
                   val nullable: Boolean,
                   val guarded: Boolean) {

      def hash[T](other: ParserType): Boolean = {
        !(other.nullable && nullable) && (other.first & first).isEmpty
      }

      def *[T](other: ParserType): Boolean = {
        // TODO: Check assoc here!
        (other.follow & follow).isEmpty && (!nullable)
      }

      override def equals(other: Any): Boolean = other match {
        case o: ParserType => {
          o.first == first && o.follow == follow &&
          o.nullable == nullable && o.guarded == guarded
        }
        case _ => false
      }

      override def toString(): String = {
        f"{first: $first, follow: $follow, nullable: $nullable, guarded: $guarded}"
      }
  }


  object TypeChecker {
    private def seqType(t1: TypeEnv.T[_], t2: TypeEnv.T[_]): TypeEnv.T[_] = {
      new ParserType(
        t1.first,
        t2.follow ++
          (if (t2.nullable) t1.follow ++ t2.first
           else Set()),
        false,
        t1.guarded
      )
    }

    private def fix_s[T](s: Stream[T], v: T): T = {
      // TODO:  Use iterators, iterate while etc.
      val v1 = s.head
      if (v1 == v) v
      else fix_s(s.tail, v1)
    }

    def suc[Ctx, T:Typ](a: TypedGrammarNode[Ctx, T]) = a.right[String]
    def err[Ctx, T:Typ](a: String) = a.left[TypedGrammarNode[Ctx, T]]

    def pType[Ctx, A:Typ](typeContext: TypeEnv.Context[Ctx], exp: GrammarNode[Ctx, A]):
      \/[String, TypedGrammarNode[Ctx, A]] = {
      exp match {
        case Eps() => suc(TEps[Ctx](new ParserType(Set(), Set(), true, true)))(unitTyp)
        case Character(c) => suc(TCharacter[Ctx](new ParserType(Set(c), Set(), false, true), c))(charTyp)
        //case Bot() => suc(TBot(new ParserType(Set(), Set(), false, true)))
        case Alt(left, right) => {
          pType(typeContext, left) >>= (leftTypedNode => {
          pType(typeContext, right) >>= (rightTypedNode => {
            val leftType = leftTypedNode.tp
            val rightType = rightTypedNode.tp
            if (leftType hash rightType) {
              suc(TAlt(new ParserType(
               leftType.first ++ rightType.first,
               leftType.follow ++ rightType.follow,
               leftType.nullable || rightType.nullable,
               leftType.guarded && rightType.guarded), leftTypedNode, rightTypedNode))
            } else err(f"Type Error: The alternatives $left and $right are ambiguous.")
            })})
          }

        case s@PSeq(left, right) => {
          pType(typeContext, left)(s.leftTyp) >>= (leftTypedNode => {
          pType(typeContext, right)(s.rightTyp) >>= (rightTypedNode => {
            val leftType = leftTypedNode.tp
            val rightType = rightTypedNode.tp
            if (leftType * rightType) {
              suc(TPSeq(seqType(leftType, rightType), leftTypedNode, rightTypedNode)(s.leftTyp, s.rightTyp))
            } else err(f"Type Error: The sequence $left and $right are ambiguous.")
          })})
        }
        case PVar(v) => suc(TVar(TypeEnv.find(v, typeContext), v))
        case s@Star(a) => {
          for (typedNode <- pType(typeContext, a)(s.innerTyp);
               innerType = seqType(typedNode.tp, typedNode.tp)) yield
          TStar(new ParserType(innerType.first, innerType.first ++ innerType.follow,
                             true, innerType.guarded), typedNode)(s.innerTyp)
        }
        case s@PMap(f, a) => {
          for(typedNode <- pType(typeContext, a)(s.fromTyp))
          yield TPMap(typedNode.tp, f, typedNode)(s.fromTyp, s.toTyp)
        }
        case Fix(a) => {
          // TODO: Why does this work.
          val bottomType = new ParserType(Set(), Set(), false, false)
          val nextType: \/[String, TypeEnv.T[A]] => \/[String, TypeEnv.T[A]] =
            x => x >>= (
              (t: TypeEnv.T[A]) => pType(TypeEnv.add(t, typeContext), a).map(_.tp)
            )

          val iterTypes = Stream.iterate(bottomType.right[String])(nextType)
          val m = fix_s(iterTypes.tail, iterTypes.head)

          m >>= ((t: TypeEnv.T[A]) =>
                if (!t.guarded) err(f"Type Error: $t is not guarded.")
                else {
                  for (tNode <- pType(TypeEnv.add(t, typeContext), a))
                  yield TFix(tNode.tp, tNode)
                }
          )
        }
      }
    }
  }
}
