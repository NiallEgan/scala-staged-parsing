package combi

import scala.collection.BufferedIterator
import language.postfixOps
import language.higherKinds
import scalaz._
import Scalaz._

trait OptionOps[R[_]] {
    def err[T](s: String): R[\/[String, T]]
    def suc[T](r: R[T]): R[\/[String, T]]
    def o_bind[Le, Ri, B](o: R[\/[Le, Ri]], f: Ri => R[\/[Le, B]]): R[\/[Le, B]]
    def o_map[Le, Ri, B](o: R[\/[Le, Ri]], f: Ri => B): R[\/[Le, B]]
}

trait BIOps[R[_]] {
    def b_head(b: R[BufferedIterator[Char]]): R[Char]
    def b_hasNext(b: R[BufferedIterator[Char]]): R[Boolean]
    def b_next(b: R[BufferedIterator[Char]]): R[Char]
}

trait LiftOps[R[_]] {
  implicit def lift(u: Unit): R[Unit]
  implicit def lift[T](l: List[T]): R[List[T]]
}

trait IfOps[R[_]] {
  implicit def __ifThenElse[T](c: R[Boolean], thenp: => R[T], elsep: => R[T]): R[T]
  /* Apparently this is because of a bug in scala-virtualized
    https://github.com/TiarkRompf/virtualization-lms-core/blob/develop/src/common/IfThenElse.scala#L11 */
  def __ifThenElse[T](cond: =>Boolean, thenp: => T, elsep: => T) = cond match {
    case true => thenp
    case false => elsep
  }
}

trait EqOps[R[_]] {
  def c_eq(c: R[Char], o: Char): R[Boolean]
}

trait SetOps[R[_]] {
  def s_contains(s: Set[Char], o: R[Char]): R[Boolean]
}
