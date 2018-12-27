import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class StarParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, scala.collection.immutable.List[Char]])) {
def apply(x0:scala.collection.BufferedIterator[Char]): \/[java.lang.String, scala.collection.immutable.List[Char]] = {
val x1 = List()
val x2 = x1.right
var x3: \/[java.lang.String, scala.collection.immutable.List[Char]] = x2
val x20 = "Error: Expected a, but reached end of input.".left
val x30 = {x22: (Char) => 
val x23 = x3
val x27 = {x24: (scala.collection.immutable.List[Char]) => 
val x25 = x22 :: x24
val x26 = x25.right
x26: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x28 = x23 >>= x27
x28: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x34 = while ({val x4 = x0.hasNext
val x5 = x0.head
val x6 = 'a' == x5
val x7 = x4 && x6
x7}) {
val x9 = x0.hasNext
val x21 = if (x9) {
val x10 = x0.head
val x11 = x10 == 'a'
val x18 = if (x11) {
val x12 = x0.next()
val x13 = x12.right
x13
} else {
val x15 = "Error: Expected a, got "+x10
val x16 = x15+"."
val x17 = x16.left
x17
}
x18
} else {
x20
}
val x31 = x21 >>= x30
x3 = x31
()
}
val x35 = x3
x35
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
