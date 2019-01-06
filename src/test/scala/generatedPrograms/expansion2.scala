import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class ExpansionParser2 extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]] = {
val x2 = x1.length
val x48 = "Error: Expected c, but reached end of input.".left[Char]
val x60 = {(x35:Int,x36:Char) => 
val x56 = {(x51:Int,x52:Char) => 
val x53 = new Tuple2[Char, Char](x36,x52)
val x54 = x53.right[java.lang.String]
val x55 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x51,x54)
x55: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x37 = x35 < x2
val x50 = if (x37) {
val x38 = x1.charAt(x35)
val x39 = x38 == 'c'
val x47 = if (x39) {
val x40 = x35 + 1
val x41 = x38.right[java.lang.String]
val x42 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x40,x41)
x42
} else {
val x43 = "Error: Expected c, got "+x38
val x44 = x43+"."
val x45 = x44.left[Char]
val x46 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x35,x45)
x46
}
x47
} else {
val x49 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x35,x48)
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
val x61 = x34._1
val x62 = x34._2
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
