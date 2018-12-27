import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class acbEParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, scala.collection.immutable.List[Char]])) {
def apply(x0:scala.collection.BufferedIterator[Char]): \/[java.lang.String, scala.collection.immutable.List[Char]] = {
val x4 = {x1: (scala.collection.BufferedIterator[Char]) => 
val x2 = throw new Exception("Bottom")
x2: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
var x5: scala.Function1[scala.collection.BufferedIterator[Char], \/[java.lang.String, scala.collection.immutable.List[Char]]] = x4
val x19 = "Error: Expected a, but reached end of input.".left[Char]
val x33 = "Error: Expected c, but reached end of input.".left[Char]
val x48 = {x43: (Tuple2[Char, Char]) => 
val x44 = x43._1
val x45 = x43._2
val x46 = List(x44,x45)
val x47 = x46.right[java.lang.String]
x47: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x61 = "Error: Expected b, but reached end of input.".left[Char]
val x79 = {x74: (Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x75 = x74._1
val x76 = x74._2
val x77 = x75 :: x76
val x78 = x77.right[java.lang.String]
x78: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x89 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x92 = {x6: (scala.collection.BufferedIterator[Char]) => 
val x7 = x6.hasNext
val x90 = if (x7) {
val x8 = x6.head
val x9 = 'a' == x8
val x87 = if (x9) {
val x20 = if (x7) {
val x10 = x8 == 'a'
val x17 = if (x10) {
val x11 = x6.next()
val x12 = x11.right[java.lang.String]
x12
} else {
val x14 = "Error: Expected a, got "+x8
val x15 = x14+"."
val x16 = x15.left[Char]
x16
}
x17
} else {
x19
}
val x41 = {x21: (Char) => 
val x22 = x6.hasNext
val x34 = if (x22) {
val x23 = x6.head
val x24 = x23 == 'c'
val x31 = if (x24) {
val x25 = x6.next()
val x26 = x25.right[java.lang.String]
x26
} else {
val x28 = "Error: Expected c, got "+x23
val x29 = x28+"."
val x30 = x29.left[Char]
x30
}
x31
} else {
x33
}
val x38 = {x35: (Char) => 
val x36 = new Tuple2[Char, Char](x21,x35)
val x37 = x36.right[java.lang.String]
x37: \/[java.lang.String, Tuple2[Char, Char]]
}
val x39 = x34 >>= x38
x39: \/[java.lang.String, Tuple2[Char, Char]]
}
val x42 = x20 >>= x41
val x49 = x42 >>= x48
x49
} else {
val x51 = 'b' == x8
val x85 = if (x51) {
val x62 = if (x7) {
val x52 = x8 == 'b'
val x59 = if (x52) {
val x53 = x6.next()
val x54 = x53.right[java.lang.String]
x54
} else {
val x56 = "Error: Expected b, got "+x8
val x57 = x56+"."
val x58 = x57.left[Char]
x58
}
x59
} else {
x61
}
val x72 = {x63: (Char) => 
val x64 = x5
val x65 = x64(x6)
val x69 = {x66: (scala.collection.immutable.List[Char]) => 
val x67 = new Tuple2[Char, scala.collection.immutable.List[Char]](x63,x66)
val x68 = x67.right[java.lang.String]
x68: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x70 = x65 >>= x69
x70: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x73 = x62 >>= x72
val x80 = x73 >>= x79
x80
} else {
val x82 = "Error: Token "+x8
val x83 = x82+" matches neither possible branch."
val x84 = x83.left[scala.collection.immutable.List[Char]]
x84
}
x85
}
x87
} else {
x89
}
x90: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
x5 = x92
val x94 = x5
val x95 = x94(x0)
x95
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
