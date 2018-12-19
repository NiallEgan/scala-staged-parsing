package combi

import scalaz._
import Scalaz._

import scala.language.higherKinds



trait Parser[R[_]] extends TypedParsers[R] {
  object ParserEnv extends Env {
    override type T[X] = TypedParser[X]
  }
  
  def makeParser[Ctx, T](exp: TypedGrammarNode[Ctx, T], con: ParserEnv.Context[Ctx]): TypedParser[T] = {
    // TODO: This isn't very nice...
    val nullable = exp.tp.nullable
    val firstSet = exp.tp.first
    exp match {
      case TEps(_) => new EpsParser(nullable, firstSet)
      case TAlt(_, left, right) => {
        new AltParser(nullable, firstSet, makeParser(left, con), makeParser(right, con))
      }
      case TSeq(_, left, right) => {
        new SeqParser(nullable, firstSet, makeParser(left, con), makeParser(right, con))
      }
      case TCharacter(_, c) => new CharParser(nullable, firstSet, c)
      case TBot(_) => new BottomParser(nullable, firstSet)
      case TStar(_, a) => {
        new StarParser(nullable, firstSet, makeParser(a, con))
      }
      case TVar(_, n) => ParserEnv.find(n, con)
      case TPMap(_, f, a) => new MapParser(nullable, firstSet, makeParser(a, con), f)
      case p@TFix(_, a) => {
        lazy val p: TypedParser[T] = new FixParser(nullable, firstSet,
          it => makeParser(a, ParserEnv.add(p, con))(it))
        p
      }
    }
  }
}
