import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class SimpleBrackets extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x283:Int, x284:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x289 = {(x285:Int,x286:java.lang.String) => 
val x287 = throw new Exception("Bottom")
x287: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x290: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x289
val x166 = "Error: Expected (, but reached end of input.".left[Char]
val x338 = {(x329:Int,x330:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x331 = x329
val x332 = x330
val x333 = x332._1
val x334 = x332._2
val x335 = x333 :: x334
val x336 = x335.right[java.lang.String]
val x337 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x331,x336)
x337: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x191 = "Error: Expected ), but reached end of input.".left[Char]
val x378 = {(x368:Int,x369:Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x370 = x368
val x371 = x369
val x372 = x371._1
val x373 = x371._2
val x374 = List(x373)
val x375 = x372 ::: x374
val x376 = x375.right[java.lang.String]
val x377 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x370,x376)
x377: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x380 = ().right[java.lang.String]
val x386 = List()
val x387 = x386.right[java.lang.String]
val x389 = {(x382:Int,x383:Unit) => 
val x384 = x382
val x388 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x384,x387)
x388: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x397 = {(x392:Int,x393:Unit) => 
val x394 = x392
val x396 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x394,x387)
x396: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x400 = {(x291:Int,x292:java.lang.String) => 
val x293 = x291
val x294 = x292
val x295 = x294.length
val x296 = x293 < x295
val x399 = if (x296) {
val x297 = x294.charAt(x293)
val x298 = '(' == x297
val x391 = if (x298) {
val x309 = if (x296) {
val x299 = x297 == '('
val x307 = if (x299) {
val x300 = x293 + 1
val x301 = x297.right[java.lang.String]
val x302 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x300,x301)
x302
} else {
val x303 = "Error: Expected (, got "+x297
val x304 = x303+"."
val x305 = x304.left[Char]
val x306 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x293,x305)
x306
}
x307
} else {
val x308 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x293,x166)
x308
}
val x327 = {(x310:Int,x311:Char) => 
val x314 = x290
val x312 = x310
val x316 = x314(x312,x294)
val x313 = x311
val x324 = {(x317:Int,x318:scala.collection.immutable.List[Char]) => 
val x319 = x317
val x320 = x318
val x321 = new Tuple2[Char, scala.collection.immutable.List[Char]](x313,x320)
val x322 = x321.right[java.lang.String]
val x323 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x319,x322)
x323: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x325 = x316._2 match {
        case -\/(s) => (x316._1, -\/(s))
        case \/-(t) => x324(x316._1, t)
      }
x325: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x328 = x309._2 match {
        case -\/(s) => (x309._1, -\/(s))
        case \/-(t) => x327(x309._1, t)
      }
val x339 = x328._2 match {
        case -\/(s) => (x328._1, -\/(s))
        case \/-(t) => x338(x328._1, t)
      }
val x366 = {(x340:Int,x341:scala.collection.immutable.List[Char]) => 
val x342 = x340
val x344 = x342 < x295
val x356 = if (x344) {
val x345 = x294.charAt(x342)
val x346 = x345 == ')'
val x354 = if (x346) {
val x347 = x342 + 1
val x348 = x345.right[java.lang.String]
val x349 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x347,x348)
x349
} else {
val x350 = "Error: Expected ), got "+x345
val x351 = x350+"."
val x352 = x351.left[Char]
val x353 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x342,x352)
x353
}
x354
} else {
val x355 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x342,x191)
x355
}
val x343 = x341
val x364 = {(x357:Int,x358:Char) => 
val x359 = x357
val x360 = x358
val x361 = new Tuple2[scala.collection.immutable.List[Char], Char](x343,x360)
val x362 = x361.right[java.lang.String]
val x363 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]](x359,x362)
x363: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x365 = x356._2 match {
        case -\/(s) => (x356._1, -\/(s))
        case \/-(t) => x364(x356._1, t)
      }
x365: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x367 = x339._2 match {
        case -\/(s) => (x339._1, -\/(s))
        case \/-(t) => x366(x339._1, t)
      }
val x379 = x367._2 match {
        case -\/(s) => (x367._1, -\/(s))
        case \/-(t) => x378(x367._1, t)
      }
x379
} else {
val x381 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x293,x380)
val x390 = x381._2 match {
        case -\/(s) => (x381._1, -\/(s))
        case \/-(t) => x389(x381._1, t)
      }
x390
}
x391
} else {
val x381 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x293,x380)
val x398 = x381._2 match {
        case -\/(s) => (x381._1, -\/(s))
        case \/-(t) => x397(x381._1, t)
      }
x398
}
x399: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x290 = x400
val x402 = x290
val x404 = x402(x283,x284)
x404
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
