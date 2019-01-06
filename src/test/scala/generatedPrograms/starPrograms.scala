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
val x45 = {(x32:Int,x33:Char) => 
val x34 = x5
val x40 = {(x35:Int,x36:scala.collection.immutable.List[Char]) => 
val x37 = x33 :: x36
val x38 = x37.right[java.lang.String]
val x39 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x32,x38)
x39: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x41 = x34._1
val x42 = x34._2
val x43 = x42 match {
        case -\/(s) => (x41, -\/(s))
        case \/-(t) => x40(x41, t)
      }
x43: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x29 = "Error: Expected a, but reached end of input.".left[Char]
val x51 = while ({val x6 = x5
val x7 = x6._1
val x10 = x7 < x9
val x13 = if (x10) {
val x11 = x1.charAt(x7)
val x12 = x11 == 'a'
x12
} else {
false
}
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
val x46 = x31._1
val x47 = x31._2
val x48 = x47 match {
        case -\/(s) => (x46, -\/(s))
        case \/-(t) => x45(x46, t)
      }
x5 = x48
()
}
val x52 = x5
x52
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
