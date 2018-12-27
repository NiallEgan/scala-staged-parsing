import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class SeqParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, Tuple2[Char, Char]])) {
def apply(x0:scala.collection.BufferedIterator[Char]): \/[java.lang.String, Tuple2[Char, Char]] = {
val x1 = x0.hasNext
val x13 = if (x1) {
val x2 = x0.head
val x3 = x2 == 'a'
val x10 = if (x3) {
val x4 = x0.next()
val x5 = x4.right[java.lang.String]
x5
} else {
val x7 = "Error: Expected a, got "+x2
val x8 = x7+"."
val x9 = x8.left[Char]
x9
}
x10
} else {
val x12 = "Error: Expected a, but reached end of input.".left[Char]
x12
}
val x26 = "Error: Expected b, but reached end of input.".left[Char]
val x34 = {x14: (Char) => 
val x15 = x0.hasNext
val x27 = if (x15) {
val x16 = x0.head
val x17 = x16 == 'b'
val x24 = if (x17) {
val x18 = x0.next()
val x19 = x18.right[java.lang.String]
x19
} else {
val x21 = "Error: Expected b, got "+x16
val x22 = x21+"."
val x23 = x22.left[Char]
x23
}
x24
} else {
x26
}
val x31 = {x28: (Char) => 
val x29 = new Tuple2[Char, Char](x14,x28)
val x30 = x29.right[java.lang.String]
x30: \/[java.lang.String, Tuple2[Char, Char]]
}
val x32 = x27 >>= x31
x32: \/[java.lang.String, Tuple2[Char, Char]]
}
val x35 = x13 >>= x34
x35
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
