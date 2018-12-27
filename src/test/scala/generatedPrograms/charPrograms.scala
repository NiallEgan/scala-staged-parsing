import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class CharParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, Char])) {
def apply(x0:scala.collection.BufferedIterator[Char]): \/[java.lang.String, Char] = {
val x1 = x0.hasNext
val x13 = if (x1) {
val x2 = x0.head
val x3 = x2 == 'a'
val x10 = if (x3) {
val x4 = x0.next()
val x5 = x4.right[java.lang.String]
x5
} else {
val x7 = "Error: Expected a, got "+x2
val x8 = x7+"."
val x9 = x8.left[Char]
x9
}
x10
} else {
val x12 = "Error: Expected a, but reached end of input.".left[Char]
x12
}
x13
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
