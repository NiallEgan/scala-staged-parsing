import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class StarParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, scala.collection.immutable.List[Char]])) {
def apply(x0:scala.collection.BufferedIterator[Char]): \/[java.lang.String, scala.collection.immutable.List[Char]] = {
val x1 = List()
val x2 = x1.right[java.lang.String]
var x3: \/[java.lang.String, scala.collection.immutable.List[Char]] = x2
val x21 = "Error: Expected a, but reached end of input.".left[Char]
val x31 = {x23: (Char) => 
val x24 = x3
val x28 = {x25: (scala.collection.immutable.List[Char]) => 
val x26 = x23 :: x25
val x27 = x26.right[java.lang.String]
x27: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x29 = x24 >>= x28
x29: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x35 = while ({val x4 = x0.hasNext
val x8 = if (x4) {
val x5 = x0.head
val x6 = 'a' == x5
x6
} else {
false
}
x8}) {
val x10 = x0.hasNext
val x22 = if (x10) {
val x11 = x0.head
val x12 = x11 == 'a'
val x19 = if (x12) {
val x13 = x0.next()
val x14 = x13.right[java.lang.String]
x14
} else {
val x16 = "Error: Expected a, got "+x11
val x17 = x16+"."
val x18 = x17.left[Char]
x18
}
x19
} else {
x21
}
val x32 = x22 >>= x31
x3 = x32
()
}
val x36 = x3
x36
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
