package combi

import scala.language.higherKinds

import scalaz._
import Scalaz._

trait DBVars {
  this: LMSDriver =>
  sealed abstract class DBVar[Ctx, A]
  case class IndexZ[Ctx, A]() extends DBVar[(A, Ctx), A]
  case class IndexS[Ctx, A, B](n: DBVar[Ctx, A]) extends DBVar[(B, Ctx), A]

  trait Env {
    type T[_]

    sealed abstract class Context[Ctx] {
      val length: Int
    }
    case class CtxZ() extends Context[Unit] {
      override val length = 0
    }
    case class CtxS[Ctx, A:Typ](hd: T[A], tl: Context[Ctx]) extends Context[(A, Ctx)] {
      override val length = 1 + tl.length
    }

    def find[Ctx, A:Typ](v: DBVar[Ctx, A], env: Context[Ctx]): T[A] = (v, env) match {
      case (IndexZ(), CtxS(x, _)) => x
      case (IndexS(n), CtxS(_, xs)) => find(n, xs)
    }

    def add[Ctx, A:Typ](v: T[A], env: Context[Ctx]) = CtxS[Ctx, A](v, env)

  }
}
