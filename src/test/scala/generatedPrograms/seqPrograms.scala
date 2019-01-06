import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class SeqParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]] = {
val x2 = x1.length
val x30 = "Error: Expected b, but reached end of input.".left[Char]
val x42 = {(x17:Int,x18:Char) => 
val x38 = {(x33:Int,x34:Char) => 
val x35 = new Tuple2[Char, Char](x18,x34)
val x36 = x35.right[java.lang.String]
val x37 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x33,x36)
x37: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x19 = x17 < x2
val x32 = if (x19) {
val x20 = x1.charAt(x17)
val x21 = x20 == 'b'
val x29 = if (x21) {
val x22 = x17 + 1
val x23 = x20.right[java.lang.String]
val x24 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x22,x23)
x24
} else {
val x25 = "Error: Expected b, got "+x20
val x26 = x25+"."
val x27 = x26.left[Char]
val x28 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x27)
x28
}
x29
} else {
val x31 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x30)
x31
}
val x39 = x32._1
val x40 = x32._2
val x41 = x40 match {
        case -\/(s) => (x39, -\/(s))
        case \/-(t) => x38(x39, t)
      }
x41: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x3 = x0 < x2
val x16 = if (x3) {
val x4 = x1.charAt(x0)
val x5 = x4 == 'a'
val x13 = if (x5) {
val x6 = x0 + 1
val x7 = x4.right[java.lang.String]
val x8 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x6,x7)
x8
} else {
val x9 = "Error: Expected a, got "+x4
val x10 = x9+"."
val x11 = x10.left[Char]
val x12 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x11)
x12
}
x13
} else {
val x14 = "Error: Expected a, but reached end of input.".left[Char]
val x15 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x14)
x15
}
val x43 = x16._1
val x44 = x16._2
val x45 = x44 match {
        case -\/(s) => (x43, -\/(s))
        case \/-(t) => x42(x43, t)
      }
x45
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
