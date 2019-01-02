import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class DyckParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x406:Int, x407:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x412 = {(x408:Int,x409:java.lang.String) => 
val x410 = throw new Exception("Bottom")
x410: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x413: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x412
val x166 = "Error: Expected (, but reached end of input.".left[Char]
val x461 = {(x452:Int,x453:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x454 = x452
val x455 = x453
val x456 = x455._1
val x457 = x455._2
val x458 = x456 :: x457
val x459 = x458.right[java.lang.String]
val x460 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x454,x459)
x460: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x191 = "Error: Expected ), but reached end of input.".left[Char]
val x501 = {(x491:Int,x492:Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x493 = x491
val x494 = x492
val x495 = x494._1
val x496 = x494._2
val x497 = List(x496)
val x498 = x495 ::: x497
val x499 = x498.right[java.lang.String]
val x500 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x493,x499)
x500: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x531 = {(x522:Int,x523:Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x524 = x522
val x525 = x523
val x526 = x525._1
val x527 = x525._2
val x528 = x526 ::: x527
val x529 = x528.right[java.lang.String]
val x530 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x524,x529)
x530: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x380 = ().right[java.lang.String]
val x386 = List()
val x387 = x386.right[java.lang.String]
val x539 = {(x534:Int,x535:Unit) => 
val x536 = x534
val x538 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x536,x387)
x538: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x547 = {(x542:Int,x543:Unit) => 
val x544 = x542
val x546 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x544,x387)
x546: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x550 = {(x414:Int,x415:java.lang.String) => 
val x416 = x414
val x417 = x415
val x418 = x417.length
val x419 = x416 < x418
val x549 = if (x419) {
val x420 = x417.charAt(x416)
val x421 = '(' == x420
val x541 = if (x421) {
val x432 = if (x419) {
val x422 = x420 == '('
val x430 = if (x422) {
val x423 = x416 + 1
val x424 = x420.right[java.lang.String]
val x425 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x423,x424)
x425
} else {
val x426 = "Error: Expected (, got "+x420
val x427 = x426+"."
val x428 = x427.left[Char]
val x429 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x416,x428)
x429
}
x430
} else {
val x431 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x416,x166)
x431
}
val x450 = {(x433:Int,x434:Char) => 
val x437 = x413
val x435 = x433
val x439 = x437(x435,x417)
val x436 = x434
val x447 = {(x440:Int,x441:scala.collection.immutable.List[Char]) => 
val x442 = x440
val x443 = x441
val x444 = new Tuple2[Char, scala.collection.immutable.List[Char]](x436,x443)
val x445 = x444.right[java.lang.String]
val x446 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x442,x445)
x446: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x448 = x439._2 match {
        case -\/(s) => (x439._1, -\/(s))
        case \/-(t) => x447(x439._1, t)
      }
x448: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x451 = x432._2 match {
        case -\/(s) => (x432._1, -\/(s))
        case \/-(t) => x450(x432._1, t)
      }
val x462 = x451._2 match {
        case -\/(s) => (x451._1, -\/(s))
        case \/-(t) => x461(x451._1, t)
      }
val x489 = {(x463:Int,x464:scala.collection.immutable.List[Char]) => 
val x465 = x463
val x467 = x465 < x418
val x479 = if (x467) {
val x468 = x417.charAt(x465)
val x469 = x468 == ')'
val x477 = if (x469) {
val x470 = x465 + 1
val x471 = x468.right[java.lang.String]
val x472 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x470,x471)
x472
} else {
val x473 = "Error: Expected ), got "+x468
val x474 = x473+"."
val x475 = x474.left[Char]
val x476 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x465,x475)
x476
}
x477
} else {
val x478 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x465,x191)
x478
}
val x466 = x464
val x487 = {(x480:Int,x481:Char) => 
val x482 = x480
val x483 = x481
val x484 = new Tuple2[scala.collection.immutable.List[Char], Char](x466,x483)
val x485 = x484.right[java.lang.String]
val x486 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]](x482,x485)
x486: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x488 = x479._2 match {
        case -\/(s) => (x479._1, -\/(s))
        case \/-(t) => x487(x479._1, t)
      }
x488: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x490 = x462._2 match {
        case -\/(s) => (x462._1, -\/(s))
        case \/-(t) => x489(x462._1, t)
      }
val x502 = x490._2 match {
        case -\/(s) => (x490._1, -\/(s))
        case \/-(t) => x501(x490._1, t)
      }
val x520 = {(x503:Int,x504:scala.collection.immutable.List[Char]) => 
val x507 = x413
val x505 = x503
val x509 = x507(x505,x417)
val x506 = x504
val x517 = {(x510:Int,x511:scala.collection.immutable.List[Char]) => 
val x512 = x510
val x513 = x511
val x514 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x506,x513)
val x515 = x514.right[java.lang.String]
val x516 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]](x512,x515)
x516: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x518 = x509._2 match {
        case -\/(s) => (x509._1, -\/(s))
        case \/-(t) => x517(x509._1, t)
      }
x518: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x521 = x502._2 match {
        case -\/(s) => (x502._1, -\/(s))
        case \/-(t) => x520(x502._1, t)
      }
val x532 = x521._2 match {
        case -\/(s) => (x521._1, -\/(s))
        case \/-(t) => x531(x521._1, t)
      }
x532
} else {
val x533 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x416,x380)
val x540 = x533._2 match {
        case -\/(s) => (x533._1, -\/(s))
        case \/-(t) => x539(x533._1, t)
      }
x540
}
x541
} else {
val x533 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x416,x380)
val x548 = x533._2 match {
        case -\/(s) => (x533._1, -\/(s))
        case \/-(t) => x547(x533._1, t)
      }
x548
}
x549: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x413 = x550
val x552 = x413
val x554 = x552(x406,x407)
x554
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
