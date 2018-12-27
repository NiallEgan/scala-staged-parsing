import combi._

import scalaz._
import Scalaz._
import org.scalatest.FlatSpec
import scala.lms.internal.ScalaCompile
import scala.language.reflectiveCalls
import java.io.PrintWriter
import java.io.File

trait UnembeddedTester {
  implicit def sToBufferedIterator(s: String): BufferedIterator[Char] = {
    Iterator.tabulate(s.length)(i => s(i)).buffered
  }

  def testGeneratedParsers[T](p: BufferedIterator[Char] => \/[String, T], s: String) = {
    val it = sToBufferedIterator(s)
    (p(it), it)
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

  def test[T:Typ](g: GrammarNode[Unit, T], it: BufferedIterator[Char]) = {
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(), g)
    val r = (for(typedG <- typedGM)
            yield compile(ev(typedG))(typ[BufferedIterator[Char]], typ[\/[String, T]])(it)).join
    (r, it)
  }

  def printer[T:Typ](g: GrammarNode[Unit, T], className: String, fileName: String) = {
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(), g)
    for (typedG <- typedGM) codegen.emitSource(ev(typedG) _, className, new PrintWriter(new File("src/test/scala/generatedPrograms/" + fileName)))
    typedGM
  }

  def ev[T:Typ](s: TypedGrammarNode[Unit, T])(it: Rep[BufferedIterator[Char]]): Rep[\/[String, T]] = {
    parse(s, StagedParserEnv.CtxZ())(typ[T])(it)
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
    val (r, it) = testGeneratedParsers(p, "")
    assertResult(().right)(r)
    assert(!it.hasNext)
  }

  "The eps grammar" should "not match a non-empty string" in {
    val (r, it) = testGeneratedParsers(p, "a")
    assertResult(().right)(r)
    assert(it.hasNext)
  }
}

class CharSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with CharTest {
    val f = printer(g, "CharParser", "charPrograms.scala")
  }
  val p = new CharParser()
  "The char(a) grammar" should "match the \"a\" string" in {
    val (r, it) = testGeneratedParsers(p, "a")
    assertResult('a'.right)(r)
    assert(!it.hasNext)
  }

  "The char(a) grammar" should "not match the \"b\" string" in {
    val (r, it) = testGeneratedParsers(p, "b")
    assertResult(-\/("Error: Expected a, got b."))(r)
    assert(it.hasNext)
  }

  "The char(a) grammar" should "not match the \"\" string" in {
    val (r, it) = testGeneratedParsers(p, "")
    assertResult(-\/("Error: Expected a, but reached end of input."))(r)
    assert(!it.hasNext)
  }
}

class PSeqSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with PSeqTest {
    val f = printer(g, "SeqParser", "seqPrograms.scala")
  }

  val p = new SeqParser()

  "The seq(ab) grammar" should "match the \"ab\" string" in {
    val (r, it) = testGeneratedParsers(p,  "ab")
    assertResult(('a', 'b').right)(r)
    assert(!it.hasNext)
  }

  "The seq(ab) grammar" should "not match the \"a\" string" in {
    val (r, it) = testGeneratedParsers(p, "a")
    assertResult(-\/("Error: Expected b, but reached end of input."))(r)
    assert(!it.hasNext)
  }
}

class AltSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with AltTest {
    val f = printer(g, "AltParser", "altPrograms.scala")
  }
  val p = new AltParser()

  "The a|b grammar" should "match the \"a\" string" in {
    val (r, it) = testGeneratedParsers(p,  "a")
    assertResult('a'.right)(r)
    assert(!it.hasNext)
  }

  "The a|b grammar" should "match the \"b\" string" in {
    val (r, it) = testGeneratedParsers(p,  "b")
    assertResult('b'.right)(r)
    assert(!it.hasNext)
  }

  "The a|b grammar" should "not match the \"c\" string" in {
    val (r, it) = testGeneratedParsers(p,  "c")
    assertResult(-\/("Error: Token c matches neither possible branch."))(r)
    assert(it.hasNext)
  }
}

class CompoundSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with CompoundTest {
    val f = printer(g, "CompoundParser", "compoundPrograms1.scala")
  }

  val p = new CompoundParser()

  "The a(b|c) grammar" should "match the ab string" in {
    val (r, it) = testGeneratedParsers(p,  "ab")
    assertResult(('a', 'b').right)(r)
    assert(!it.hasNext)
  }

  "The a(b|c) grammar" should "match the ac string" in {
    val (r, it) = testGeneratedParsers(p,  "ac")
    assertResult(('a', 'c').right)(r)
    assert(!it.hasNext)
  }

  "The a(b|c) grammar" should "not match the ad string" in {
    val (r, it) = testGeneratedParsers(p,  "ad")
    assertResult(-\/("Error: Token d matches neither possible branch."))(r)
    assert(it.hasNext)
  }
}

class StarSpec extends FlatSpec with UnembeddedTester {
  val tester = new TestCompiler with StarTest {
    val f = printer(g, "StarParser", "starPrograms.scala")
  }

  val p = new StarParser()

  "The a* grammar" should "match the aaa string" in {
    val (r, it) = testGeneratedParsers(p,  "aaa")
    assertResult(List('a', 'a', 'a').right)(r)
    assert(!it.hasNext)
  }

  "The a* grammar" should "match the \"\"" in {
    val (r, it) = testGeneratedParsers(p,  "")
    assertResult(List().right)(r)
    assert(!it.hasNext)
  }

  "The a* grammar" should "not match the b string" in {
    val (r, it) = testGeneratedParsers(p,  "b")
    assertResult(List().right)(r)
    assert(it.hasNext)
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
    val (r, it) = testGeneratedParsers(p, "bbac")
    assertResult(List('b', 'b', 'a', 'c').right)(r)
    assert(!it.hasNext)
  }

  "The E ::= ac | bE grammar" should "match ac" in {
    val (r, it) = testGeneratedParsers(p, "ac")
    assertResult(List('a', 'c').right)(r)
    assert(!it.hasNext)
  }

  "The E ::= ac | bE grammar" should "not match ab" in {
    val (r, it) = testGeneratedParsers(p, "ab")
    assertResult(-\/("Error: Expected c, got b."))(r)
    assert(it.hasNext)
  }

  "The a-brackets grammar" should "match (a)" in {
    val s: String = "(a)a"
    val (r, it) = testGeneratedParsers(bracketsA, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(!it.hasNext)
  }

  "The a-brackets grammar" should "match ((a)a)a(a)a((a)a)a" in {
    val s: String = "((a)a)(a)((a)a)a"
    val (r, it) = testGeneratedParsers(bracketsA, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(!it.hasNext)
  }

  "The brackets grammar" should "match ((()))" in {
    val s: String = "((()))"
    val (r, it) = testGeneratedParsers(simpleBrackets, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(!it.hasNext)
  }

  "The brackets grammar" should "match (())" in {
    val s: String = "(())"
    val (r, it) = testGeneratedParsers(simpleBrackets, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(!it.hasNext)
  }

  "The brackets grammar" should "not match ((())" in {
    val s: String = "((())"
    val (r, it) = testGeneratedParsers(simpleBrackets, s)
    assertResult(-\/("Error: Expected ), but reached end of input."))(r)
    assert(!it.hasNext)
  }

  "The Dyck grammar" should "match ((()))" in {
    val s: String = "((()))"
    val (r, it) = testGeneratedParsers(dyckParser, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(!it.hasNext)
  }

  "The Dyck grammar" should "match (()())()()((()())())()" in {
    val s: String = "(()())()()((()())())()"
    val (r, it) = testGeneratedParsers(dyckParser, s)
    assertResult(augmentString(s).toList.right)(r)
    assert(!it.hasNext)
  }

  "The Dyck grammar" should "not match (()()))" in {
    val s: String = "(()()))"
    val (r, it) = testGeneratedParsers(dyckParser, s)
    assertResult(augmentString("(()())").toList.right)(r)
    assert(it.hasNext)
  }

  "The Dyck grammar" should "not match (()())(()" in {
    val s: String = "(()())(()"
    val (r, it) = testGeneratedParsers(dyckParser, s)
    assertResult(-\/("Error: Expected ), but reached end of input."))(r)
    assert(!it.hasNext)
  }
}
