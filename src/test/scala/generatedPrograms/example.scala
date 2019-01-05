import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class ExampleParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x6 = {(x2:Int,x3:java.lang.String) => 
val x4 = throw new Exception("Bottom")
x4: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x7: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x6
val x14 = List()
val x15 = x14.right[java.lang.String]
val x17 = {(x10:Int,x11:Unit) => 
val x12 = x10
val x16 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x12,x15)
x16: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x32 = ().right[java.lang.String]
val x27 = {(x18:Int,x19:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x20 = x18
val x21 = x19
val x22 = x21._1
val x23 = x21._2
val x24 = x22 :: x23
val x25 = x24.right[java.lang.String]
val x26 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x20,x25)
x26: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x52 = "Error: Expected a, but reached end of input.".left[Char]
val x117 = {(x8:Int,x9:java.lang.String) => 
val x76 = x8
val x77 = x9
val x78 = x77.length
val x79 = x76 < x78
val x116 = if (x79) {
val x80 = x77.charAt(x76)
val x81 = 'a' == x80
val x115 = if (x81) {
val x92 = if (x79) {
val x82 = x80 == 'a'
val x90 = if (x82) {
val x83 = x76 + 1
val x84 = x80.right[java.lang.String]
val x85 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x83,x84)
x85
} else {
val x86 = "Error: Expected a, got "+x80
val x87 = x86+"."
val x88 = x87.left[Char]
val x89 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x76,x88)
x89
}
x90
} else {
val x91 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x76,x52)
x91
}
val x110 = {(x93:Int,x94:Char) => 
val x97 = x7
val x95 = x93
val x99 = x97(x95,x77)
val x96 = x94
val x107 = {(x100:Int,x101:scala.collection.immutable.List[Char]) => 
val x102 = x100
val x103 = x101
val x104 = new Tuple2[Char, scala.collection.immutable.List[Char]](x96,x103)
val x105 = x104.right[java.lang.String]
val x106 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x102,x105)
x106: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x108 = x99._2 match {
        case -\/(s) => (x99._1, -\/(s))
        case \/-(t) => x107(x99._1, t)
      }
x108: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x111 = x92._2 match {
        case -\/(s) => (x92._1, -\/(s))
        case \/-(t) => x110(x92._1, t)
      }
val x112 = x111._2 match {
        case -\/(s) => (x111._1, -\/(s))
        case \/-(t) => x27(x111._1, t)
      }
x112
} else {
val x113 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x76,x32)
val x114 = x113._2 match {
        case -\/(s) => (x113._1, -\/(s))
        case \/-(t) => x17(x113._1, t)
      }
x114
}
x115
} else {
val x113 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x76,x32)
val x114 = x113._2 match {
        case -\/(s) => (x113._1, -\/(s))
        case \/-(t) => x17(x113._1, t)
      }
x114
}
x116: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x7 = x117
val x119 = x7
val x121 = x119(x0,x1)
x121
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
