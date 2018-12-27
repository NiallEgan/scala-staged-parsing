import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class SimpleBrackets extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, scala.collection.immutable.List[Char]])) {
def apply(x215:scala.collection.BufferedIterator[Char]): \/[java.lang.String, scala.collection.immutable.List[Char]] = {
val x219 = {x216: (scala.collection.BufferedIterator[Char]) => 
val x217 = throw new Exception("Bottom")
x217: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
var x220: scala.Function1[scala.collection.BufferedIterator[Char], \/[java.lang.String, scala.collection.immutable.List[Char]]] = x219
val x133 = "Error: Expected (, but reached end of input.".left[Char]
val x251 = {x246: (Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x247 = x246._1
val x248 = x246._2
val x249 = x247 :: x248
val x250 = x249.right[java.lang.String]
x250: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x150 = "Error: Expected ), but reached end of input.".left[Char]
val x280 = {x274: (Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x275 = x274._1
val x276 = x274._2
val x277 = List(x276)
val x278 = x275 ::: x277
val x279 = x278.right[java.lang.String]
x279: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x283 = ().right[java.lang.String]
val x285 = List()
val x286 = x285.right[java.lang.String]
val x287 = {x284: (Unit) => 
x286: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x288 = x283 >>= x287
val x292 = {x291: (Unit) => 
x286: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x293 = x283 >>= x292
val x296 = {x221: (scala.collection.BufferedIterator[Char]) => 
val x222 = x221.hasNext
val x294 = if (x222) {
val x223 = x221.head
val x224 = '(' == x223
val x289 = if (x224) {
val x234 = if (x222) {
val x225 = x223 == '('
val x232 = if (x225) {
val x226 = x221.next()
val x227 = x226.right[java.lang.String]
x227
} else {
val x229 = "Error: Expected (, got "+x223
val x230 = x229+"."
val x231 = x230.left[Char]
x231
}
x232
} else {
x133
}
val x244 = {x235: (Char) => 
val x236 = x220
val x237 = x236(x221)
val x241 = {x238: (scala.collection.immutable.List[Char]) => 
val x239 = new Tuple2[Char, scala.collection.immutable.List[Char]](x235,x238)
val x240 = x239.right[java.lang.String]
x240: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x242 = x237 >>= x241
x242: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x245 = x234 >>= x244
val x252 = x245 >>= x251
val x272 = {x253: (scala.collection.immutable.List[Char]) => 
val x254 = x221.hasNext
val x265 = if (x254) {
val x255 = x221.head
val x256 = x255 == ')'
val x263 = if (x256) {
val x257 = x221.next()
val x258 = x257.right[java.lang.String]
x258
} else {
val x260 = "Error: Expected ), got "+x255
val x261 = x260+"."
val x262 = x261.left[Char]
x262
}
x263
} else {
x150
}
val x269 = {x266: (Char) => 
val x267 = new Tuple2[scala.collection.immutable.List[Char], Char](x253,x266)
val x268 = x267.right[java.lang.String]
x268: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], Char]]
}
val x270 = x265 >>= x269
x270: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], Char]]
}
val x273 = x252 >>= x272
val x281 = x273 >>= x280
x281
} else {
x288
}
x289
} else {
x293
}
x294: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
x220 = x296
val x298 = x220
val x299 = x298(x215)
x299
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
