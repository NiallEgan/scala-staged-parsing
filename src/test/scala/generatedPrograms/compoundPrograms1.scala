import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class CompoundParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, Tuple2[Char, Char]])) {
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
val x27 = "Error: Expected b, but reached end of input.".left[Char]
val x40 = "Error: Expected c, but reached end of input.".left[Char]
val x50 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
val x58 = {x14: (Char) => 
val x15 = x0.hasNext
val x51 = if (x15) {
val x16 = x0.head
val x17 = 'b' == x16
val x48 = if (x17) {
val x28 = if (x15) {
val x18 = x16 == 'b'
val x25 = if (x18) {
val x19 = x0.next()
val x20 = x19.right[java.lang.String]
x20
} else {
val x22 = "Error: Expected b, got "+x16
val x23 = x22+"."
val x24 = x23.left[Char]
x24
}
x25
} else {
x27
}
x28
} else {
val x30 = 'c' == x16
val x46 = if (x30) {
val x41 = if (x15) {
val x31 = x16 == 'c'
val x38 = if (x31) {
val x32 = x0.next()
val x33 = x32.right[java.lang.String]
x33
} else {
val x35 = "Error: Expected c, got "+x16
val x36 = x35+"."
val x37 = x36.left[Char]
x37
}
x38
} else {
x40
}
x41
} else {
val x43 = "Error: Token "+x16
val x44 = x43+" matches neither possible branch."
val x45 = x44.left[Char]
x45
}
x46
}
x48
} else {
x50
}
val x55 = {x52: (Char) => 
val x53 = new Tuple2[Char, Char](x14,x52)
val x54 = x53.right[java.lang.String]
x54: \/[java.lang.String, Tuple2[Char, Char]]
}
val x56 = x51 >>= x55
x56: \/[java.lang.String, Tuple2[Char, Char]]
}
val x59 = x13 >>= x58
x59
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
