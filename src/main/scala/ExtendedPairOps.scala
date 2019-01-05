package combi

import scalaz._
import Scalaz._
import lms.{common => lms}
import scala.collection.mutable.HashMap


trait ExtendedPairOps extends lms.TupleOps with EitherOps
                      with lms.TupledFunctions with lms.StringOps {
  def combine[T:Typ, U:Typ](x: Rep[(Int, \/[String, T])],
                     f: Rep[((Int, T)) => (Int, \/[String, U])]):
                     Rep[(Int, \/[String, U])]
  // TODO: Why does private cause the program to crash...
  val seenFuncs = new HashMap[Any, Any]()

  implicit class CombineOps[T:Typ](x: Rep[(Int, \/[String, T])]) {
    def >>[U:Typ](f: Rep[((Int, T)) => (Int, \/[String, U])]) = {
      combine(x, f)
    }

    def >>[U:Typ](f: (Rep[Int], Rep[T]) => Rep[(Int, \/[String, U])]) = {
      if (seenFuncs.contains(f)) {
        val liftedF = seenFuncs(f).asInstanceOf[Rep[((Int, T)) => (Int, \/[String, U])]]
        combine[T, U](x, liftedF)
      } else {
        val liftedF = fun(f)
        seenFuncs += f -> liftedF
        combine[T, U](x, liftedF)
      }
    }
  }
}

trait ExtendedPairOpsExp extends ExtendedPairOps with lms.BaseExp
                         with lms.TupleOpsExp with EitherOpsExpOpt {
  case class Combine[T:Typ, U:Typ](x: Exp[(Int, \/[String, T])],
                     f: Exp[((Int, T)) => (Int, \/[String, U])]) extends Def[(Int, \/[String, U])]

  def combine[T:Typ, U:Typ](x: Exp[(Int, \/[String, T])],
                     f: Exp[((Int, T)) => (Int, \/[String, U])]):
                     Exp[(Int, \/[String, U])] = {
      Combine(x, f)
  }
}

trait ExtendedPairOpsExpOpt extends ExtendedPairOpsExp {
  override def combine[T: Typ, U: Typ](x: Exp[(Int, \/[String, T])],
                                       f: Exp[((Int, T)) => (Int, \/[String, U])]) = {
      (x, f) match {
        case (Def(SimpleStruct(_,
              Seq(("._1", n:Exp[Int]), ("._2", Def(EitherLeft(s:Exp[String], r)))))),
              Def(Lambda(f, _, _))) => make_tuple2((n, EitherLeft(s, typ[U])))
        case (Def(SimpleStruct(_,
              Seq(("._1", n:Exp[Int]), ("._2", Def(EitherRight(s:Exp[T], r)))))),
              Def(Lambda(f, _, _))) => f(n, s)
        case (_, _) => {
          //println(x)
          super.combine(x, f)
        }
      }
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
