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

      def hash(other: ParserType): Boolean = {
        !(other.nullable && nullable) && (other.first & first).isEmpty
      }

      def *(other: ParserType): Boolean = {
        (other.follow & follow).isEmpty && (!nullable)
      }

      def seq(other: ParserType): ParserType = {
        // Need to treat bottom as a special case as per the definitions of types
        if (other.isInstanceOf[BottomType]) new BottomType()
        else new ParserType(
          first,
          other.follow ++ (if (other.nullable) follow ++ other.first else Set()),
          nullable && other.nullable,
          guarded
        )
      }

      def alt(other: ParserType): ParserType = {
        new ParserType(
         first ++ other.first,
         follow ++ other.follow,
         nullable || other.nullable,
         guarded && other.guarded)
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

  class BottomType extends ParserType(Set(), Set(), false, true) { // TODO: Should it really be guarded?
    override def seq(o: ParserType) = new BottomType()
  }

  class EpsType extends ParserType(Set(), Set(), true, true) {}

  class CharType(c: Char) extends ParserType(Set(c), Set(), false, true) {}

  object TypeChecker {
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
        case Eps() => suc(TEps[Ctx](new EpsType()))(unitTyp)
        case Character(c) => suc(TCharacter[Ctx](new CharType(c), c))(charTyp)
        // For some reason the fact that Nothing <: A causes the typing to normally fail below...
        case Bot() => suc(TBot[Ctx](new BottomType()).asInstanceOf[TypedGrammarNode[Ctx, A]])(nothingTyp)
        case Alt(left, right) => {
          pType(typeContext, left) >>= (leftTypedNode => {
          pType(typeContext, right) >>= (rightTypedNode => {
            val leftType = leftTypedNode.tp
            val rightType = rightTypedNode.tp
            if (leftType hash rightType) {
              suc(TAlt(leftType alt rightType, leftTypedNode, rightTypedNode))
            } else err(f"Type Error: The alternatives $left and $right are ambiguous.")
            })})
          }

        case s@PSeq(left, right) => {
          pType(typeContext, left)(s.leftTyp) >>= (leftTypedNode => {
          pType(typeContext, right)(s.rightTyp) >>= (rightTypedNode => {
            val leftType = leftTypedNode.tp
            val rightType = rightTypedNode.tp
            if (leftType * rightType) {
              suc(TPSeq(leftType seq rightType, leftTypedNode, rightTypedNode)(s.leftTyp, s.rightTyp))
            } else err(f"Type Error: The sequence $left and $right are ambiguous.")
          })})
        }
        case PVar(v) => suc(TVar(TypeEnv.find(v, typeContext), v))
        case s@Star(a) => {
          for (typedNode <- pType(typeContext, a)(s.innerTyp);
               innerType = typedNode.tp seq typedNode.tp) yield
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
