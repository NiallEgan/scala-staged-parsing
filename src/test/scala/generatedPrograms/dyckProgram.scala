import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class DyckParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x387:Int, x388:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x393 = {(x389:Int,x390:java.lang.String) => 
val x391 = throw new Exception("Bottom")
x391: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x394: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x393
val x287 = List()
val x288 = x287.right[java.lang.String]
val x425 = {(x418:Int,x419:Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x420 = x419._1
val x421 = x419._2
val x422 = x420 ::: x421
val x423 = x422.right[java.lang.String]
val x424 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x418,x423)
x424: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x417 = {(x409:Int,x410:Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x411 = x410._1
val x412 = x410._2
val x413 = List(x412)
val x414 = x411 ::: x413
val x415 = x414.right[java.lang.String]
val x416 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x409,x415)
x416: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x203 = "Error: Expected ), but reached end of input.".left[Char]
val x408 = {(x401:Int,x402:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x403 = x402._1
val x404 = x402._2
val x405 = x403 :: x404
val x406 = x405.right[java.lang.String]
val x407 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x401,x406)
x407: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x182 = "Error: Expected (, but reached end of input.".left[Char]
val x520 = {(x395:Int,x396:java.lang.String) => 
val x426 = x396.length
val x427 = x395 < x426
val x519 = if (x427) {
val x428 = x396.charAt(x395)
val x429 = x428 == '('
val x518 = if (x429) {
val x508 = {(x493:Int,x494:scala.collection.immutable.List[Char]) => 
val x495 = x394
val x497 = x495(x493,x396)
val x503 = {(x498:Int,x499:scala.collection.immutable.List[Char]) => 
val x500 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x494,x499)
val x501 = x500.right[java.lang.String]
val x502 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]](x498,x501)
x502: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x504 = x497._1
val x505 = x497._2
val x506 = x505 match {
        case -\/(s) => (x504, -\/(s))
        case \/-(t) => x503(x504, t)
      }
x506: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x486 = {(x462:Int,x463:scala.collection.immutable.List[Char]) => 
val x482 = {(x477:Int,x478:Char) => 
val x479 = new Tuple2[scala.collection.immutable.List[Char], Char](x463,x478)
val x480 = x479.right[java.lang.String]
val x481 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]](x477,x480)
x481: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x464 = x462 < x426
val x476 = if (x464) {
val x465 = x396.charAt(x462)
val x466 = x465 == ')'
val x474 = if (x466) {
val x467 = x462 + 1
val x468 = x465.right[java.lang.String]
val x469 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x467,x468)
x469
} else {
val x470 = "Error: Expected ), got "+x465
val x471 = x470+"."
val x472 = x471.left[Char]
val x473 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x462,x472)
x473
}
x474
} else {
val x475 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x462,x203)
x475
}
val x483 = x476._1
val x484 = x476._2
val x485 = x484 match {
        case -\/(s) => (x483, -\/(s))
        case \/-(t) => x482(x483, t)
      }
x485: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x455 = {(x440:Int,x441:Char) => 
val x442 = x394
val x444 = x442(x440,x396)
val x450 = {(x445:Int,x446:scala.collection.immutable.List[Char]) => 
val x447 = new Tuple2[Char, scala.collection.immutable.List[Char]](x441,x446)
val x448 = x447.right[java.lang.String]
val x449 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x445,x448)
x449: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x451 = x444._1
val x452 = x444._2
val x453 = x452 match {
        case -\/(s) => (x451, -\/(s))
        case \/-(t) => x450(x451, t)
      }
x453: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x439 = if (x427) {
val x437 = if (x429) {
val x430 = x395 + 1
val x431 = x428.right[java.lang.String]
val x432 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x430,x431)
x432
} else {
val x433 = "Error: Expected (, got "+x428
val x434 = x433+"."
val x435 = x434.left[Char]
val x436 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x395,x435)
x436
}
x437
} else {
val x438 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x395,x182)
x438
}
val x456 = x439._1
val x457 = x439._2
val x458 = x457 match {
        case -\/(s) => (x456, -\/(s))
        case \/-(t) => x455(x456, t)
      }
val x459 = x458._1
val x460 = x458._2
val x461 = x460 match {
        case -\/(s) => (x459, -\/(s))
        case \/-(t) => x408(x459, t)
      }
val x487 = x461._1
val x488 = x461._2
val x489 = x488 match {
        case -\/(s) => (x487, -\/(s))
        case \/-(t) => x486(x487, t)
      }
val x490 = x489._1
val x491 = x489._2
val x492 = x491 match {
        case -\/(s) => (x490, -\/(s))
        case \/-(t) => x417(x490, t)
      }
val x509 = x492._1
val x510 = x492._2
val x511 = x510 match {
        case -\/(s) => (x509, -\/(s))
        case \/-(t) => x508(x509, t)
      }
val x512 = x511._1
val x513 = x511._2
val x514 = x513 match {
        case -\/(s) => (x512, -\/(s))
        case \/-(t) => x425(x512, t)
      }
x514
} else {
val x517 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x395,x288)
x517
}
x518
} else {
val x517 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x395,x288)
x517
}
x519: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x394 = x520
val x522 = x394
val x524 = x522(x387,x388)
x524
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
