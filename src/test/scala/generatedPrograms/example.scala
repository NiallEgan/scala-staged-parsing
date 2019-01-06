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
val x12 = List()
val x13 = x12.right[java.lang.String]
val x23 = {(x16:Int,x17:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x18 = x17._1
val x19 = x17._2
val x20 = x18 :: x19
val x21 = x20.right[java.lang.String]
val x22 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x16,x21)
x22: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x36 = "Error: Expected a, but reached end of input.".left[Char]
val x67 = {(x8:Int,x9:java.lang.String) => 
val x24 = x9.length
val x25 = x8 < x24
val x66 = if (x25) {
val x26 = x9.charAt(x8)
val x27 = x26 == 'a'
val x65 = if (x27) {
val x54 = {(x39:Int,x40:Char) => 
val x41 = x7
val x43 = x41(x39,x9)
val x49 = {(x44:Int,x45:scala.collection.immutable.List[Char]) => 
val x46 = new Tuple2[Char, scala.collection.immutable.List[Char]](x40,x45)
val x47 = x46.right[java.lang.String]
val x48 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x44,x47)
x48: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x50 = x43._1
val x51 = x43._2
val x52 = x51 match {
        case -\/(s) => (x50, -\/(s))
        case \/-(t) => x49(x50, t)
      }
x52: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x38 = if (x25) {
val x35 = if (x27) {
val x28 = x8 + 1
val x29 = x26.right[java.lang.String]
val x30 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x28,x29)
x30
} else {
val x31 = "Error: Expected a, got "+x26
val x32 = x31+"."
val x33 = x32.left[Char]
val x34 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x8,x33)
x34
}
x35
} else {
val x37 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x8,x36)
x37
}
val x55 = x38._1
val x56 = x38._2
val x57 = x56 match {
        case -\/(s) => (x55, -\/(s))
        case \/-(t) => x54(x55, t)
      }
val x58 = x57._1
val x59 = x57._2
val x60 = x59 match {
        case -\/(s) => (x58, -\/(s))
        case \/-(t) => x23(x58, t)
      }
x60
} else {
val x64 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x8,x13)
x64
}
x65
} else {
val x64 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x8,x13)
x64
}
x66: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x7 = x67
val x69 = x7
val x71 = x69(x0,x1)
x71
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
