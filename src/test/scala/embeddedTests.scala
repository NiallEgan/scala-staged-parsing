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
    assertResult(g)(getClosedTerm(('a' ~ 'b') <|> ('a' ~ 'c')))
  
  }
}
