import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code
*******************************************/
class ExampleParser2 extends ((Int, String)=>(Tuple2[Int, \/[String, List[Char]]])) {
def apply(x0:Int, x1:String): Tuple2[Int, \/[String, List[Char]]] = {



val x14 = List()
val rightList = x14.right[String]
val unit2list: (Int, Unit) => (Int, \/[String, List[Char]]) = {(x10 ,x11) =>
val x12 = x10
val x16 = (x12,rightList)
x16
}

val charCons: (Int, (Char, List[Char])) => (Int, (\/[String, List[Char]])) = {(x18, x19) =>
val x20 = x18
val x21 = x19
val x22 = x21._1
val x23 = x21._2
val x24 = x22 :: x23
val x25 = x24.right[String]
val x26 = (x20,x25)
x26
}

val rightUnit = ().right[String]
val errmsg1 = "Error: Expected a, but reached end of input.".left[Char]
var f: (Int,String) => (Int, \/[String, List[Char]]) = {
  (x2, x3) => throw new Exception("Bottom")
}
val x71 = { (pos:Int,input:String) =>
  val inputLeft = pos < input.length
  if (inputLeft) {
    val firstChar = input.charAt(pos)
    if ('a' == firstChar) {
      val charConsumption = if (inputLeft) {
        if (firstChar == 'a') (pos + 1, firstChar.right[String])
        else {
          val errmsg2 = "Error: Expected a, got " + firstChar + "."
          (pos, errmsg2.left[Char])
        }
      } else (pos,errmsg1)

      val x63 = { (x46:Int, prevChar:Char) =>
        val recursiveConsumption = f(x46,input)
        val x60 = { (x53:Int,x54:List[Char]) =>
          val x57 = (prevChar,x54).right[String]
          (x53,x57)
        }
        recursiveConsumption._2 match {
          case -\/(s) => (recursiveConsumption._1, -\/(s))
          case \/-(t) => x60(recursiveConsumption._1, t)
        }
      }
      val x64 = charConsumption._2 match {
        case -\/(s) => (charConsumption._1, -\/(s))
        case \/-(t) => x63(charConsumption._1, t)
      }
      x64._2 match {
        case -\/(s) => (x64._1, -\/(s))
        case \/-(t) => charCons(x64._1, t)
      }
    } else (pos, rightList)
  } else (pos, rightList)
}
f = x71
f(x0,x1)
}
}
/*****************************************
  End of Generated Code
*******************************************/
