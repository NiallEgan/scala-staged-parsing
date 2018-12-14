package combi

import scala.language.higherKinds

import scalaz._
import Scalaz._

sealed abstract class DBVar[Ctx, A]
case class IndexZ[Ctx, A]() extends DBVar[(A, Ctx), A]
case class IndexS[Ctx, A, B](n: DBVar[Ctx, A]) extends DBVar[(B, Ctx), A]

trait Env {
  type T[_]

  sealed abstract class Context[Ctx]
  case class CtxZ() extends Context[Unit]
  case class CtxS[Ctx, A](hd: T[A], tl: Context[Ctx]) extends Context[(A, Ctx)]

  def find[Ctx, A](v: DBVar[Ctx, A], env: Context[Ctx]): T[A] = (v, env) match {
    case (IndexZ(), CtxS(x, _)) => x
    case (IndexS(n), CtxS(_, xs)) => find(n, xs)
  }

  def add[Ctx, A](v: T[A], env: Context[Ctx]) = CtxS[Ctx, A](v, env)

}
