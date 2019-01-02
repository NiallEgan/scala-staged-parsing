package combi

import lms.{common => lms}
import scalaz._
import Scalaz._

trait EitherOps extends lms.PrimitiveOps {
  implicit def eitherTyp[T:Typ, U:Typ]: Typ[\/[T, U]]
  def left[U:Typ, T:Typ](s: Rep[U]): Rep[\/[U, T]]
  def right[U:Typ, T:Typ](s: Rep[T]): Rep[\/[U, T]]
  def either_bind[Le:Typ, Ri:Typ, B:Typ](o: Rep[\/[Le, Ri]],
                             f: Rep[Ri => \/[Le, B]]): Rep[\/[Le, B]]
  def either_map[Le:Typ, Ri:Typ, B:Typ](o: Rep[\/[Le, Ri]], f: Rep[Ri => B]): Rep[\/[Le, B]]

  implicit class EitherOpsCls[U:Typ, T:Typ](e: Rep[\/[U, T]]) {
    def >>=[B:Typ](f: Rep[T => \/[U, B]]) = flatMap(f)
    def flatMap[B:Typ](f: Rep[T => \/[U, B]]) = either_bind(e, f)
    def map[B:Typ](f: Rep[T => B]) = either_map(e, f)
  }
}

trait EitherOpsExp extends EitherOps with lms.BaseExp with lms.StringOpsExp {
  implicit def eitherTyp[T:Typ, U:Typ]: Typ[\/[T, U]] = {
    implicit val ManifestTyp(mA) = typ[T]
    implicit val ManifestTyp(mB) = typ[U]
    manifestTyp
  }

  case class EitherLeft[U:Typ, T:Typ](s: Exp[U], rightTyp: Typ[T]) extends Def[\/[U, T]]
  case class EitherRight[U:Typ, T:Typ](s: Exp[T], leftTyp: Typ[U]) extends Def[\/[U, T]]
  case class EitherBind[Le: Typ, Ri:Typ, B:Typ](o: Exp[\/[Le, Ri]], f: Exp[Ri => \/[Le, B]]) extends Def[\/[Le, B]]
  case class EitherMap[Le: Typ, Ri:Typ, B:Typ](o: Exp[\/[Le, Ri]], f: Exp[Ri => B]) extends Def[\/[Le, B]]

  override def left[U:Typ, T:Typ](s: Exp[U]): Exp[\/[U, T]] =
    EitherLeft[U, T](s, typ[T])
  override def right[U:Typ, T:Typ](s: Exp[T]): Exp[\/[U, T]] =
    EitherRight[U, T](s, typ[U])
  override def either_bind[Le:Typ, Ri:Typ, B:Typ](o: Exp[\/[Le, Ri]],
                             f: Exp[Ri => \/[Le, B]]): Exp[\/[Le, B]] =
    EitherBind(o, f)
  override def either_map[Le:Typ, Ri:Typ, B:Typ](o: Exp[\/[Le, Ri]], f: Exp[Ri => B]): Exp[\/[Le, B]] =
    EitherMap(o, f)
}

trait ScalaGenEitherOps extends lms.ScalaGenBase {
  val IR: EitherOpsExp
  import IR._

  override def remap[A](m: Typ[A]): String = {
    if (m.runtimeClass.toString == "class scalaz.$bslash$div") {
      f"\\/[${remap(m.typeArguments(0))}, ${remap(m.typeArguments(1))}]"
    }
    else super.remap(m)
  }

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case EitherLeft(s, rightTyp) => emitValDef(sym, f"${quote(s)}.left[${remap(rightTyp)}]")
    case EitherRight(s, leftTyp) => emitValDef(sym, f"${quote(s)}.right[${remap(leftTyp)}]")
    case EitherBind(s, f) =>
    emitValDef(sym, src"""$s match {
      case -\/(s) => -\/(s)
      case \/-(x) => $f(x)
    }""")
    case EitherMap(s, f) =>
      emitValDef(sym, src"""$s match {
        case -\/(s) => -\/(s)
        case \/-(x) => \/-($f(x))
    }""")
    case _ => super.emitNode(sym, rhs)
  }
}
