package combi

import scala.collection.BufferedIterator
import language.postfixOps
import scalaz._
import Scalaz._
// TODO: Generalize return type

sealed abstract class TypedParser[T](val isNullable: Boolean, val firstSet: Set[Char]) {
  def hasInFirstSet(c: Char): Boolean =
    firstSet.contains(c)

  def apply(it: BufferedIterator[Char]): \/[String, T] // \/ = Either

  def err(s: String): \/[String, T] =
    s.left[T]

  def suc(r: T): \/[String, T] = // TODO: This is just unit
    r.right[String]
}

class AltParser[T](isNullable: Boolean, firstSet: Set[Char],
                   val parser1: TypedParser[T], val parser2: TypedParser[T])
                   extends TypedParser[T](isNullable, firstSet) {
  override def apply(it: BufferedIterator[Char]): \/[String, T] = {
    if (it.hasNext) {
      val c: Char = it.head
      if (parser1 hasInFirstSet c) parser1(it)
      else if (parser2 hasInFirstSet c) parser2(it)
      else if (parser1 isNullable) parser1(it)
      else if (parser2 isNullable) parser2(it)
      else err(f"Error: Token $c matches neither possible branch.")
    } else {
      if (parser1 isNullable) parser1(it)
      else if (parser2 isNullable) parser2(it)
      else err("Error: End of input encountered, but both branches still expecting input.")
    }
  }
}

class SeqParser[T, V](isNullable: Boolean, firstSet: Set[Char],
                      val parser1: TypedParser[T], val parser2: TypedParser[V])
                      extends TypedParser[(T, V)](isNullable, firstSet) {
  override def apply(it: BufferedIterator[Char]): \/[String, (T, V)] = {
    for {
      x <- parser1(it)
      y <- parser2(it)
    } yield (x, y)
  }
}

class CharParser(isNullable: Boolean, firstSet: Set[Char],
                 val c: Char) extends TypedParser[Char](isNullable, firstSet) {
  override def apply(it: BufferedIterator[Char]): \/[String, Char] = {
    if (it.hasNext) {
      val d = it.head
      if (d == c) suc(it.next())
      else err(f"Error: Expected $c, got $d.")
    } else err(f"Error: Expected $c, but reached end of input.")
  }
}

class BottomParser(isNullable: Boolean, firstSet: Set[Char])
                   extends TypedParser[Nothing](isNullable, firstSet) {
  override def apply(it: BufferedIterator[Char]): \/[String, Nothing] = {
    err("Error: BottomParser cannot parse anything.")
  }
}

class EpsParser(isNullable: Boolean, firstSet: Set[Char])
      extends TypedParser[Unit](isNullable, firstSet) {
  override def apply(it: BufferedIterator[Char]): \/[String, Unit] = {
    suc(())
  }
}

class StarParser[T](isNullable: Boolean, firstSet: Set[Char],
                   val parser1: TypedParser[T])
                   extends TypedParser[List[T]](isNullable, firstSet) {
  // TODO: Tail recursion
  override def apply(it: BufferedIterator[Char]): \/[String, List[T]] = {
    if (it.hasNext) {
      val c = it.head
      if (parser1 hasInFirstSet c) {
        for {
          x <- parser1(it)
          xs <- this.apply(it)
        } yield (x::xs)
      } else suc(List())
    } else suc(List())
  }
}

class MapParser[T, U](isNullable: Boolean, firstSet: Set[Char],
                      val parser: TypedParser[T], val f: T => U)
                      extends TypedParser[U](isNullable, firstSet) {
      override def apply(it: BufferedIterator[Char]): \/[String, U] = {
        for (x <- parser(it)) yield f(x)
      }
}

class FixParser[T](isNullable: Boolean, firstSet: Set[Char],
                   f: BufferedIterator[Char] => \/[String, T])
                  extends TypedParser[T](isNullable, firstSet) {
        override def apply(it: BufferedIterator[Char]) = f(it)
}
