package combi

import scalaz._
import Scalaz._
import lms.{common => lms}


trait ExtendedPairOps extends lms.TupleOps with EitherOps
                      with lms.TupledFunctions with lms.StringOps {
  def combine[T:Typ, U:Typ](x: Rep[(Int, \/[String, T])],
                     f: Rep[((Int, T)) => (Int, \/[String, U])]):
                     Rep[(Int, \/[String, U])]

  implicit class CombineOps[T:Typ](x: Rep[(Int, \/[String, T])]) {
    def >>[U:Typ](f: Rep[((Int, T)) => (Int, \/[String, U])]) = {
      combine(x, f)
    }

    def >>[U:Typ](f: (Rep[Int], Rep[T]) => Rep[(Int, \/[String, U])]) = {
      combine[T, U](x, fun(f))
    }
  }

  //implicit def foo[T:Typ](x: Rep[(Int, \/[String, T])]) = new CombineOps(x)
}

trait ExtendedPairOpsExp extends ExtendedPairOps with lms.BaseExp
                         with lms.TupleOpsExp with EitherOpsExp {
  case class Combine[T:Typ, U:Typ](x: Exp[(Int, \/[String, T])],
                     f: Exp[((Int, T)) => (Int, \/[String, U])]) extends Def[(Int, \/[String, U])]

  def combine[T:Typ, U:Typ](x: Exp[(Int, \/[String, T])],
                     f: Exp[((Int, T)) => (Int, \/[String, U])]):
                     Exp[(Int, \/[String, U])] = {
      Combine(x, f)
  }
}

trait ScalaGenExtenedPairOps extends lms.ScalaGenBase {
  val IR: ExtendedPairOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case Combine(x, f) => emitValDef(sym,
      src"""$x._2 match {
        case -\/(s) => ($x._1, -\/(s))
        case \/-(t) => $f($x._1, t)
      }"""
    )
    case _ => super.emitNode(sym, rhs)
  }

}
