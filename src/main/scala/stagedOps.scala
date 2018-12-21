package combi

import scalaz._
import Scalaz._
import lms.{common => lms}

trait LMSBufferedIteratorOps extends lms.Base {
  implicit def biTyp[T:Typ]: Typ[BufferedIterator[T]]
  def head[T](b: Rep[BufferedIterator[T]]): Rep[T]
  def hasNext[T](b: Rep[BufferedIterator[T]]): Rep[Boolean]
  def next[T](b: Rep[BufferedIterator[T]]): Rep[T]
}

trait LMSEitherOps extends lms.Base {
  implicit def eitherTyp[T:Typ, U:Typ]: Typ[\/[T, U]]
  def left[T](s: Rep[String]): Rep[\/[String, T]]
  def right[T](s: Rep[T]): Rep[\/[String, T]]
  def either_bind[Le, Ri, B](o: Rep[\/[Le, Ri]],
                             f: Ri => Rep[\/[Le, B]]): Rep[\/[Le, B]]
  def either_map[Le, Ri, B](o: Rep[\/[Le, Ri]], f: Ri => B): Rep[\/[Le, B]]
}

trait StagedOps extends lms.ListOps with lms.PrimitiveOps
                with lms.BooleanOps with lms.SetOps
                with lms.StringOps with lms.Equal
                with LMSBufferedIteratorOps
                with LMSEitherOps {
  trait StagedOptionOps extends OptionOps[Rep] {
    override def err[T](s: String): Rep[\/[String, T]] = left(unit(s))
    override def suc[T](r: Rep[T]): Rep[\/[String, T]] = right(r)
    override def o_bind[Le, Ri, B](o: Rep[\/[Le, Ri]],
                                   f: Ri => Rep[\/[Le, B]]): Rep[\/[Le, B]] = {
       either_bind(o, f)
    }
    override def o_map[Le, Ri, B](o: Rep[\/[Le, Ri]], f: Ri => B): Rep[\/[Le, B]] = {
      either_map(o, f)
    }
  }

  trait StagedBIOps extends BIOps[Rep] {
    override def b_head(b: Rep[BufferedIterator[Char]]): Rep[Char] = head(b)
    override def b_hasNext(b: Rep[BufferedIterator[Char]]): Rep[Boolean] = hasNext(b)
    override def b_next(b: Rep[BufferedIterator[Char]]): Rep[Char] = next(b)
  }

  trait StagedLiftOps extends LiftOps[Rep] {
    override implicit def lift(u: Unit) = unit(u)
    override implicit def lift[T:Typ](l: List[T]) = unit(l)
  }

  trait StagedIfOps extends IfOps[Rep] with lms.IfThenElse

  trait StagedEqOps extends EqOps[Rep] {
    override def c_eq(c: Rep[Char], o: Char): Rep[Boolean] = {
      __equal[Char, Char](c, unit(o))
    }
  }

  trait StagedSetOps extends SetOps[Rep] {
    override def s_contains(s: Set[Char], o: Rep[Char]): Rep[Boolean] = {
      def f(b: Rep[Boolean], c: Char) = b || unit(c) == o
      s.foldLeft(unit(false))(f _)
    }
  }


  class Compiler extends StagedOptionOps with StagedBIOps
                     with StagedLiftOps with StagedEqOps
                     with StagedSetOps with StagedIfOps
                     with Parser[Rep] with Hoas {
  }
}
