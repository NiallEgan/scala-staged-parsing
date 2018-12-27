import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class AltParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, Char])) {
def apply(x0:scala.collection.BufferedIterator[Char]): \/[java.lang.String, Char] = {
val x1 = x0.hasNext
val x37 = if (x1) {
val x2 = x0.head
val x3 = 'a' == x2
val x34 = if (x3) {
val x14 = if (x1) {
val x4 = x2 == 'a'
val x11 = if (x4) {
val x5 = x0.next()
val x6 = x5.right[java.lang.String]
x6
} else {
val x8 = "Error: Expected a, got "+x2
val x9 = x8+"."
val x10 = x9.left[Char]
x10
}
x11
} else {
val x13 = "Error: Expected a, but reached end of input.".left[Char]
x13
}
x14
} else {
val x16 = 'b' == x2
val x32 = if (x16) {
val x27 = if (x1) {
val x17 = x2 == 'b'
val x24 = if (x17) {
val x18 = x0.next()
val x19 = x18.right[java.lang.String]
x19
} else {
val x21 = "Error: Expected b, got "+x2
val x22 = x21+"."
val x23 = x22.left[Char]
x23
}
x24
} else {
val x26 = "Error: Expected b, but reached end of input.".left[Char]
x26
}
x27
} else {
val x29 = "Error: Token "+x2
val x30 = x29+" matches neither possible branch."
val x31 = x30.left[Char]
x31
}
x32
}
x34
} else {
val x36 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
x36
}
x37
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
