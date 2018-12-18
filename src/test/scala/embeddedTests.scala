import combi._

import scalaz._
import Scalaz._
import org.scalatest.FlatSpec

import scala.language.postfixOps

trait EmbeddedTester extends Hoas {
  def getClosedTerm[T](g: D[Unit, T]): GrammarNode[Unit, T] = {
    g(CtxZ())
  }
}

class UnEpsSpec extends FlatSpec with EmbeddedTester {
  "eps" should "be unembedded to Eps()" in {
    assertResult(Eps())(getClosedTerm(eps))
  }
}

class UnCharSpec extends FlatSpec with EmbeddedTester {
  "a" should "be unembedded to get Char('a')" in {
    assertResult(Character('a'))(getClosedTerm('a'))
  }
}

class UnSeqSpec extends FlatSpec with EmbeddedTester {
  val g: GrammarNode[Unit, (Char, Char)] = Seq(Character('a'), Character('b'))
  "a ~ b" should "be unembedded to get Seq(Character('a'), Character('b'))" in {
    assertResult(g)(getClosedTerm('a' ~ 'b'))
  }
}

class UnAltSpec extends FlatSpec with EmbeddedTester {
  val g: GrammarNode[Unit, Char] = Alt(Character('a'), Character('b'))
  "a <|> b" should "be unembedded to get Alt(Character('a'), Character('b'))" in {
    assertResult(g)(getClosedTerm('a' <|> 'b'))
  }
}

class UnCompoundSpec extends FlatSpec with EmbeddedTester {
  val g: GrammarNode[Unit, (Char, Char)] =
    Seq(Character('a'), Alt(Character('b'), Character('c')))
  "a ~ (b <|> c)" should "be unembedded to get ..." in {
    assertResult(g)(getClosedTerm('a' ~ ('b' <|> 'c')))
  }
}

class UnStarSpec extends FlatSpec with EmbeddedTester {
  val g: GrammarNode[Unit, List[Char]] = Star(Character('a'))
  "a.**" should "be unembedded to get Star(Character('a'))" in {
    assertResult(g)(getClosedTerm('a'**))
  }
}

class UnCompound2Spec extends FlatSpec with EmbeddedTester {
  val left: GrammarNode[Unit, (Char, Char)] =
    Seq(Character('a'), Character('b'))
  val right: GrammarNode[Unit, (Char, Char)] =
    Seq(Character('a'), Character('c'))
  val g: GrammarNode[Unit, (Char, Char)] =
     Alt(left, right)

  "(a ~ b) <|> (a ~ c)" should "be unembedded to ..." in {
    // TODO: Type errors here??
    val l: D[Unit, (Char, Char)] = 'a' ~ 'b'
    val r: D[Unit, (Char, Char)] = 'a' ~ 'c'
    assertResult(g)(getClosedTerm(l <|> r))
  }
}

class UnFixSpec extends FlatSpec with EmbeddedTester {
  def p2l(x: (Char, Char)) = List(x._1, x._2)
  def cons(x: (Char, List[Char])) = x._1::x._2
  def app(x: (List[Char], Char)): List[Char] = x._1++List(x._2)
  def concat(x: (List[Char], List[Char])) = x._1 ++ x._2


  val g: GrammarNode[Unit, List[Char]] =
    Fix(Alt(
      PMap(
        p2l,
        Seq(Character('a'), Character('c'))),
      PMap(
        cons,
        Seq(Character('b'), Var(IndexZ())))
      ))

  def LSeqC[Ctx](a: GrammarNode[Ctx, Char],
                 b: GrammarNode[Ctx, List[Char]]) = {
    PMap((x: (Char, List[Char])) => x._1::x._2,
         Seq(a, b))
  }
  def LSeqL[Ctx](a: GrammarNode[Ctx, List[Char]],
                 b: GrammarNode[Ctx, List[Char]]) = {
    PMap((x: (List[Char], List[Char])) => x._1 ++ x._2,
         Seq(a, b))
  }

  val bracketsAGrammar: GrammarNode[Unit, List[Char]] =
    Fix(Alt(
      PMap((x: Char) => List(x), Character('a')),
      LSeqC(Character('('),
      LSeqL(Var(IndexZ()),
      LSeqC(Character(')'),
           Var(IndexZ()))
      ))
    ))

    val dyckLanguage: GrammarNode[Unit, List[Char]] =
      Fix(Alt(
        PMap((x: Unit) => List(), Eps()),
        LSeqL(
          PMap((x: (List[Char], Char)) => x._1 ++ List(x._2),
              Seq(
              LSeqC(Character('('), Var(IndexZ())),
              Character(')'))
          ),
          Var(IndexZ())
        )
      ))

    val simpleBrackets: GrammarNode[Unit, List[Char]] =
      Fix(Alt(
        PMap((x: Unit) => List(), Eps()),
        PMap((x: (List[Char], Char)) => x._1 ++ List(x._2),
              Seq(
                LSeqC(Character('('), Var(IndexZ())),
                Character(')')
              )
        )
      ))

    "The E ::= ac | bE grammar" should "unembed to ..." in {
      // TODO: Being overwhelmed by types!!!!
      val s: D[Unit, List[Char]] = fix(x => {
          val ac: D[(List[Char], Unit), (Char, Char)] = 'a' ~ 'c'
          val left = ac ^^ p2l
          val right = ('b' ~ x) ^^ cons
          left <|> right
      })

      assertResult(g)(getClosedTerm(s))
    }

    "The simple brackets grammar" should "unembed to ..." in {
      val s: D[Unit, List[Char]] = fix(x => {
        (eps ^^ (x => List[Char]())) <|> (((('(' ~ x) ^^ cons) ~ ')') ^^ app)
      })
      assertResult(simpleBrackets)(getClosedTerm(s))
    }

    "The Dyck grammar" should "unembed to ..." in {
      val s: D[Unit, List[Char]] = fix(x => {
        val l: D[(List[Char], Unit), List[Char]] =
          (eps ^^ (x => List[Char]()))
        val r: D[(List[Char], Unit), List[Char]] =
          ((((('(' ~ x) ^^ cons) ~ ')') ^^ app) ~ x) ^^ concat
        l <|> r
      })
      assertResult(dyckLanguage)(getClosedTerm(s))
    }
}
