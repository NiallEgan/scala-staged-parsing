package combi

import scala.collection.BufferedIterator
import language.postfixOps
import language.higherKinds
import scalaz._
import Scalaz._

trait TypedParsers[R[_]] {
  this: OptionOps[R] with BIOps[R] with LiftOps[R] with IfOps[R] with EqOps[R] with SetOps[R] =>

  implicit class BIOps(b: R[BufferedIterator[Char]]) {
    def head(): R[Char] = b_head(b)
    def hasNext(): R[Boolean] = b_hasNext(b)
    def next(): R[Char] = b_next(b)
  }

  implicit class OptionOps[Le, Ri](o: R[\/[Le, Ri]]) {
    def flatMap[B](f: Ri => R[\/[Le, B]]): R[\/[Le, B]] =
      o_bind(o, f)
    def map[B](f: Ri => B) = o_map[Le, Ri, B](o, f)
  }

  implicit class CharOps(c: R[Char]) {
    def ===(o: Char): R[Boolean] = c_eq(c, o)
  }

  implicit class SetOps(c: Set[Char]) {
    def contains(o: R[Char]): R[Boolean] = s_contains(c, o)
  }

  sealed abstract class TypedParser[T](val isNullable: Boolean, val firstSet: Set[Char]) {
    def hasInFirstSet(c: R[Char]): R[Boolean] = firstSet.contains(c)
    def apply(it: R[BufferedIterator[Char]]): R[\/[String, T]]
  }

  class AltParser[T](isNullable: Boolean, firstSet: Set[Char],
                     val parser1: TypedParser[T], val parser2: TypedParser[T])
                     extends TypedParser[T](isNullable, firstSet) {
    override def apply(it: R[BufferedIterator[Char]]): R[\/[String, T]] = {
      if (it.hasNext) {
        val c: R[Char] = it.head
        if (parser1 hasInFirstSet c) parser1(it)
        else if (parser2 hasInFirstSet c) parser2(it)
        else if (parser1 isNullable) parser1(it)
        else if (parser2 isNullable) parser2(it)
        else err[T](f"Error: Token $c matches neither possible branch.")
      } else {
        if (parser1 isNullable) parser1(it)
        else if (parser2 isNullable) parser2(it)
        else err[T]("Error: End of input encountered, but both branches still expecting input.")
      }
    }
  }

  class SeqParser[T, V](isNullable: Boolean, firstSet: Set[Char],
                        val parser1: TypedParser[T], val parser2: TypedParser[V])
                        extends TypedParser[(T, V)](isNullable, firstSet) {
    override def apply(it: R[BufferedIterator[Char]]): R[\/[String, (T, V)]] = {
      for {
        x <- parser1(it)
        y <- parser2(it)
      } yield (x, y)
    }
  }

  class CharParser(isNullable: Boolean, firstSet: Set[Char],
                   val c: Char) extends TypedParser[Char](isNullable, firstSet) {
    override def apply(it: R[BufferedIterator[Char]]): R[\/[String, Char]] = {
      if (it.hasNext) {
        val d = it.head
        if (d === c) suc(it.next())
        else err[Char](f"Error: Expected $c, got $d.")
      } else err[Char](f"Error: Expected $c, but reached end of input.")
    }
  }

  class BottomParser(isNullable: Boolean, firstSet: Set[Char])
                     extends TypedParser[Nothing](isNullable, firstSet) {
    override def apply(it: R[BufferedIterator[Char]]): R[\/[String, Nothing]] = {
      err("Error: BottomParser cannot parse anything.")
    }
  }

  class EpsParser(isNullable: Boolean, firstSet: Set[Char])
        extends TypedParser[Unit](isNullable, firstSet) {
    override def apply(it: R[BufferedIterator[Char]]): R[\/[String, Unit]] = {
      suc(())
    }
  }

  class StarParser[T](isNullable: Boolean, firstSet: Set[Char],
                     val parser1: TypedParser[T])
                     extends TypedParser[List[T]](isNullable, firstSet) {
    // TODO: Tail recursion
    override def apply(it: R[BufferedIterator[Char]]): R[\/[String, List[T]]] = {
      if (it.hasNext) {
        val c = it.head
        if (parser1 hasInFirstSet c) {
          for {
            x <- parser1(it)
            xs <- this.apply(it)
          } yield (x::xs)
        } else suc(List[T]())
      } else suc(List[T]())
    }
  }

  class MapParser[T, U](isNullable: Boolean, firstSet: Set[Char],
                        val parser: TypedParser[T], val f: T => U)
                        extends TypedParser[U](isNullable, firstSet) {
        override def apply(it: R[BufferedIterator[Char]]): R[\/[String, U]] = {
          for (x <- parser(it)) yield f(x)
        }
  }

  class FixParser[T](isNullable: Boolean, firstSet: Set[Char],
                     f: R[BufferedIterator[Char]] => R[\/[String, T]]) // Should R be here?
                    extends TypedParser[T](isNullable, firstSet) {
          override def apply(it: R[BufferedIterator[Char]]) = f(it)
  }
}
