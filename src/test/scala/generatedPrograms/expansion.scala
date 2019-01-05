import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class ExpansionParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]] = {
val x42 = x1.length
val x43 = x0 < x42
val x56 = if (x43) {
val x44 = x1.charAt(x0)
val x45 = x44 == 'a'
val x53 = if (x45) {
val x46 = x0 + 1
val x47 = x44.right[java.lang.String]
val x48 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x46,x47)
x48
} else {
val x49 = "Error: Expected a, got "+x44
val x50 = x49+"."
val x51 = x50.left[Char]
val x52 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x51)
x52
}
x53
} else {
val x54 = "Error: Expected a, but reached end of input.".left[Char]
val x55 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x54)
x55
}
val x18 = "Error: Expected b, but reached end of input.".left[Char]
val x38 = "Error: Expected c, but reached end of input.".left[Char]
val x90 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
val x102 = {(x57:Int,x58:Char) => 
val x59 = x57
val x61 = x59 < x42
val x92 = if (x61) {
val x62 = x1.charAt(x59)
val x63 = 'b' == x62
val x89 = if (x63) {
val x74 = if (x61) {
val x64 = x62 == 'b'
val x72 = if (x64) {
val x65 = x59 + 1
val x66 = x62.right[java.lang.String]
val x67 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x65,x66)
x67
} else {
val x68 = "Error: Expected b, got "+x62
val x69 = x68+"."
val x70 = x69.left[Char]
val x71 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x59,x70)
x71
}
x72
} else {
val x73 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x59,x18)
x73
}
x74
} else {
val x75 = 'c' == x62
val x88 = if (x75) {
val x83 = if (x61) {
val x76 = x62 == 'c'
val x81 = if (x76) {
val x65 = x59 + 1
val x66 = x62.right[java.lang.String]
val x67 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x65,x66)
x67
} else {
val x77 = "Error: Expected c, got "+x62
val x78 = x77+"."
val x79 = x78.left[Char]
val x80 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x59,x79)
x80
}
x81
} else {
val x82 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x59,x38)
x82
}
x83
} else {
val x84 = "Error: Token "+x62
val x85 = x84+" matches neither possible branch."
val x86 = x85.left[Char]
val x87 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x59,x86)
x87
}
x88
}
x89
} else {
val x91 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x59,x90)
x91
}
val x60 = x58
val x100 = {(x93:Int,x94:Char) => 
val x95 = x93
val x96 = x94
val x97 = new Tuple2[Char, Char](x60,x96)
val x98 = x97.right[java.lang.String]
val x99 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x95,x98)
x99: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x101 = x92._2 match {
        case -\/(s) => (x92._1, -\/(s))
        case \/-(t) => x100(x92._1, t)
      }
x101: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x103 = x56._2 match {
        case -\/(s) => (x56._1, -\/(s))
        case \/-(t) => x102(x56._1, t)
      }
x103
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
