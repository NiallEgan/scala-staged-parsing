import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class DyckParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, scala.collection.immutable.List[Char]])) {
def apply(x301:scala.collection.BufferedIterator[Char]): \/[java.lang.String, scala.collection.immutable.List[Char]] = {
val x305 = {x302: (scala.collection.BufferedIterator[Char]) => 
val x303 = throw new Exception("Bottom")
x303: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
var x306: scala.Function1[scala.collection.BufferedIterator[Char], \/[java.lang.String, scala.collection.immutable.List[Char]]] = x305
val x133 = "Error: Expected (, but reached end of input.".left[Char]
val x337 = {x332: (Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x333 = x332._1
val x334 = x332._2
val x335 = x333 :: x334
val x336 = x335.right[java.lang.String]
x336: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x150 = "Error: Expected ), but reached end of input.".left[Char]
val x366 = {x360: (Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x361 = x360._1
val x362 = x360._2
val x363 = List(x362)
val x364 = x361 ::: x363
val x365 = x364.right[java.lang.String]
x365: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x384 = {x379: (Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x380 = x379._1
val x381 = x379._2
val x382 = x380 ::: x381
val x383 = x382.right[java.lang.String]
x383: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x283 = ().right[java.lang.String]
val x285 = List()
val x286 = x285.right[java.lang.String]
val x388 = {x387: (Unit) => 
x286: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x389 = x283 >>= x388
val x393 = {x392: (Unit) => 
x286: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x394 = x283 >>= x393
val x397 = {x307: (scala.collection.BufferedIterator[Char]) => 
val x308 = x307.hasNext
val x395 = if (x308) {
val x309 = x307.head
val x310 = '(' == x309
val x390 = if (x310) {
val x320 = if (x308) {
val x311 = x309 == '('
val x318 = if (x311) {
val x312 = x307.next()
val x313 = x312.right[java.lang.String]
x313
} else {
val x315 = "Error: Expected (, got "+x309
val x316 = x315+"."
val x317 = x316.left[Char]
x317
}
x318
} else {
x133
}
val x330 = {x321: (Char) => 
val x322 = x306
val x323 = x322(x307)
val x327 = {x324: (scala.collection.immutable.List[Char]) => 
val x325 = new Tuple2[Char, scala.collection.immutable.List[Char]](x321,x324)
val x326 = x325.right[java.lang.String]
x326: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x328 = x323 >>= x327
x328: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x331 = x320 >>= x330
val x338 = x331 >>= x337
val x358 = {x339: (scala.collection.immutable.List[Char]) => 
val x340 = x307.hasNext
val x351 = if (x340) {
val x341 = x307.head
val x342 = x341 == ')'
val x349 = if (x342) {
val x343 = x307.next()
val x344 = x343.right[java.lang.String]
x344
} else {
val x346 = "Error: Expected ), got "+x341
val x347 = x346+"."
val x348 = x347.left[Char]
x348
}
x349
} else {
x150
}
val x355 = {x352: (Char) => 
val x353 = new Tuple2[scala.collection.immutable.List[Char], Char](x339,x352)
val x354 = x353.right[java.lang.String]
x354: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], Char]]
}
val x356 = x351 >>= x355
x356: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], Char]]
}
val x359 = x338 >>= x358
val x367 = x359 >>= x366
val x377 = {x368: (scala.collection.immutable.List[Char]) => 
val x369 = x306
val x370 = x369(x307)
val x374 = {x371: (scala.collection.immutable.List[Char]) => 
val x372 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x368,x371)
val x373 = x372.right[java.lang.String]
x373: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]
}
val x375 = x370 >>= x374
x375: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]
}
val x378 = x367 >>= x377
val x385 = x378 >>= x384
x385
} else {
x389
}
x390
} else {
x394
}
x395: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
x306 = x397
val x399 = x306
val x400 = x399(x301)
x400
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
