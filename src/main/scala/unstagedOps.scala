package combi

import scalaz._
import Scalaz._

trait UnstagedOptionOps extends OptionOps[Id] {
  override def err[T](s: String): \/[String, T] = s.left[T]
  override def suc[T](r: T): \/[String, T] = r.right[String]
  override def o_bind[Le, Ri, B](o: \/[Le, Ri], f: Ri => \/[Le, B]): \/[Le, B] = o >>= f
  override def o_map[Le, Ri, B](o: \/[Le, Ri], f: Ri => B): \/[Le, B] = o.map(f)
}

trait UnstagedBIOps extends BIOps[Id] {
  override def b_head(b: BufferedIterator[Char]): Char = b.head
  override def b_hasNext(b: BufferedIterator[Char]): Boolean = b.hasNext
  override def b_next(b: BufferedIterator[Char]): Char = b.next()
}

trait UnstagedLiftOps extends LiftOps[Id] {
  override implicit def lift(u: Unit) = u
  override implicit def lift[T](l: List[T]) = l
}

trait UnstagedIfOps extends IfOps[Id] {
  override implicit def __ifThenElse[T](c: Boolean, thenp: => T, elsep: => T): T =
    if (c) thenp else elsep
}

trait UnstagedEqOps extends EqOps[Id] {
  override def c_eq(c: Char, o: Char): Boolean = c == o
}

trait UnstagedSetOps extends SetOps[Id] {
  override def s_contains(s: Set[Char], o: Char): Boolean =
    s.contains(o)
}


class Interpereter extends UnstagedOptionOps with UnstagedBIOps
                   with UnstagedLiftOps with UnstagedEqOps
                   with UnstagedSetOps with UnstagedIfOps
                   with Parser[Id] with Hoas {
  def parse[T](g: D[Unit, T], s: String) = {
    val it = Iterator.tabulate(s.length)(i => s(i)).buffered
    val typedGM = TypeChecker.pType(TypeEnv.CtxZ(), g(CtxZ()))
    val r = (for(typedG <- typedGM)
            yield makeParser(typedG, ParserEnv.CtxZ())(it)).join
    (r, it)
  }
}
