import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class AltParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]] = {
val x2 = x1.length
val x3 = x0 < x2
val x34 = if (x3) {
val x4 = x1.charAt(x0)
val x5 = x4 == 'a'
val x31 = if (x5) {
val x16 = if (x3) {
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
} else {
val x17 = x4 == 'b'
val x30 = if (x17) {
val x25 = if (x3) {
val x22 = if (x17) {
val x6 = x0 + 1
val x7 = x4.right[java.lang.String]
val x8 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x6,x7)
x8
} else {
val x18 = "Error: Expected b, got "+x4
val x19 = x18+"."
val x20 = x19.left[Char]
val x21 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x20)
x21
}
x22
} else {
val x23 = "Error: Expected b, but reached end of input.".left[Char]
val x24 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x23)
x24
}
x25
} else {
val x26 = "Error: Token "+x4
val x27 = x26+" matches neither possible branch."
val x28 = x27.left[Char]
val x29 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x28)
x29
}
x30
}
x31
} else {
val x32 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
val x33 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x32)
x33
}
x34
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
