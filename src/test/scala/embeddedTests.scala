import combi._

import scalaz._
import Scalaz._
import org.scalatest.FlatSpec
import lms.{common => lms}


import scala.language.postfixOps

trait EmbeddedTester extends Hoas with GrammarNodes with DslExp {
  def getClosedTerm[T](g: D[Unit, T]): GrammarNode[Unit, T] = {
    g(UnitEnv.CtxZ())
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

class UnPSeqSpec extends FlatSpec with EmbeddedTester {
  val g: GrammarNode[Unit, (Char, Char)] = PSeq(Character('a'), Character('b'))
  "a ~ b" should "be unembedded to get PSeq(Character('a'), Character('b'))" in {
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
    PSeq(Character('a'), Alt(Character('b'), Character('c')))
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
    PSeq(Character('a'), Character('b'))
  val right: GrammarNode[Unit, (Char, Char)] =
    PSeq(Character('a'), Character('c'))
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
  def p2l(x: Rep[(Char, Char)]): Rep[List[Char]] = List(x._1, x._2)
  def cons(x: Rep[(Char, List[Char])]): Rep[List[Char]] = x._1::x._2
  def app(x: Rep[(List[Char], Char)]): Rep[List[Char]] = x._1++List(x._2)
  def concat(x: Rep[(List[Char], List[Char])]): Rep[List[Char]] = x._1 ++ x._2


  val g: GrammarNode[Unit, List[Char]] =
    Fix(Alt(
      PMap(
        (x: Rep[(Char, Char)]) => List(x._1, x._2),
        PSeq(Character('a'), Character('c'))),
      PMap(
        (x: Rep[(Char, List[Char])]) => x._1::x._2,
        PSeq(Character('b'), PVar(IndexZ())))
      ))

  def LPSeqC[Ctx](a: GrammarNode[Ctx, Char],
                 b: GrammarNode[Ctx, List[Char]]) = {
    PMap((x: Rep[(Char, List[Char])]) => x._1::x._2,
         PSeq(a, b))
  }

  def LPSeqL[Ctx](a: GrammarNode[Ctx, List[Char]],
                 b: GrammarNode[Ctx, List[Char]]) = {
    PMap((x: Rep[(List[Char], List[Char])]) => x._1 ++ x._2,
         PSeq(a, b))
  }

  val bracketsAGrammar: GrammarNode[Unit, List[Char]] =
    Fix(Alt(
      PMap((x: Rep[Char]) => List(x), Character('a')),
      LPSeqC(Character('('),
      LPSeqL(PVar(IndexZ()),
      LPSeqC(Character(')'),
           PVar(IndexZ()))
      ))
    ))

    val dyckLanguage: GrammarNode[Unit, List[Char]] =
      Fix(Alt(
        PMap((x: Rep[Unit]) => List(), Eps()),
        LPSeqL(
          PMap((x: Rep[(List[Char], Char)]) => x._1 ++ List(x._2),
              PSeq(
              LPSeqC(Character('('), PVar(IndexZ())),
              Character(')'))
          ),
          PVar(IndexZ())
        )
      ))

    val simpleBrackets: GrammarNode[Unit, List[Char]] =
      Fix(Alt(
        PMap((x: Rep[Unit]) => List(), Eps()),
        PMap((x: Rep[(List[Char], Char)]) => x._1 ++ List(x._2),
              PSeq(
                LPSeqC(Character('('), PVar(IndexZ())),
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
