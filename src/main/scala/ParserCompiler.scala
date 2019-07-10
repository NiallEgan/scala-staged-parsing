import combi._

import scalaz._
import Scalaz._
import org.scalatest.FlatSpec
import lms.{common => lms}
import scala.lms.internal.ScalaCompile
import scala.language.reflectiveCalls
import java.io.PrintWriter
import java.io.File
import scala.language.postfixOps

class Compiler extends ScalaCompile with DslExp
                   with TypeChecker with GrammarNodes
                   with DBVars with TypedGrammarNodes
                   with LMSDriver with StagedCombinators
                   with Hoas {
  self =>

  private def getClosedTerm[T](g: D[Unit, T]): GrammarNode[Unit, T] = {
    g(UnitEnv.CtxZ())
  }

  override val codegen = new DslGenScala {
    val IR: self.type = self
  }

  private def printer[T:Typ](g: GrammarNode[Unit, T], className: String, fileName: String) = {
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(), g)
    for (typedG <- typedGM) codegen.emitSource2(ev(typedG) , className, new PrintWriter(new File("src/test/scala/generatedPrograms/" + fileName)))
    typedGM
  }

  private def ev[T:Typ](g: TypedGrammarNode[Unit, T])(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, T])] = {
    parse(g, StagedParserEnv.CtxZ())(typ[T])(pos, s)
  }

  def compile[T:Typ](g: D[Unit, T], className: String, fileName: String): Unit = {
    printer(getClosedTerm(g), className, fileName)
  }
}

// Example
object abcCompiler extends Compiler {
  val parser: D[Unit, (Char, Char)] = 'a' ~ ('b' <|> 'c')
}
