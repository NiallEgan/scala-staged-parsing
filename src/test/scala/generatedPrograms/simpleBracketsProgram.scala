import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class SimpleBrackets extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x275:Int, x276:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x281 = {(x277:Int,x278:java.lang.String) => 
val x279 = throw new Exception("Bottom")
x279: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x282: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x281
val x287 = List()
val x288 = x287.right[java.lang.String]
val x307 = {(x299:Int,x300:Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x301 = x300._1
val x302 = x300._2
val x303 = List(x302)
val x304 = x301 ::: x303
val x305 = x304.right[java.lang.String]
val x306 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x299,x305)
x306: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x203 = "Error: Expected ), but reached end of input.".left[Char]
val x298 = {(x291:Int,x292:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x293 = x292._1
val x294 = x292._2
val x295 = x293 :: x294
val x296 = x295.right[java.lang.String]
val x297 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x291,x296)
x297: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x182 = "Error: Expected (, but reached end of input.".left[Char]
val x381 = {(x283:Int,x284:java.lang.String) => 
val x308 = x284.length
val x309 = x283 < x308
val x380 = if (x309) {
val x310 = x284.charAt(x283)
val x311 = x310 == '('
val x379 = if (x311) {
val x368 = {(x344:Int,x345:scala.collection.immutable.List[Char]) => 
val x364 = {(x359:Int,x360:Char) => 
val x361 = new Tuple2[scala.collection.immutable.List[Char], Char](x345,x360)
val x362 = x361.right[java.lang.String]
val x363 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]](x359,x362)
x363: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x346 = x344 < x308
val x358 = if (x346) {
val x347 = x284.charAt(x344)
val x348 = x347 == ')'
val x356 = if (x348) {
val x349 = x344 + 1
val x350 = x347.right[java.lang.String]
val x351 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x349,x350)
x351
} else {
val x352 = "Error: Expected ), got "+x347
val x353 = x352+"."
val x354 = x353.left[Char]
val x355 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x344,x354)
x355
}
x356
} else {
val x357 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x344,x203)
x357
}
val x365 = x358._1
val x366 = x358._2
val x367 = x366 match {
        case -\/(s) => (x365, -\/(s))
        case \/-(t) => x364(x365, t)
      }
x367: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x337 = {(x322:Int,x323:Char) => 
val x324 = x282
val x326 = x324(x322,x284)
val x332 = {(x327:Int,x328:scala.collection.immutable.List[Char]) => 
val x329 = new Tuple2[Char, scala.collection.immutable.List[Char]](x323,x328)
val x330 = x329.right[java.lang.String]
val x331 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x327,x330)
x331: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x333 = x326._1
val x334 = x326._2
val x335 = x334 match {
        case -\/(s) => (x333, -\/(s))
        case \/-(t) => x332(x333, t)
      }
x335: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x321 = if (x309) {
val x319 = if (x311) {
val x312 = x283 + 1
val x313 = x310.right[java.lang.String]
val x314 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x312,x313)
x314
} else {
val x315 = "Error: Expected (, got "+x310
val x316 = x315+"."
val x317 = x316.left[Char]
val x318 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x283,x317)
x318
}
x319
} else {
val x320 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x283,x182)
x320
}
val x338 = x321._1
val x339 = x321._2
val x340 = x339 match {
        case -\/(s) => (x338, -\/(s))
        case \/-(t) => x337(x338, t)
      }
val x341 = x340._1
val x342 = x340._2
val x343 = x342 match {
        case -\/(s) => (x341, -\/(s))
        case \/-(t) => x298(x341, t)
      }
val x369 = x343._1
val x370 = x343._2
val x371 = x370 match {
        case -\/(s) => (x369, -\/(s))
        case \/-(t) => x368(x369, t)
      }
val x372 = x371._1
val x373 = x371._2
val x374 = x373 match {
        case -\/(s) => (x372, -\/(s))
        case \/-(t) => x307(x372, t)
      }
x374
} else {
val x378 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x283,x288)
x378
}
x379
} else {
val x378 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x283,x288)
x378
}
x380: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x282 = x381
val x383 = x282
val x385 = x383(x275,x276)
x385
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
