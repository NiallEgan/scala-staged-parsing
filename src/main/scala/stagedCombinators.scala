package combi

import scala.collection.BufferedIterator
import language.postfixOps
import scalaz._
import Scalaz._
import lms.{common => lms}
import java.io.PrintWriter



trait StagedCombinators extends LMSDriver with TypedGrammarNodes
                        with TypeChecker with GrammarNodes {

  sealed abstract class StagedParser[T:Typ](val isNullable: Boolean,
                                        val firstSet: Set[Char]) {
    def hasInFirstSet(c: Rep[Char]): Rep[Boolean] = {
      def f(b: Rep[Boolean], o: Char) = __equal[Char, Char](unit(o), c) || b
      firstSet.foldLeft(unit(false))(f)
    }

    def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, T]]

    def err(s: Rep[String]): Rep[\/[String, T]] = left[String, T](s)

    def suc(r: Rep[T]): Rep[\/[String, T]] = right[String, T](r)
  }

  class StagedAltParser[T:Typ](isNullable: Boolean, firstSet: Set[Char],
                           val parser1: StagedParser[T], val parser2: StagedParser[T])
                           extends StagedParser[T](isNullable, firstSet) {
    override def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, T]] = {
      if (it.hasNext) {
        val c: Rep[Char] = it.head
        if (parser1 hasInFirstSet c) parser1(it)
        else if (parser2 hasInFirstSet c) parser2(it)
        else if (parser1 isNullable) parser1(it)
        else if (parser2 isNullable) parser2(it)
        else err(f"Error: Token " + c + " matches neither possible branch.")
      } else {
        if (parser1 isNullable) parser1(it)
        else if (parser2 isNullable) parser2(it)
        else err(unit("Error: End of input encountered, but both branches still expecting input."))
      }
    }
  }

  class StagedPSeqParser[T:Typ, V:Typ](isNullable: Boolean, firstSet: Set[Char],
                        val parser1: StagedParser[T], val parser2: StagedParser[V])
                        extends StagedParser[(T, V)](isNullable, firstSet) {
    override def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, (T, V)]] = {
      parser1(it) >>= ((x: Rep[T]) => parser2(it) >>= ((y: Rep[V]) => suc((x, y))))
    }
  }

  class StagedCharParser(isNullable: Boolean, firstSet: Set[Char],
                         val c: Char) extends StagedParser[Char](isNullable, firstSet) {
    override def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, Char]] = {
      if (it.hasNext) {
        val d = it.head
        if (d == c) suc(it.next())
        else err(f"Error: Expected $c, got " + d + ".")
      } else err(unit(f"Error: Expected $c, but reached end of input."))
    }
  }

  class StagedBottomParser(isNullable: Boolean, firstSet: Set[Char])
                           extends StagedParser[Nothing](isNullable, firstSet) {
    override def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, Nothing]] = {
      err(unit("Error: BottomParser cannot parse anything."))
    }
  }

  class StagedEpsParser(isNullable: Boolean, firstSet: Set[Char])
        extends StagedParser[Unit](isNullable, firstSet) {
    override def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, Unit]] = {
      suc(())
    }
  }

  class StagedStarParser[T:Typ](isNullable: Boolean, firstSet: Set[Char],
                            val parser1: StagedParser[T])
                     extends StagedParser[List[T]](isNullable, firstSet) {
    // TODO: Tail recursion
    override def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, List[T]]] = {
      val result = var_new(suc(List[T]()))
      while (if (it.hasNext) parser1.hasInFirstSet(it.head) else unit(false)) {
        result = parser1(it) >>= ((x: Rep[T]) =>
                 readVar(result) >>= ((xs: Rep[List[T]]) => suc(x::xs)))
      }
      result
      /*if (it.hasNext) {
        val c = it.head
        if (parser1 hasInFirstSet c) {
            parser1(it) >>= ((x: Rep[T]) =>
            this.apply(it) >>= ((xs: Rep[List[T]]) => suc(x::xs)))
        } else suc(List[T]())
      } else suc(List[T]())*/
    }
  }

  class StagedMapParser[T:Typ, U:Typ](isNullable: Boolean, firstSet: Set[Char],
                        val parser: StagedParser[T], val f: Rep[T] => Rep[U])
                        extends StagedParser[U](isNullable, firstSet) {
        override def apply(it: Rep[BufferedIterator[Char]]): Rep[\/[String, U]] = {
          parser(it) >>= ((x: Rep[T]) => suc(f(x)))
        }
  }

  class StagedFixParser[T:Typ](isNullable: Boolean, firstSet: Set[Char],
                               f: Var[BufferedIterator[Char] => \/[String, T]])
                    extends StagedParser[T](isNullable, firstSet) {
          override def apply(it: Rep[BufferedIterator[Char]]) = {
            readVar(f).apply(it)
          }
  }

  object StagedParserEnv extends Env {
    override type T[X] = StagedParser[X]
  }

  def parse[Ctx, T:Typ](exp: TypedGrammarNode[Ctx, T], con: StagedParserEnv.Context[Ctx]): StagedParser[T] = {
    // TODO: This isn't very nice...
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
        val r: Var[BufferedIterator[Char] => \/[String, T]] = var_new[BufferedIterator[Char] => \/[String, T]]((x: Rep[BufferedIterator[Char]]) => (throw_exception(unit("Bottom"))).asInstanceOf[Rep[\/[String, T]]])
        val p: StagedParser[T] = new StagedFixParser(nullable, firstSet, r)
        r = doLambdaMut((it: Rep[BufferedIterator[Char]]) => parse(a, StagedParserEnv.add(p, con))(typ[T])(it))
        p
      }
    }
  }
}
