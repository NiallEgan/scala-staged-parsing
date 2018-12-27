import combi._

import scalaz._
import Scalaz._


trait EpsTest extends GrammarNodes with LMSDriver {
  val g: GrammarNode[Unit, Unit] = Eps()
}

trait CharTest extends GrammarNodes with LMSDriver {
  val g: GrammarNode[Unit, Char] = Character('a')
}

trait PSeqTest extends GrammarNodes with LMSDriver {
  val g: GrammarNode[Unit, (Char, Char)] = PSeq(Character('a'), Character('b'))
}

trait AltTest extends GrammarNodes with LMSDriver {
  val g: GrammarNode[Unit, Char] = Alt(Character('a'), Character('b'))
}

trait CompoundTest extends GrammarNodes with LMSDriver {
  val g: GrammarNode[Unit, (Char, Char)] =
    PSeq(Character('a'), Alt(Character('b'), Character('c')))
}

trait StarTest extends GrammarNodes with LMSDriver {
  val g: GrammarNode[Unit, List[Char]] =
    Star(Character('a'))
}

trait CompoundTest2 extends GrammarNodes with LMSDriver {
  val left: GrammarNode[Unit, (Char, Char)] =
    PSeq(Character('a'), Character('b'))
  val right: GrammarNode[Unit, (Char, Char)] =
    PSeq(Character('a'), Character('c'))
  val g: GrammarNode[Unit, (Char, Char)] =
     Alt(left, right)
}

trait AmbigousTests extends GrammarNodes with LMSDriver {
  // TODO: More examples of ambigous grammars
  val left: GrammarNode[Unit, (Char, Char)] =
    PSeq(Character('a'), Character('b'))
  val right: GrammarNode[Unit, (Char, Char)] =
    PSeq(Character('a'), Character('c'))
  val g: GrammarNode[Unit, (Char, Char)] =
     Alt(left, right)
}

trait FixTests extends GrammarNodes with LMSDriver {
  val g: GrammarNode[Unit, List[Char]] =
    Fix(Alt(
      PMap(
        (x: Rep[(Char, Char)]) => List(x._1, x._2),
        PSeq(Character('a'), Character('c'))),
      PMap(
        (x: Rep[(Char, List[Char])]) => x._1::x._2,
        PSeq(Character('b'), PVar(IndexZ())))
      ))

  def LPSeqC[Ctx](a: GrammarNode[Ctx, Char],
                 b: GrammarNode[Ctx, List[Char]]) = {
    PMap((x: Rep[(Char, List[Char])]) => x._1::x._2,
         PSeq(a, b))
  }

  def LPSeqL[Ctx](a: GrammarNode[Ctx, List[Char]],
                 b: GrammarNode[Ctx, List[Char]]) = {
    PMap((x: Rep[(List[Char], List[Char])]) => x._1 ++ x._2,
         PSeq(a, b))
  }

  val bracketsAGrammar: GrammarNode[Unit, List[Char]] =
    Fix(Alt(
      PMap((x: Rep[Char]) => List(x), Character('a')),
      LPSeqC(Character('('),
      LPSeqL(PVar(IndexZ()),
      LPSeqC(Character(')'),
           PVar(IndexZ()))
      ))
    ))

    val dyckLanguage: GrammarNode[Unit, List[Char]] =
      Fix(Alt(
        PMap((x: Rep[Unit]) => List(), Eps()),
        LPSeqL(
          PMap((x: Rep[(List[Char], Char)]) => x._1 ++ List(x._2),
              PSeq(
              LPSeqC(Character('('), PVar(IndexZ())),
              Character(')'))
          ),
          PVar(IndexZ())
        )
      ))

    val simpleBrackets: GrammarNode[Unit, List[Char]] =
      Fix(Alt(
        PMap((x: Rep[Unit]) => List(), Eps()),
        PMap((x: Rep[(List[Char], Char)]) => x._1 ++ List(x._2),
              PSeq(
                LPSeqC(Character('('), PVar(IndexZ())),
                Character(')')
              )
        )
      ))

}
