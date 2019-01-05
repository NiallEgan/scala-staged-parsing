import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class AltParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]] = {
val x42 = x1.length
val x43 = x0 < x42
val x74 = if (x43) {
val x44 = x1.charAt(x0)
val x45 = 'a' == x44
val x71 = if (x45) {
val x56 = if (x43) {
val x46 = x44 == 'a'
val x54 = if (x46) {
val x47 = x0 + 1
val x48 = x44.right[java.lang.String]
val x49 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x47,x48)
x49
} else {
val x50 = "Error: Expected a, got "+x44
val x51 = x50+"."
val x52 = x51.left[Char]
val x53 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x52)
x53
}
x54
} else {
val x18 = "Error: Expected a, but reached end of input.".left[Char]
val x55 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x18)
x55
}
x56
} else {
val x57 = 'b' == x44
val x70 = if (x57) {
val x65 = if (x43) {
val x58 = x44 == 'b'
val x63 = if (x58) {
val x47 = x0 + 1
val x48 = x44.right[java.lang.String]
val x49 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x47,x48)
x49
} else {
val x59 = "Error: Expected b, got "+x44
val x60 = x59+"."
val x61 = x60.left[Char]
val x62 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x61)
x62
}
x63
} else {
val x38 = "Error: Expected b, but reached end of input.".left[Char]
val x64 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x38)
x64
}
x65
} else {
val x66 = "Error: Token "+x44
val x67 = x66+" matches neither possible branch."
val x68 = x67.left[Char]
val x69 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x68)
x69
}
x70
}
x71
} else {
val x72 = "Error: End of input encountered, but both branches still expecting input.".left[Char]
val x73 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x0,x72)
x73
}
x74
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
