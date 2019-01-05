package combi

import scala.collection.BufferedIterator
import language.postfixOps
import scalaz._
import Scalaz._
import lms.{common => lms}
import java.io.PrintWriter



trait StagedCombinators extends LMSDriver with TypedGrammarNodes
                        with TypeChecker with GrammarNodes {

  def err[T:Typ](s: Rep[String], i: Rep[Int]): Rep[(Int, \/[String, T])] = (i, left[String, T](s))
  def suc[T:Typ](r: Rep[T], i: Rep[Int]): Rep[(Int, \/[String, T])] = (i, right[String, T](r))

  sealed abstract class StagedParser[T:Typ](val isNullable: Boolean,
                                            val firstSet: Set[Char])
      extends ((Rep[Int], Rep[String]) => Rep[(Int, \/[String, T])]) {
    def hasInFirstSet(c: Rep[Char]): Rep[Boolean] = {
      def f(b: Rep[Boolean], o: Char) = unit(o) == c || b
      firstSet.foldLeft(unit(false))(f)
    }

    def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, T])]
  }

  class StagedAltParser[T:Typ](isNullable: Boolean, firstSet: Set[Char],
                           val parser1: StagedParser[T], val parser2: StagedParser[T])
                           extends StagedParser[T](isNullable, firstSet) {
    val branch1: Rep[((Int, String)) => (Int, \/[String, T])] = fun((i: Rep[Int], s: Rep[String]) => parser1(i, s))
    val branch2: Rep[((Int, String)) => (Int, \/[String, T])] = fun((i: Rep[Int], s: Rep[String]) => parser2(i, s))

    override def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, T])] = {
      if (pos < s.length) {
        val c: Rep[Char] = s charAt pos
        if (parser1 hasInFirstSet c) parser1(pos, s)//branch1(pos, s)
        else if (parser2 hasInFirstSet c) parser2(pos, s)//branch2(pos, s)
        else if (parser1 isNullable) parser1(pos, s)//branch1(pos, s)
        else if (parser2 isNullable) parser2(pos, s)//branch2(pos, s)
        else err[T](f"Error: Token " + c + " matches neither possible branch.", pos)
      } else {
        if (parser1 isNullable) parser1(pos, s)//branch1(pos, s)
        else if (parser2 isNullable) parser2(pos, s)//branch2(pos, s)
        else err[T](unit("Error: End of input encountered, but both branches still expecting input."), pos)
      }
    }
  }

  class StagedPSeqParser[T:Typ, V:Typ](isNullable: Boolean, firstSet: Set[Char],
                        val parser1: StagedParser[T], val parser2: StagedParser[V])
                        extends StagedParser[(T, V)](isNullable, firstSet) {
    override def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, (T, V)])] = {
      parser1(pos, s) >> ((i: Rep[Int], x: Rep[T]) => parser2(i, s) >> ((j: Rep[Int], y: Rep[V]) => suc((x, y), j)))
    }
  }

  class StagedCharParser(isNullable: Boolean, firstSet: Set[Char],
                         val c: Char) extends StagedParser[Char](isNullable, firstSet) {
    override def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, Char])] = {
      if (pos < s.length) {
        val d = s charAt pos
        if (d == c) suc(d, pos+1)
        else err[Char](f"Error: Expected $c, got " + d + ".", pos)
      } else err[Char](unit(f"Error: Expected $c, but reached end of input."), pos)
    }
  }

  class StagedBottomParser(isNullable: Boolean, firstSet: Set[Char])
                           extends StagedParser[Nothing](isNullable, firstSet) {
    override def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, Nothing])] = {
      err[Nothing](unit("Error: BottomParser cannot parse anything."), pos)
    }
  }

  class StagedEpsParser(isNullable: Boolean, firstSet: Set[Char])
        extends StagedParser[Unit](isNullable, firstSet) {
    override def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, Unit])] = {
      suc((), pos)
    }
  }

  class StagedStarParser[T:Typ](isNullable: Boolean, firstSet: Set[Char],
                            val parser1: StagedParser[T])
                     extends StagedParser[List[T]](isNullable, firstSet) {
    override def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, List[T]])] = {
      val result = var_new(suc(List[T](), pos))
      while (if(readVar(result)._1 < s.length) parser1.hasInFirstSet(s charAt readVar(result)._1) else unit(false)) {
        result = parser1(readVar(result)._1, s) >> ((i: Rep[Int], x: Rep[T]) =>
                 readVar(result) >> ((_: Rep[Int], xs: Rep[List[T]]) => suc(x::xs, i)))
      }
      result
    }
  }

  class StagedMapParser[T:Typ, U:Typ](isNullable: Boolean, firstSet: Set[Char],
                        val parser: StagedParser[T], val f: Rep[T] => Rep[U])
                        extends StagedParser[U](isNullable, firstSet) {
        // TODO: Multiple maps...
        val c = fun(((i: Rep[Int], x: Rep[T]) => suc(f(x), i)))

        override def apply(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, U])] = {
          parser(pos, s) >> c
        }
  }

  class StagedFixParser[Ctx, T:Typ](isNullable: Boolean, firstSet: Set[Char],
                               a: TypedGrammarNode[(T, Ctx), T],
                               con: StagedParserEnv.Context[Ctx])
                    extends StagedParser[T](isNullable, firstSet) {
        val f: Var[((Int, String)) => (Int, \/[String, T])] =
          var_new[((Int, String)) => (Int, \/[String, T])]((x: Rep[(Int, String)]) =>
            throw_exception(unit("Bottom")).asInstanceOf[Rep[(Int, \/[String, T])]])
          f = fun((x: Rep[(Int, String)]) => parse(a, StagedParserEnv.add(this, con))(typ[T])(x._1, x._2))

          override def apply(pos: Rep[Int], s: Rep[String]) = {
            readVar(f).apply((pos, s))
          }
  }

  object StagedParserEnv extends Env {
    override type T[X] = StagedParser[X]
  }

  def parse[Ctx, T:Typ](exp: TypedGrammarNode[Ctx, T], con: StagedParserEnv.Context[Ctx]): StagedParser[T] = {
    val nullable = exp.tp.nullable
    val firstSet = exp.tp.first
    exp match {
      case TEps(_) => new StagedEpsParser(nullable, firstSet)
      case TAlt(_, left, right) => {
        new StagedAltParser(nullable, firstSet, parse(left, con), parse(right, con))
      }
      case s@TPSeq(_, left, right) => {
        new StagedPSeqParser(nullable, firstSet, parse(left, con)(s.leftTyp), parse(right, con)(s.rightTyp))(s.leftTyp, s.rightTyp)
      }
      case TCharacter(_, c) => new StagedCharParser(nullable, firstSet, c)
      case TBot(_) => new StagedBottomParser(nullable, firstSet)
      case s@TStar(_, a) => {
        new StagedStarParser(nullable, firstSet, parse(a, con)(s.innerTyp))(s.innerTyp)
      }
      case TVar(_, n) => StagedParserEnv.find(n, con)
      case s@TPMap(_, f, a) => new StagedMapParser(nullable, firstSet, parse(a, con)(s.fromTyp), f)(s.fromTyp, s.toTyp)
      case p@TFix(_, a) => {
        new StagedFixParser[Ctx, T](nullable, firstSet, a, con)
      }
    }
  }
}
