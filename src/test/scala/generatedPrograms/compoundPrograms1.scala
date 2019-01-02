import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class CompoundParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]])) {
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
val x33 = "Error: Expected b, but reached end of input.".left[Char]
val x43 = "Error: Expected c, but reached end of input.".left[Char]
val x52 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
val x64 = {(x17:Int,x18:Char) => 
val x19 = x17
val x21 = x19 < x2
val x54 = if (x21) {
val x22 = x1.charAt(x19)
val x23 = 'b' == x22
val x51 = if (x23) {
val x35 = if (x21) {
val x24 = x22 == 'b'
val x32 = if (x24) {
val x25 = x19 + 1
val x26 = x22.right[java.lang.String]
val x27 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x25,x26)
x27
} else {
val x28 = "Error: Expected b, got "+x22
val x29 = x28+"."
val x30 = x29.left[Char]
val x31 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x30)
x31
}
x32
} else {
val x34 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x33)
x34
}
x35
} else {
val x36 = 'c' == x22
val x50 = if (x36) {
val x45 = if (x21) {
val x37 = x22 == 'c'
val x42 = if (x37) {
val x25 = x19 + 1
val x26 = x22.right[java.lang.String]
val x27 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x25,x26)
x27
} else {
val x38 = "Error: Expected c, got "+x22
val x39 = x38+"."
val x40 = x39.left[Char]
val x41 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x40)
x41
}
x42
} else {
val x44 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x43)
x44
}
x45
} else {
val x46 = "Error: Token "+x22
val x47 = x46+" matches neither possible branch."
val x48 = x47.left[Char]
val x49 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x48)
x49
}
x50
}
x51
} else {
val x53 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x19,x52)
x53
}
val x20 = x18
val x62 = {(x55:Int,x56:Char) => 
val x57 = x55
val x58 = x56
val x59 = new Tuple2[Char, Char](x20,x58)
val x60 = x59.right[java.lang.String]
val x61 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x57,x60)
x61: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x63 = x54._2 match {
        case -\/(s) => (x54._1, -\/(s))
        case \/-(t) => x62(x54._1, t)
      }
x63: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x65 = x16._2 match {
        case -\/(s) => (x16._1, -\/(s))
        case \/-(t) => x64(x16._1, t)
      }
x65
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
