import scalaz._
import Scalaz._

object TypeEnv extends Env {
  override type T[+_] = ParserType
}

class ParserType(val first: Set[Char],
                 val follow: Set[Char],
                 val nullable: Boolean,
                 val guarded: Boolean) {
    def hash[T](other: ParserType): Boolean = {
      !(other.nullable && nullable) && (other.first & first).isEmpty
    }

    def *[T](other: ParserType): Boolean = {
      (other.follow & follow).isEmpty && (!nullable)
    }
}


object TypeChecker {


  private def seqType(t1: TypeEnv.T[_], t2: TypeEnv.T[_]) = {
    new ParserType(
      t1.first,
      t2.follow ++
        (if (t2.nullable) t1.follow ++ t2.first
         else Set()),
      false,
      t1.guarded
    )
  }

  def suc(a: TypeEnv.T[_]) = a.right[String]
  def err(a: String) = a.left[TypeEnv.T[_]]

  def pType[Ctx, A](typeContext: TypeEnv.Context[Ctx], exp: GrammarNode[Ctx, A]):
    \/[String, TypeEnv.T[A]] = {
    exp match {
      case Eps() => suc(new ParserType(Set(), Set(), true, true))
      case Character(c) => suc(new ParserType(Set(c), Set(), false, true))
      case Bot() => suc(new ParserType(Set(), Set(), false, true))
      case Alt(left, right) => {
        pType(typeContext, left) >>= (leftType =>
        pType(typeContext, right) >>= (rightType =>
          if (leftType hash rightType) {
            suc(new ParserType(
             leftType.first ++ rightType.first,
             leftType.follow ++ rightType.follow,
             leftType.nullable || rightType.nullable,
             leftType.guarded && rightType.guarded))
          } else err(f"Type Error: The alternatives $left and $right are ambiguous.")
          ))
        }

      case Seq(left, right) => {
        pType(typeContext, left) >>= (leftType =>
        pType(typeContext, right) >>= (rightType =>
          if (leftType * rightType) {
            suc(seqType(leftType, rightType))
          } else err(f"Type Error: The sequence $left and $right are ambiguous.")
        ))
      }
      case Var(v) => suc(TypeEnv.find(v, typeContext))
      case Star(a) => {
        for (innerType <- pType(typeContext, a);
             t = seqType(innerType, innerType)) yield
        new ParserType(t.first, innerType.first ++ innerType.follow,
                           true, t.guarded)
      }
      case Map(_, a) => pType(typeContext, a)
      case Fix(a) => {
        // TODO: Why does this work.
        val bottomType = new ParserType(Set(), Set(), false, false)
        val nextType: \/[String, TypeEnv.T[A]] => \/[String, TypeEnv.T[A]] =
          x => x >>= ((t: TypeEnv.T[A]) => pType(TypeEnv.add(t, typeContext), a))
        val iterTypes = Stream.iterate(suc(bottomType))(nextType)
        ((iterTypes, iterTypes.tail).zipped.takeWhile
              { case (t1, t2) => t1 != t2 }.last._1) >>= ((t: TypeEnv.T[A]) =>
        if (!t.guarded) err(f"Type Error: $t is not guarded.")
        else pType(TypeEnv.add(t, typeContext), a))
      }
    }
  }
}
