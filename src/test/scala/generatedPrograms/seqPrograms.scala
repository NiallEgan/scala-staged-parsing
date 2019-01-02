import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class SeqParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]] = {
val x2 = x1.length
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
val x32 = "Error: Expected b, but reached end of input.".left[Char]
val x44 = {(x17:Int,x18:Char) => 
val x19 = x17
val x21 = x19 < x2
val x34 = if (x21) {
val x22 = x1.charAt(x19)
val x23 = x22 == 'b'
val x31 = if (x23) {
val x24 = x19 + 1
val x25 = x22.right[java.lang.String]
val x26 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x24,x25)
x26
} else {
val x27 = "Error: Expected b, got "+x22
val x28 = x27+"."
val x29 = x28.left[Char]
val x30 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x29)
x30
}
x31
} else {
val x33 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x32)
x33
}
val x20 = x18
val x42 = {(x35:Int,x36:Char) => 
val x37 = x35
val x38 = x36
val x39 = new Tuple2[Char, Char](x20,x38)
val x40 = x39.right[java.lang.String]
val x41 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x37,x40)
x41: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x43 = x34._2 match {
        case -\/(s) => (x34._1, -\/(s))
        case \/-(t) => x42(x34._1, t)
      }
x43: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x45 = x16._2 match {
        case -\/(s) => (x16._1, -\/(s))
        case \/-(t) => x44(x16._1, t)
      }
x45
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
