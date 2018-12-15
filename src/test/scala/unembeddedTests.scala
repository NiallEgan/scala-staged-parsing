import combi._

import scalaz._
import Scalaz._
import org.scalatest.FlatSpec


trait UnembeddedTester {
  def test[T](g: GrammarNode[Unit, T], s: String) = {
    val it = Iterator.tabulate(s.length)(i => s(i)).buffered
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(), g)
    val r = (for(typedG <- typedGM)
            yield Parser.parse(typedG, ParserEnv.CtxZ())(it)).join
    (r, it)
  }
}

class EpsSpec extends FlatSpec with UnembeddedTester {
  "The eps grammar" should "match the empty string" in {
    val (r, it) = test(Eps(), "")
    assertResult(().right)(r)
    assert(!it.hasNext)
  }

  "The eps grammar" should "not match a non-empty string" in {
    val (r, it) = test(Eps(), "a")
    assertResult(().right)(r)
    assert(it.hasNext)
  }
}

class CharSpec extends FlatSpec with UnembeddedTester {
  "The char(a) grammar" should "match the \"a\" string" in {
    val (r, it) = test(Character('a'), "a")
    assertResult('a'.right)(r)
    assert(!it.hasNext)
  }

  "The char(a) grammar" should "not match the \"b\" string" in {
    val (r, it) = test(Character('a'), "b")
    assertResult(-\/("Error: Expected a, got b."))(r)
    assert(it.hasNext)
  }

  "The char(a) grammar" should "not match the \"\" string" in {
    val (r, it) = test(Character('a'), "")
    assertResult(-\/("Error: Expected a, but reached end of input."))(r)
    assert(!it.hasNext)
  }
}

class SeqSpec extends FlatSpec with UnembeddedTester {
  val g: GrammarNode[Unit, (Char, Char)] = Seq(Character('a'), Character('b'))
  "The seq(ab) grammar" should "match the \"ab\" string" in {
    val (r, it) = test(g,  "ab")
    assertResult(('a', 'b').right)(r)
    assert(!it.hasNext)
  }

  "The seq(ab) grammar" should "not match the \"a\" string" in {
    val (r, it) = test(g, "a")
    assertResult(-\/("Error: Expected b, but reached end of input."))(r)
    assert(!it.hasNext)
  }
}

class AltSpec extends FlatSpec with UnembeddedTester {
  val g: GrammarNode[Unit, Char] = Alt(Character('a'), Character('b'))
  "The a|b grammar" should "match the \"a\" string" in {
    val (r, it) = test(g,  "a")
    assertResult('a'.right)(r)
    assert(!it.hasNext)
  }

  "The a|b grammar" should "match the \"b\" string" in {
    val (r, it) = test(g,  "b")
    assertResult('b'.right)(r)
    assert(!it.hasNext)
  }

  "The a|b grammar" should "not match the \"c\" string" in {
    val (r, it) = test(g,  "c")
    assertResult(-\/("Error: Token c matches neither possible branch."))(r)
    assert(it.hasNext)
  }
}

class ComplexSpec extends FlatSpec with UnembeddedTester {
  // TODO: Eps????
  val g: GrammarNode[Unit, (Char, Char)] =
    Seq(Character('a'), Alt(Character('b'), Character('c')))

  "The a(b|c) grammar" should "match the ab string" in {
    val (r, it) = test(g,  "ab")
    assertResult(('a', 'b').right)(r)
    assert(!it.hasNext)
  }

  "The a(b|c) grammar" should "match the ac string" in {
    val (r, it) = test(g,  "ac")
    assertResult(('a', 'c').right)(r)
    assert(!it.hasNext)
  }

  "The a(b|c) grammar" should "not match the ad string" in {
    val (r, it) = test(g,  "ad")
    assertResult(-\/("Error: Token d matches neither possible branch."))(r)
    assert(it.hasNext)
  }
}

class StarSpec extends FlatSpec with UnembeddedTester {
  val g: GrammarNode[Unit, List[Char]] =
    Star(Character('a'))

  "The a* grammar" should "match the aaa string" in {
    val (r, it) = test(g,  "aaa")
    assertResult(List('a', 'a', 'a').right)(r)
    assert(!it.hasNext)
  }

  "The a* grammar" should "match the \"\"" in {
    val (r, it) = test(g,  "")
    assertResult(List().right)(r)
    assert(!it.hasNext)
  }

  "The a* grammar" should "not match the b string" in {
    val (r, it) = test(g,  "b")
    assertResult(List().right)(r)
    assert(it.hasNext)
  }
}

class AmbigousTests extends FlatSpec with UnembeddedTester {
  // TODO: More examples of ambigous grammars
  val left: GrammarNode[Unit, (Char, Char)] =
    Seq(Character('a'), Character('b'))
  val right: GrammarNode[Unit, (Char, Char)] =
    Seq(Character('a'), Character('c'))
  val g: GrammarNode[Unit, (Char, Char)] =
     Alt(left, right)

  "The ab|ac grammar" should "not typecheck" in {
    val (r, it) = test(g,  "ab")
    assertResult(-\/(f"Type Error: The alternatives $left and $right are ambiguous."))(r)
    assert(it.hasNext)
  }
}

class FixTests extends FlatSpec with UnembeddedTester {
  val g: GrammarNode[Unit, List[Char]] =
    Fix(Alt(
      PMap(
        (x: (Char, Char)) => List(x._1, x._2),
        Seq(Character('a'), Character('c'))),
      PMap(
        (x: (Char, List[Char])) => x._1::x._2,
        Seq(Character('b'), Var(IndexZ())))
      ))

  "The E ::= ac | bE grammar" should "match bbac" in {
    val (r, it) = test(g, "bbac")
    assertResult(List('b', 'b', 'a', 'c').right)(r)
    assert(!it.hasNext)
  }

  "The E ::= ac | bE grammar" should "match ac" in {
    val (r, it) = test(g, "ac")
    assertResult(List('a', 'c').right)(r)
    assert(!it.hasNext)
  }
}
