package combi

import lms.{common => lms}
import scalaz._
import Scalaz._
import java.io.PrintWriter


trait LMSDriver extends lms.PrimitiveOps with lms.BooleanOps
                with lms.Equal with EitherOps
                with lms.StringOps with lms.IfThenElse
                with BufferedIteratorOps with lms.TupleOps
                with lms.ListOps with lms.Functions
                with lms.Variables with lms.While
                with lms.ExceptionOps {
  implicit def nothingTyp: Typ[Nothing]

  def doLambdaMut[A:Typ, B:Typ](fun: Rep[A] => Rep[B]): Rep[A => B]
}

trait DslExp extends LMSDriver with lms.PrimitiveOpsExp with lms.BooleanOpsExpOpt
             with lms.EqualExp with EitherOpsExp
             with lms.StringOpsExp with lms.IfThenElseExpOpt
             with BufferedIteratorOpsExp with lms.TupleOpsExp
             with lms.ListOpsExpOpt with lms.FunctionsExp
             with lms.ArrayOpsExpOpt with lms.SeqOpsExp
             with lms.VariablesExp with lms.WhileExp
             with lms.ExceptionOpsExp {
  implicit def nothingTyp: Typ[Nothing] = manifestTyp

  override def doLambdaMut[A:Typ, B:Typ](fun: Exp[A] => Exp[B]): Exp[A => B] = {
    val x = reflectMutableSym(fresh[A])
    val y = reifyEffects(fun(x))

    Lambda(fun, x, y)
  }

  override def structName[A](m: Typ[A]) = m.runtimeClass.getSimpleName match {
    case "Tuple2" => f"Tuple2[${m.typeArguments(0).toString}, ${m.typeArguments(1).toString}]"
    case _ => super.structName(m)
  }
}

trait DslGenScala extends lms.ScalaGenPrimitiveOps
                  with lms.ScalaGenBooleanOps
                  with lms.ScalaGenEqual
                  with lms.ScalaGenStringOps
                  with lms.ScalaGenIfThenElse
                  with lms.ScalaGenTupleOps
                  with lms.ScalaGenListOps
                  with ScalaGenBufferedIteratorOps
                  with ScalaGenEitherOps
                  with lms.ScalaGenFunctions
                  with lms.ScalaGenArrayOps
                  with lms.ScalaGenSeqOps
                  with lms.ScalaGenVariables
                  with lms.ScalaGenWhile
                  with lms.ScalaGenExceptionOps {
    val IR: DslExp
    import IR._


    override def emitSource[T:Typ, R:Typ](f: Exp[T] => Exp[R],
        className: String, stream: PrintWriter): List[(Sym[Any], Any)] = {
      // This marks the second argument as mutable
      stream.println("import scalaz._")
      stream.println("import Scalaz._")
      val s1 = reflectMutableSym(fresh[T])
      val body = reifyBlock(f(s1))
      emitSource[R](s1::Nil, body, className, stream)
  }
}
