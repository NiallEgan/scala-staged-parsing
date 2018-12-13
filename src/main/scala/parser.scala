import scalaz._
import Scalaz._

object ParserEnv extends Env {
  override type T[X] = Id[X]
}

object Parser {
  def parse[Ctx, T](exp: TypedGrammarNode[Ctx, T], con: ParserEnv.Context[Ctx]): TypedParser[T] = {
    // TODO: This isn't very nice...
    val nullable = exp.tp.nullable
    val firstSet = exp.tp.first
    exp match {
      case TEps(_) => new EpsParser(nullable, firstSet)
      case TAlt(_, left, right) => {
        new AltParser(nullable, firstSet, parse(left, con), parse(right, con))
      }
      case TSeq(_, left, right) => {
        new SeqParser(nullable, firstSet, parse(left, con), parse(right, con))
      }
      case TCharacter(_, c) => new CharParser(nullable, firstSet, c)
      case TBot(_) => new BottomParser(nullable, firstSet)
      case TStar(_, a) => {
        new StarParser(nullable, firstSet, parse(a, con))
      }
      case TVar(_, n) => ParserEnv.find(n, con)
      case TPMap(_, f, a) => new MapParser(nullable, firstSet, parse(a, con), f)
    }
  }
}
