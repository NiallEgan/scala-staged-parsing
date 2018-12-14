package combi

sealed abstract class GrammarNode[Ctx, T]
case class Eps[Ctx]() extends GrammarNode[Ctx, Unit]
case class Character[Ctx](c: Char) extends GrammarNode[Ctx, Char]
case class Bot[Ctx]() extends GrammarNode[Ctx, Nothing]
case class Seq[Ctx, T, U](left: GrammarNode[Ctx, T], right: GrammarNode[Ctx, U]) extends GrammarNode[Ctx, (T, U)]
case class Alt[Ctx, T](left: GrammarNode[Ctx, T], right: GrammarNode[Ctx, T]) extends GrammarNode[Ctx, T]
case class Star[Ctx, T](a: GrammarNode[Ctx, T]) extends GrammarNode[Ctx, List[T]]
case class Fix[Ctx, T](a: GrammarNode[(T, Ctx), T]) extends GrammarNode[Ctx, T]
case class Var[Ctx, T](v: DBVar[Ctx, T]) extends GrammarNode[Ctx, T]
case class PMap[Ctx, T, U](f: T => U, a: GrammarNode[Ctx, T]) extends GrammarNode[Ctx, U]

sealed abstract class TypedGrammarNode[Ctx, T](val tp: ParserType)
case class TEps[Ctx](typ: ParserType) extends TypedGrammarNode[Ctx, Unit](typ)
case class TCharacter[Ctx](typ: ParserType, c: Char) extends TypedGrammarNode[Ctx, Char](typ)
case class TBot[Ctx](typ: ParserType) extends TypedGrammarNode[Ctx, Nothing](typ)
case class TSeq[Ctx, T, U](typ: ParserType,
                          left: TypedGrammarNode[Ctx, T],
                          right: TypedGrammarNode[Ctx, U]) extends TypedGrammarNode[Ctx, (T, U)](typ)
case class TAlt[Ctx, T](typ: ParserType,
                       left: TypedGrammarNode[Ctx, T],
                       right: TypedGrammarNode[Ctx, T]) extends TypedGrammarNode[Ctx, T](typ)
case class TStar[Ctx, T](typ: ParserType, a: TypedGrammarNode[Ctx, T]) extends TypedGrammarNode[Ctx, List[T]](typ)
case class TFix[Ctx, T](typ: ParserType, a: TypedGrammarNode[(T, Ctx), T]) extends TypedGrammarNode[Ctx, T](typ)
case class TVar[Ctx, T](typ: ParserType, v: DBVar[Ctx, T]) extends TypedGrammarNode[Ctx, T](typ)
case class TPMap[Ctx, T, U](typ: ParserType, f: T => U, a: TypedGrammarNode[Ctx, T]) extends TypedGrammarNode[Ctx, U](typ)
