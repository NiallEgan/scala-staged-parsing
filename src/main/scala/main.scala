package combi
import scalaz._
import Scalaz._
import scala.lms.internal.ScalaCompile
import java.io.PrintWriter
import java.io.File

trait ParserProgram extends Hoas with LMSDriver with GrammarNodes

class Compiler extends ScalaCompile with DslExp
                   with TypeChecker with GrammarNodes
                   with DBVars with TypedGrammarNodes
                   with LMSDriver with StagedCombinators with Hoas {
  self =>
  override val codegen = new DslGenScala {
    val IR: self.type = self
  }

  def compile[T:Typ](g: D[Unit, T], className: String, fileName: String) = {
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(),  g(UnitEnv.CtxZ()))
    for (typedG <- typedGM) codegen.emitSource2(ev(typedG) , className, new PrintWriter(new File(fileName)))
    typedGM
  }

  def ev[T:Typ](g: TypedGrammarNode[Unit, T])(pos: Rep[Int], s: Rep[String]): Rep[(Int, \/[String, T])] = {
    parse(g, StagedParserEnv.CtxZ())(typ[T])(pos, s)
  }
}

trait ExampleProgram extends ParserProgram {
  val g: D[Unit, (Char, Char)] = 'a' ~ ('b' <|> 'c') // Change this
}

object Main {
  def main(args: Array[String]): Unit = {
   val p = new Compiler with ExampleProgram {
      compile(g, "ExampleProgramClass", "exampleFile.scala")
    }
  }
}
