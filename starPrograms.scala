import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class StarParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x2 = List()
val x3 = x2.right[java.lang.String]
val x4 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x0,x3)
var x5: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = x4
val x9 = x1.length
val x29 = "Error: Expected a, but reached end of input.".left[Char]
val x48 = {(x32:Int,x33:Char) => 
val x36 = x5
val x34 = x32
val x35 = x33
val x45 = {(x37:Int,x38:scala.collection.immutable.List[Char]) => 
val x39 = x37
val x42 = x34 + x39
val x40 = x38
val x41 = x35 :: x40
val x43 = x41.right[java.lang.String]
val x44 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x42,x43)
x44: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x46 = x36._2 match {
        case -\/(s) => (x36._1, -\/(s))
        case \/-(t) => x45(x36._1, t)
      }
x46: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x52 = while ({val x6 = x5
val x7 = x6._1
val x10 = x7 < x9
val x11 = x1.charAt(x7)
val x12 = 'a' == x11
val x13 = x10 && x12
x13}) {
val x15 = x5
val x16 = x15._1
val x18 = x16 < x9
val x31 = if (x18) {
val x19 = x1.charAt(x16)
val x20 = x19 == 'a'
val x28 = if (x20) {
val x21 = x16 + 1
val x22 = x19.right[java.lang.String]
val x23 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x21,x22)
x23
} else {
val x24 = "Error: Expected a, got "+x19
val x25 = x24+"."
val x26 = x25.left[Char]
val x27 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x16,x26)
x27
}
x28
} else {
val x30 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x16,x29)
x30
}
val x49 = x31._2 match {
        case -\/(s) => (x31._1, -\/(s))
        case \/-(t) => x48(x31._1, t)
      }
x5 = x49
()
}
val x53 = x5
x53
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
