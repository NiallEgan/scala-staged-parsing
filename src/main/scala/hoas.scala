package combi

import scalaz._
import Scalaz._
import scala.language.postfixOps

trait Hoas extends DBVars {
  this: GrammarNodes with LMSDriver =>
  // TODO: Remove this by changing the type checker and parser to use a
  // denotational meaning
  object UnitEnv extends Env {
    override type T[X] = Unit
  }

  import UnitEnv._

  def tshift[A:Typ, I, J](c1: Context[J], c2: Context[(A, I)]): DBVar[J, A] = {
    def tshift_[A:Typ, I, J](n: Int, j: Context[J],
                         i: Context[(A, I)]): DBVar[J, A] = (j, i) match {
       case (CtxS(_, _), CtxS(_, _)) if n == 0 => {
         IndexZ().asInstanceOf[DBVar[J, A]] // TODO: Why is this needed?
       }
       case (CtxS(_, c1), c2) => {
         IndexS (tshift_(n-1, c1, c2))
       }
    }

    tshift_(c1.length - c2.length, c1, c2)
  }

  type D[Ctx, T] = Context[Ctx] => GrammarNode[Ctx, T]
  class GrammarNodeOps[Ctx, T:Typ](g: D[Ctx, T]) {
    def ~[U:Typ](o: D[Ctx, U]): D[Ctx, (T, U)] =
      (con: Context[Ctx]) => PSeq(g(con), o(con))
    def <|>(o: D[Ctx, T]): D[Ctx, T] =
      (con: Context[Ctx]) => Alt(g(con), o(con))
    def ?? : D[Ctx, \/[Unit, T]] = {
      (con: Context[Ctx]) => Alt(
          PMap((x:Rep[Unit]) => left[Unit, T](x), Eps()),
          PMap((x:Rep[T]) => right[Unit, T](x), g(con))
        )
    }
    def ** : D[Ctx, List[T]] =
      (con: Context[Ctx]) => Star(g(con))
    def ^^[U:Typ](f: Rep[T] => Rep[U]): D[Ctx, U] =
      (con: Context[Ctx]) => PMap(f, g(con))

    //def >>=[U](f: T => GrammarNode[U]
  }

  implicit def gnToOps[Ctx, T:Typ](g: D[Ctx, T]) = new GrammarNodeOps(g)

  implicit def charToGNode[Ctx](c: Char): D[Ctx, Char] =
    (_: Context[Ctx]) => Character[Ctx](c)

  implicit def charToGNodeOps[Ctx](c: Char): GrammarNodeOps[Ctx, Char] =
    new GrammarNodeOps((_: Context[Ctx]) => Character[Ctx](c))
  // TODO: A string version?

  def eps[Ctx]: D[Ctx, Unit] =
    (_: Context[Ctx]) => Eps()
  def fix[Ctx, T:Typ](f: D[(T, Ctx), T] => D[(T, Ctx), T]): D[Ctx, T] = {
    (i: Context[Ctx]) => Fix(
        f((j: Context[(T, Ctx)]) => PVar(tshift(j, CtxS[Ctx, T]((), i))))(CtxS[Ctx, T]((), i))
    )
  }


}
