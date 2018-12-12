import scalaz._
import Scalaz._

object ParserEnv extends Env {
  override type T[X] = Id[X]
}

object Parser {
  def parse[Ctx, T](exp: GrammarNode[Ctx, T], con: ParserEnv.T[Ctx]): TypedParser[T] = ???
}
