package combi

import lms.{common => lms}


trait BufferedIteratorOps extends lms.Base {
  implicit def biTyp[T:Typ]: Typ[BufferedIterator[T]]
  def buf_head[T:Typ](b: Rep[BufferedIterator[T]]): Rep[T]
  def buf_hasNext[T:Typ](b: Rep[BufferedIterator[T]]): Rep[Boolean]
  def buf_next[T:Typ](b: Rep[BufferedIterator[T]]): Rep[T]

  implicit class BufferedIteratorOpsCls[T:Typ](b: Rep[BufferedIterator[T]]) {
    def head() = buf_head(b)
    def hasNext() = buf_hasNext(b)
    def next() = buf_next(b)
  }
}

trait BufferedIteratorOpsExp extends BufferedIteratorOps with lms.EffectExp with lms.BooleanOpsExp {
  case class BufferHead[T:Typ](b: Exp[BufferedIterator[T]]) extends Def[T]
  case class BufferNext[T:Typ](b: Exp[BufferedIterator[T]]) extends Def[T]
  case class BufferHasNext[T:Typ](b: Exp[BufferedIterator[T]]) extends Def[Boolean]


  override implicit def biTyp[T:Typ] = {
    implicit val ManifestTyp(m) = typ[T]
    manifestTyp
  }

  override def buf_head[T:Typ](b: Exp[BufferedIterator[T]]): Exp[T] = {
    BufferHead(b)
  }

  override def buf_hasNext[T:Typ](b: Exp[BufferedIterator[T]]): Exp[Boolean] = {
    BufferHasNext(b)
  }

  override def buf_next[T:Typ](b: Exp[BufferedIterator[T]]): Exp[T] = {
    reflectWrite(b)(BufferNext(b))
  }
}

trait ScalaGenBufferedIteratorOps extends lms.ScalaGenBase {
  val IR: BufferedIteratorOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case BufferHead(b) => emitValDef(sym, src"$b.head")
    case BufferHasNext(b) => emitValDef(sym, src"$b.hasNext")
    case BufferNext(b) => emitValDef(sym, src"$b.next()")
    case _ => super.emitNode(sym, rhs)

  }
}
