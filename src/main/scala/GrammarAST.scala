sealed abstract class GrammarNode
case class Eps extends GrammarNode
case class Character(c: Char) extends GrammarNode
case class Bot extends GrammarNode
case class Seq(left: GrammarNode, right: GrammarNode) extends GrammarNode
case class Alt(left: GrammarNode, right: GrammarNode) extends GrammarNode
case class Star(a: GrammarNode) extends GrammarNode
case class Fix(v: Var, a: GrammarNode) extends GrammarNode
case class Var(v: DBVar) extends GrammarNode
//case class Map(f: Grammar )
