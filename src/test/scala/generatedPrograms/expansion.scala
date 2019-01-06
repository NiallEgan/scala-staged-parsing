import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class ExpansionParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]] = {
val x8 = x1.length
val x9 = x0 < x8
val x72 = if (x9) {
val x10 = x1.charAt(x0)
val x11 = x10 == 'a'
val x69 = if (x11) {
val x36 = "Error: Expected b, but reached end of input.".left[Char]
val x48 = {(x23:Int,x24:Char) => 
val x44 = {(x39:Int,x40:Char) => 
val x41 = new Tuple2[Char, Char](x24,x40)
val x42 = x41.right[java.lang.String]
val x43 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x39,x42)
x43: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x25 = x23 < x8
val x38 = if (x25) {
val x26 = x1.charAt(x23)
val x27 = x26 == 'b'
val x35 = if (x27) {
val x28 = x23 + 1
val x29 = x26.right[java.lang.String]
val x30 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x28,x29)
x30
} else {
val x31 = "Error: Expected b, got "+x26
val x32 = x31+"."
val x33 = x32.left[Char]
val x34 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x23,x33)
x34
}
x35
} else {
val x37 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x23,x36)
x37
}
val x45 = x38._1
val x46 = x38._2
val x47 = x46 match {
        case -\/(s) => (x45, -\/(s))
        case \/-(t) => x44(x45, t)
      }
x47: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x22 = if (x9) {
val x19 = if (x11) {
val x12 = x0 + 1
val x13 = x10.right[java.lang.String]
val x14 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x12,x13)
x14
} else {
val x15 = "Error: Expected a, got "+x10
val x16 = x15+"."
val x17 = x16.left[Char]
val x18 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x17)
x18
}
x19
} else {
val x20 = "Error: Expected a, but reached end of input.".left[Char]
val x21 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x20)
x21
}
val x49 = x22._1
val x50 = x22._2
val x51 = x50 match {
        case -\/(s) => (x49, -\/(s))
        case \/-(t) => x48(x49, t)
      }
x51
} else {
val x52 = x10 == 'c'
val x68 = if (x52) {
val x7 = {(x2:Int,x3:Char) => 
val x4 = new Tuple2[Char, Char](x3,x3)
val x5 = x4.right[java.lang.String]
val x6 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x2,x5)
x6: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x60 = if (x9) {
val x57 = if (x52) {
val x12 = x0 + 1
val x13 = x10.right[java.lang.String]
val x14 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x12,x13)
x14
} else {
val x53 = "Error: Expected c, got "+x10
val x54 = x53+"."
val x55 = x54.left[Char]
val x56 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x55)
x56
}
x57
} else {
val x58 = "Error: Expected c, but reached end of input.".left[Char]
val x59 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x58)
x59
}
val x61 = x60._1
val x62 = x60._2
val x63 = x62 match {
        case -\/(s) => (x61, -\/(s))
        case \/-(t) => x7(x61, t)
      }
x63
} else {
val x64 = "Error: Token "+x10
val x65 = x64+" matches neither possible branch."
val x66 = x65.left[Tuple2[Char, Char]]
val x67 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x0,x66)
x67
}
x68
}
x69
} else {
val x70 = "Error: End of input encountered, but both branches still expecting input.".left[Tuple2[Char, Char]]
val x71 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x0,x70)
x71
}
x72
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
