import combi._

import scalaz._
import Scalaz._
import org.scalatest.FlatSpec
import scala.lms.internal.ScalaCompile
import scala.language.reflectiveCalls
import java.io.PrintWriter
import java.io.File

trait UnembeddedTester {
  def testGeneratedParsers[T](p: (Int, String) => (Int, \/[String, T]), s: String) = {
    p(0, s)
  }
}

trait TestCompiler extends ScalaCompile with DslExp
                   with TypeChecker with GrammarNodes
                   with DBVars with TypedGrammarNodes
                   with LMSDriver with StagedCombinators {
  self =>
  override val codegen = new DslGenScala {
    val IR: self.type = self
  }

  def printer[T:Typ](g: GrammarNode[Unit, T], className: String, fileName: String) = {
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(), g)
    for (typedG <- typedGM) codegen.emitSource2(ev(typedG) , className, new PrintWriter(new File("src/test/scala/generatedPrograms/" + fileName)))
    typedGM
  }

  def ev[T:Typ](g: TypedGrammarNode[Unit, T])(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, T])] = {
    parse(g, StagedParserEnv.CtxZ())(typ[T])(pos, s)
  }
}

class EpsSpec extends FlatSpec with UnembeddedTester {
  val p = new EpsParser()
  // This is a very poor way to do the testing (generated code will lag one behind!)
  // come back and do a better way if time allows
  val tester = new TestCompiler with EpsTest {
    val f = printer(g, "EpsParser", "epsPrograms.scala")
  }

  "The eps grammar" should "match the empty string" in {
    val (pos, r) = testGeneratedParsers(p, "")
    assertResult(().right)(r)
    assert(pos == 0)
  }

  "The eps grammar" should "not match a non-empty string" in {
    val (pos, r) = testGeneratedParsers(p, "a")
    assertResult(().right)(r)
    assert(pos == 0)
  }
}


class CharSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with CharTest {
    val f = printer(g, "CharParser", "charPrograms.scala")
  }

  val p = new CharParser()
  "The char(a) grammar" should "match the \"a\" string" in {
    val (pos, r) = testGeneratedParsers(p, "a")
    assertResult('a'.right)(r)
    assert(pos == 1)
  }

  "The char(a) grammar" should "not match the \"b\" string" in {
    val (pos, r) = testGeneratedParsers(p, "b")
    assertResult(-\/("Error: Expected a, got b."))(r)
    assert(pos == 0)
  }

  "The char(a) grammar" should "not match the \"\" string" in {
    val (pos, r) = testGeneratedParsers(p, "")
    assertResult(-\/("Error: Expected a, but reached end of input."))(r)
    assert(pos == 0)
  }
}


class PSeqSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with PSeqTest {
    val f = printer(g, "SeqParser", "seqPrograms.scala")
  }

  val p = new SeqParser()

  "The seq(ab) grammar" should "match the \"ab\" string" in {
    val (pos, r) = testGeneratedParsers(p,  "ab")
    assertResult(('a', 'b').right)(r)
    assert(pos == 2)
  }

  "The seq(ab) grammar" should "not match the \"a\" string" in {
    val (pos, r) = testGeneratedParsers(p, "a")
    assertResult(-\/("Error: Expected b, but reached end of input."))(r)
    assert(pos == 1)
  }
}


class AltSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with AltTest {
    val f = printer(g, "AltParser", "altPrograms.scala")
  }
  val p = new AltParser()

  "The a|b grammar" should "match the \"a\" string" in {
    val (pos, r) = testGeneratedParsers(p,  "a")
    assertResult('a'.right)(r)
    assert(pos == 1)
  }

  "The a|b grammar" should "match the \"b\" string" in {
    val (pos, r) = testGeneratedParsers(p,  "b")
    assertResult('b'.right)(r)
    assert(pos == 1)
  }

  "The a|b grammar" should "not match the \"c\" string" in {
    val (pos, r) = testGeneratedParsers(p,  "c")
    assertResult(-\/("Error: Token c matches neither possible branch."))(r)
    assert(pos == 0)
  }
}

class ExampleSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with SimpleFixExample {
    val f = printer(g, "ExampleParser", "example.scala")
  }

  val p = new ExampleParser2()

  "The E ::= | aE grammar" should "match aaaa" in {
    val (pos, r) = testGeneratedParsers(p, "aaaa")
    assertResult(List('a', 'a', 'a', 'a').right)(r)
    assert(pos == 4)
  }

  "The E ::= | aE grammar" should "not match aaaba" in {
    val (pos, r) = testGeneratedParsers(p, "aaaba")
    assertResult(List('a', 'a', 'a').right)(r)
    assert(pos == 3)
  }

}

class CompoundSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with CompoundTest {
    val f = printer(g, "CompoundParser", "compoundPrograms1.scala")
  }

  val p = new CompoundParser()

  "The a(b|c) grammar" should "match the ab string" in {
    val (pos, r) = testGeneratedParsers(p,  "ab")
    assertResult(('a', 'b').right)(r)
    assert(pos == 2)
  }

  "The a(b|c) grammar" should "match the ac string" in {
    val (pos, r) = testGeneratedParsers(p,  "ac")
    assertResult(('a', 'c').right)(r)
    assert(pos == 2)
  }

  "The a(b|c) grammar" should "not match the ad string" in {
    val (pos, r) = testGeneratedParsers(p,  "ad")
    assertResult(-\/("Error: Token d matches neither possible branch."))(r)
    assert(pos == 1)
  }
}

class ExpansionSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with ExpansionTest {
    val f = printer(g, "ExpansionParser", "expansion.scala")
  }

  val p = new ExpansionParser()

  "The ab | c grammar" should "not match the ac string" in {
    val (pos, r) = testGeneratedParsers(p, "ac")
    assertResult(-\/("Error: Expected b, got c."))(r)
    assert(pos == 1)
  }
}

class ExpansionSpec2 extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with ExpansionTest2 {
    val f = printer(g, "ExpansionParser2", "expansion2.scala")
  }

  val p = new ExpansionParser2()

  "The (a|b)c grammar" should "not match the ab string" in {
    val (pos, r) = testGeneratedParsers(p, "ab")
    assertResult(-\/("Error: Expected c, got b."))(r)
    assert(pos == 1)
  }
}



class StarSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with StarTest {
    val f = printer(g, "StarParser", "starPrograms.scala")
  }

  val p = new StarParser()

  "The a* grammar" should "match the aaa string" in {
    val (pos, r) = testGeneratedParsers(p,  "aaa")
    assertResult(List('a', 'a', 'a').right)(r)
    assert(pos == 3)
  }

  "The a* grammar" should "match the \"\"" in {
    val (pos, r) = testGeneratedParsers(p,  "")
    assertResult(List().right)(r)
    assert(pos == 0)
  }

  "The a* grammar" should "not match the b string" in {
    val (pos, r) = testGeneratedParsers(p,  "b")
    assertResult(List().right)(r)
    assert(pos == 0)
  }
}

class AmbigousSpec extends FlatSpec with UnembeddedTester {
  // TODO: More examples of ambigous grammars
  val tester = new TestCompiler with AmbigousTests {
    val f = printer(g, "IncorrectParser", "ambigPrograms.scala")
  }

  "The ab|ac grammar" should "not typecheck" in {
    assertResult(-\/("Type Error: The alternatives PSeq(Character(a),Character(b)) and PSeq(Character(a),Character(c)) are ambiguous."))(tester.f)
  }
}

class FixSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with FixTests {
    val f = printer(g, "acbEParser", "acbEProgram.scala")
    val f2 = printer(bracketsAGrammar, "BracketsAParser", "bracketsAProgram.scala")
    val f3 = printer(simpleBrackets, "SimpleBrackets", "simpleBracketsProgram.scala")
    val f4 = printer(dyckLanguage, "DyckParser", "dyckProgram.scala")
  }

  val p = new acbEParser()
  val bracketsA = new BracketsAParser()
  val simpleBrackets = new SimpleBrackets()
  val dyckParser = new DyckParser()

  "The E ::= ac | bE grammar" should "match bbac" in {
    val (pos, r) = testGeneratedParsers(p, "bbac")
    assertResult(List('b', 'b', 'a', 'c').right)(r)
    assert(pos == 4)
  }

  "The E ::= ac | bE grammar" should "match ac" in {
    val (pos, r) = testGeneratedParsers(p, "ac")
    assertResult(List('a', 'c').right)(r)
    assert(pos == 2)
  }

  "The E ::= ac | bE grammar" should "not match ab" in {
    val (pos, r) = testGeneratedParsers(p, "ab")
    assertResult(-\/("Error: Expected c, got b."))(r)
    assert(pos == 1)
  }

  "The a-brackets grammar" should "match (a)" in {
    val s: String = "(a)a"
    val (pos, r) = testGeneratedParsers(bracketsA, s)
    assertResult(s.toList.right)(r)
    assert(pos == 4)
  }

  "The a-brackets grammar" should "match ((a)a)a(a)a((a)a)a" in {
    val s: String = "((a)a)(a)((a)a)a"
    val (pos, r) = testGeneratedParsers(bracketsA, s)
    assertResult(s.toList.right)(r)
    assert(pos == s.length)
  }

  "The brackets grammar" should "match ((()))" in {
    val s: String = "((()))"
    val (pos, r) = testGeneratedParsers(simpleBrackets, s)
    assertResult(s.toList.right)(r)
    assert(pos == s.length)
  }

  "The brackets grammar" should "match (())" in {
    val s: String = "(())"
    val (pos, r) = testGeneratedParsers(simpleBrackets, s)
    assertResult(s.toList.right)(r)
    assert(pos == s.length)
  }

  "The brackets grammar" should "not match ((())" in {
    val s: String = "((())"
    val (pos, r) = testGeneratedParsers(simpleBrackets, s)
    assertResult(-\/("Error: Expected ), but reached end of input."))(r)
    assert(pos == s.length)
  }

  "The Dyck grammar" should "match ((()))" in {
    val s: String = "((()))"
    val (pos, r) = testGeneratedParsers(dyckParser, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(pos == s.length)
  }

  "The Dyck grammar" should "match (()())()()((()())())()" in {
    val s: String = "(()())()()((()())())()"
    val (pos, r) = testGeneratedParsers(dyckParser, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(pos == s.length)
  }

  "The Dyck grammar" should "not match (()()))" in {
    val s: String = "(()()))"
    val (pos, r) = testGeneratedParsers(dyckParser, s)
    assertResult(augmentString("(()())").toList.right)(r)
    assert(pos == 6)
  }

  "The Dyck grammar" should "not match (()())(()" in {
    val s: String = "(()())(()"
    val (pos, r) = testGeneratedParsers(dyckParser, s)
    assertResult(-\/("Error: Expected ), but reached end of input."))(r)
    assert(pos == s.length)
  }
}
