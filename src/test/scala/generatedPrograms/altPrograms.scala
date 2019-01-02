import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class AltParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]] = {
val x2 = x1.length
val x3 = x0 < x2
val x36 = if (x3) {
val x4 = x1.charAt(x0)
val x5 = 'a' == x4
val x33 = if (x5) {
val x17 = if (x3) {
val x6 = x4 == 'a'
val x14 = if (x6) {
val x7 = x0 + 1
val x8 = x4.right[java.lang.String]
val x9 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x7,x8)
x9
} else {
val x10 = "Error: Expected a, got "+x4
val x11 = x10+"."
val x12 = x11.left[Char]
val x13 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x12)
x13
}
x14
} else {
val x15 = "Error: Expected a, but reached end of input.".left[Char]
val x16 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x15)
x16
}
x17
} else {
val x18 = 'b' == x4
val x32 = if (x18) {
val x27 = if (x3) {
val x19 = x4 == 'b'
val x24 = if (x19) {
val x7 = x0 + 1
val x8 = x4.right[java.lang.String]
val x9 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x7,x8)
x9
} else {
val x20 = "Error: Expected b, got "+x4
val x21 = x20+"."
val x22 = x21.left[Char]
val x23 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x22)
x23
}
x24
} else {
val x25 = "Error: Expected b, but reached end of input.".left[Char]
val x26 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x25)
x26
}
x27
} else {
val x28 = "Error: Token "+x4
val x29 = x28+" matches neither possible branch."
val x30 = x29.left[Char]
val x31 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x30)
x31
}
x32
}
x33
} else {
val x34 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
val x35 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x34)
x35
}
x36
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
