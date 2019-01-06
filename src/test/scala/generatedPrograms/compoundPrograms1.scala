import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class CompoundParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]] = {
val x2 = x1.length
val x30 = "Error: Expected b, but reached end of input.".left[Char]
val x39 = "Error: Expected c, but reached end of input.".left[Char]
val x48 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
val x60 = {(x17:Int,x18:Char) => 
val x56 = {(x51:Int,x52:Char) => 
val x53 = new Tuple2[Char, Char](x18,x52)
val x54 = x53.right[java.lang.String]
val x55 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x51,x54)
x55: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x19 = x17 < x2
val x50 = if (x19) {
val x20 = x1.charAt(x17)
val x21 = x20 == 'b'
val x47 = if (x21) {
val x32 = if (x19) {
val x29 = if (x21) {
val x22 = x17 + 1
val x23 = x20.right[java.lang.String]
val x24 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x22,x23)
x24
} else {
val x25 = "Error: Expected b, got "+x20
val x26 = x25+"."
val x27 = x26.left[Char]
val x28 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x27)
x28
}
x29
} else {
val x31 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x30)
x31
}
x32
} else {
val x33 = x20 == 'c'
val x46 = if (x33) {
val x41 = if (x19) {
val x38 = if (x33) {
val x22 = x17 + 1
val x23 = x20.right[java.lang.String]
val x24 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x22,x23)
x24
} else {
val x34 = "Error: Expected c, got "+x20
val x35 = x34+"."
val x36 = x35.left[Char]
val x37 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x36)
x37
}
x38
} else {
val x40 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x39)
x40
}
x41
} else {
val x42 = "Error: Token "+x20
val x43 = x42+" matches neither possible branch."
val x44 = x43.left[Char]
val x45 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x44)
x45
}
x46
}
x47
} else {
val x49 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x48)
x49
}
val x57 = x50._1
val x58 = x50._2
val x59 = x58 match {
        case -\/(s) => (x57, -\/(s))
        case \/-(t) => x56(x57, t)
      }
x59: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
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
val x61 = x16._1
val x62 = x16._2
val x63 = x62 match {
        case -\/(s) => (x61, -\/(s))
        case \/-(t) => x60(x61, t)
      }
x63
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
