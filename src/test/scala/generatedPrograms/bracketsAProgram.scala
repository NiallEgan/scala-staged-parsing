import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class BracketsAParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x210:Int, x211:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x216 = {(x212:Int,x213:java.lang.String) => 
val x214 = throw new Exception("Bottom")
x214: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x217: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x216
val x227 = {(x220:Int,x221:Char) => 
val x222 = x220
val x223 = x221
val x224 = List(x223)
val x225 = x224.right[java.lang.String]
val x226 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x222,x225)
x226: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x46 = "Error: Expected a, but reached end of input.".left[Char]
val x257 = {(x248:Int,x249:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x250 = x248
val x251 = x249
val x252 = x251._1
val x253 = x251._2
val x254 = x252 :: x253
val x255 = x254.right[java.lang.String]
val x256 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x250,x255)
x256: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x294 = "Error: Expected (, but reached end of input.".left[Char]
val x247 = {(x238:Int,x239:Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x240 = x238
val x241 = x239
val x242 = x241._1
val x243 = x241._2
val x244 = x242 ::: x243
val x245 = x244.right[java.lang.String]
val x246 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x240,x245)
x246: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x237 = {(x228:Int,x229:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x230 = x228
val x231 = x229
val x232 = x231._1
val x233 = x231._2
val x234 = x232 :: x233
val x235 = x234.right[java.lang.String]
val x236 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x230,x235)
x236: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x319 = "Error: Expected ), but reached end of input.".left[Char]
val x201 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x472 = {(x218:Int,x219:java.lang.String) => 
val x368 = x218
val x369 = x219
val x370 = x369.length
val x371 = x368 < x370
val x471 = if (x371) {
val x372 = x369.charAt(x368)
val x373 = 'a' == x372
val x469 = if (x373) {
val x384 = if (x371) {
val x374 = x372 == 'a'
val x382 = if (x374) {
val x375 = x368 + 1
val x376 = x372.right[java.lang.String]
val x377 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x375,x376)
x377
} else {
val x378 = "Error: Expected a, got "+x372
val x379 = x378+"."
val x380 = x379.left[Char]
val x381 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x368,x380)
x381
}
x382
} else {
val x383 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x368,x46)
x383
}
val x385 = x384._2 match {
        case -\/(s) => (x384._1, -\/(s))
        case \/-(t) => x227(x384._1, t)
      }
x385
} else {
val x386 = '(' == x372
val x468 = if (x386) {
val x394 = if (x371) {
val x387 = x372 == '('
val x392 = if (x387) {
val x375 = x368 + 1
val x376 = x372.right[java.lang.String]
val x377 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x375,x376)
x377
} else {
val x388 = "Error: Expected (, got "+x372
val x389 = x388+"."
val x390 = x389.left[Char]
val x391 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x368,x390)
x391
}
x392
} else {
val x393 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x368,x294)
x393
}
val x436 = {(x419:Int,x420:Char) => 
val x423 = x217
val x421 = x419
val x425 = x423(x421,x369)
val x422 = x420
val x433 = {(x426:Int,x427:scala.collection.immutable.List[Char]) => 
val x428 = x426
val x429 = x427
val x430 = new Tuple2[Char, scala.collection.immutable.List[Char]](x422,x429)
val x431 = x430.right[java.lang.String]
val x432 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x428,x431)
x432: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x434 = x425._2 match {
        case -\/(s) => (x425._1, -\/(s))
        case \/-(t) => x433(x425._1, t)
      }
x434: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x448 = {(x402:Int,x403:scala.collection.immutable.List[Char]) => 
val x404 = x402
val x406 = x404 < x370
val x418 = if (x406) {
val x407 = x369.charAt(x404)
val x408 = x407 == ')'
val x416 = if (x408) {
val x409 = x404 + 1
val x410 = x407.right[java.lang.String]
val x411 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x409,x410)
x411
} else {
val x412 = "Error: Expected ), got "+x407
val x413 = x412+"."
val x414 = x413.left[Char]
val x415 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x404,x414)
x415
}
x416
} else {
val x417 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x404,x319)
x417
}
val x437 = x418._2 match {
        case -\/(s) => (x418._1, -\/(s))
        case \/-(t) => x436(x418._1, t)
      }
val x438 = x437._2 match {
        case -\/(s) => (x437._1, -\/(s))
        case \/-(t) => x237(x437._1, t)
      }
val x405 = x403
val x446 = {(x439:Int,x440:scala.collection.immutable.List[Char]) => 
val x441 = x439
val x442 = x440
val x443 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x405,x442)
val x444 = x443.right[java.lang.String]
val x445 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]](x441,x444)
x445: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x447 = x438._2 match {
        case -\/(s) => (x438._1, -\/(s))
        case \/-(t) => x446(x438._1, t)
      }
x447: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x461 = {(x395:Int,x396:Char) => 
val x399 = x217
val x397 = x395
val x401 = x399(x397,x369)
val x449 = x401._2 match {
        case -\/(s) => (x401._1, -\/(s))
        case \/-(t) => x448(x401._1, t)
      }
val x450 = x449._2 match {
        case -\/(s) => (x449._1, -\/(s))
        case \/-(t) => x247(x449._1, t)
      }
val x398 = x396
val x458 = {(x451:Int,x452:scala.collection.immutable.List[Char]) => 
val x453 = x451
val x454 = x452
val x455 = new Tuple2[Char, scala.collection.immutable.List[Char]](x398,x454)
val x456 = x455.right[java.lang.String]
val x457 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x453,x456)
x457: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x459 = x450._2 match {
        case -\/(s) => (x450._1, -\/(s))
        case \/-(t) => x458(x450._1, t)
      }
x459: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x462 = x394._2 match {
        case -\/(s) => (x394._1, -\/(s))
        case \/-(t) => x461(x394._1, t)
      }
val x463 = x462._2 match {
        case -\/(s) => (x462._1, -\/(s))
        case \/-(t) => x257(x462._1, t)
      }
x463
} else {
val x464 = "Error: Token "+x372
val x465 = x464+" matches neither possible branch."
val x466 = x465.left[scala.collection.immutable.List[Char]]
val x467 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x368,x466)
x467
}
x468
}
x469
} else {
val x470 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x368,x201)
x470
}
x471: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x217 = x472
val x474 = x217
val x476 = x474(x210,x211)
x476
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
