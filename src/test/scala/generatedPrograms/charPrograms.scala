import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class CharParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]] = {
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
x16
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
