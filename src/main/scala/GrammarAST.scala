package combi

trait GrammarNodes extends DBVars {
  this: LMSDriver =>
  sealed abstract class GrammarNode[Ctx, T:Typ]
  case class Eps[Ctx]() extends GrammarNode[Ctx, Unit]
  case class Character[Ctx](c: Char) extends GrammarNode[Ctx, Char]
  case class Bot[Ctx]() extends GrammarNode[Ctx, Nothing]
  case class PSeq[Ctx, T:Typ, U:Typ](left: GrammarNode[Ctx, T], right: GrammarNode[Ctx, U]) extends GrammarNode[Ctx, (T, U)] {
    val leftTyp = implicitly[Typ[T]]
    val rightTyp = implicitly[Typ[U]]
  }
  case class Alt[Ctx, T:Typ](left: GrammarNode[Ctx, T], right: GrammarNode[Ctx, T]) extends GrammarNode[Ctx, T]
  case class Star[Ctx, T:Typ](a: GrammarNode[Ctx, T]) extends GrammarNode[Ctx, List[T]] {
    val innerTyp = implicitly[Typ[T]]
  }
  case class Fix[Ctx, T:Typ](a: GrammarNode[(T, Ctx), T]) extends GrammarNode[Ctx, T]
  case class PVar[Ctx, T:Typ](v: DBVar[Ctx, T]) extends GrammarNode[Ctx, T]
  case class PMap[Ctx, T:Typ, U:Typ](f: Rep[T] => Rep[U], a: GrammarNode[Ctx, T]) extends GrammarNode[Ctx, U] {
    val fromTyp = implicitly[Typ[T]]
    val toTyp = implicitly[Typ[U]]

    override def equals(that: Any): Boolean = that match {
      // A slightly weakened equality so that we can easily compare trees
      case PMap(_, that_a) => a == that_a
      case _ => false
    }
  }
}

trait TypedGrammarNodes extends DBVars {
  this: TypeChecker with LMSDriver =>
  sealed abstract class TypedGrammarNode[Ctx, T](val tp: ParserType)
  case class TEps[Ctx](typ: ParserType) extends TypedGrammarNode[Ctx, Unit](typ)
  case class TCharacter[Ctx](typ: ParserType, c: Char) extends TypedGrammarNode[Ctx, Char](typ)
  case class TBot[Ctx](typ: ParserType) extends TypedGrammarNode[Ctx, Nothing](typ)
  case class TPSeq[Ctx, T:Typ, U:Typ](typ: ParserType,
                                    left: TypedGrammarNode[Ctx, T],
                                    right: TypedGrammarNode[Ctx, U]) extends TypedGrammarNode[Ctx, (T, U)](typ) {
      val leftTyp = implicitly[Typ[T]]
      val rightTyp = implicitly[Typ[U]]
  }
  case class TAlt[Ctx, T:Typ](typ: ParserType,
                         left: TypedGrammarNode[Ctx, T],
                         right: TypedGrammarNode[Ctx, T]) extends TypedGrammarNode[Ctx, T](typ)
  case class TStar[Ctx, T:Typ](typ: ParserType, a: TypedGrammarNode[Ctx, T]) extends TypedGrammarNode[Ctx, List[T]](typ) {
    val innerTyp = implicitly[Typ[T]]
  }
  case class TFix[Ctx, T:Typ](typ: ParserType, a: TypedGrammarNode[(T, Ctx), T]) extends TypedGrammarNode[Ctx, T](typ)
  case class TVar[Ctx, T:Typ](typ: ParserType, v: DBVar[Ctx, T]) extends TypedGrammarNode[Ctx, T](typ)
  case class TPMap[Ctx, T:Typ, U:Typ](typ: ParserType, f: Rep[T] => Rep[U], a: TypedGrammarNode[Ctx, T]) extends TypedGrammarNode[Ctx, U](typ) {
    val fromTyp = implicitly[Typ[T]]
    val toTyp = implicitly[Typ[U]]
  }
}
