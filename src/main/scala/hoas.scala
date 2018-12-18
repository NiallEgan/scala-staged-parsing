package combi

import scalaz._
import Scalaz._
import scala.language.postfixOps

trait Hoas extends Env {
  // TODO: Remove this by changing the type checker and parser to use a
  // denotational meaning
  override type T[X] = Unit

  def tshift[A, I, J](c1: Context[J], c2: Context[(A, I)]): DBVar[J, A] = {
    def tshift_[A, I, J](n: Int, j: Context[J],
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
  class GrammarNodeOps[Ctx, T](g: D[Ctx, T]) {
    def ~[U](o: D[Ctx, U]): D[Ctx, (T, U)] =
      (con: Context[Ctx]) => Seq(g(con), o(con))
    def ~(o: Char): D[Ctx, (T, Char)] =
      (con: Context[Ctx]) => Seq(g(con), Character(o))
    def <|>(o: D[Ctx, T]): D[Ctx, T] =
      (con: Context[Ctx]) => Alt(g(con), o(con))

    def ?? : D[Ctx, \/[Unit, T]] = {
      (con: Context[Ctx]) => Alt(
          PMap((x:Unit) => x.left[T], Eps()),
          PMap((x:T) => x.right[Unit], g(con))
        )
    }
    def ** : D[Ctx, List[T]] =
      (con: Context[Ctx]) => Star(g(con))
    def ^^[U](f: T => U): D[Ctx, U] =
      (con: Context[Ctx]) => PMap(f, g(con))

    //def >>=[U](f: T => GrammarNode[U]
  }

  class GrammarNodeOpsChar[Ctx](g: D[Ctx, Char]) {
    def <|>(o: Char): D[Ctx, Char] =
      (con: Context[Ctx]) => Alt(g(con), Character(o))
  }

  implicit def gnToOps[Ctx, T](g: D[Ctx, T]) = new GrammarNodeOps(g)

  implicit def charToGNode[Ctx](c: Char): D[Ctx, Char] =
    (_: Context[Ctx]) => Character(c)

  implicit def charToGNodeOps[Ctx](c: Char): GrammarNodeOps[Ctx, Char] =
    new GrammarNodeOps((_: Context[Ctx]) => Character(c))
  // TODO: A string version?

  def eps[Ctx]: D[Ctx, Unit] =
    (_: Context[Ctx]) => Eps()
  def fix[Ctx, T](f: D[(T, Ctx), T] => D[(T, Ctx), T]): D[Ctx, T] = {
    (i: Context[Ctx]) => Fix(
        f((j: Context[(T, Ctx)]) => Var(tshift(j, CtxS[Ctx, T]((), i))))(CtxS[Ctx, T]((), i))
    )
  }

  def parse[T](g: D[Unit, T], s: String) = {
    val it = Iterator.tabulate(s.length)(i => s(i)).buffered
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(), g(CtxZ()))
    val r = (for(typedG <- typedGM)
            yield Parser.parse(typedG, ParserEnv.CtxZ())(it)).join
    (r, it)
  }
}
