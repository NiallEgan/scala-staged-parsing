import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class SimpleBrackets extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x478:Int, x479:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x484 = {(x480:Int,x481:java.lang.String) => 
val x482 = throw new Exception("Bottom")
x482: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x485: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x484
val x492 = List()
val x493 = x492.right[java.lang.String]
val x495 = {(x488:Int,x489:Unit) => 
val x490 = x488
val x494 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x490,x493)
x494: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x521 = ().right[java.lang.String]
val x516 = {(x506:Int,x507:Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x508 = x506
val x509 = x507
val x510 = x509._1
val x511 = x509._2
val x512 = List(x511)
val x513 = x510 ::: x512
val x514 = x513.right[java.lang.String]
val x515 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x508,x514)
x515: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x505 = {(x496:Int,x497:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x498 = x496
val x499 = x497
val x500 = x499._1
val x501 = x499._2
val x502 = x500 :: x501
val x503 = x502.right[java.lang.String]
val x504 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x498,x503)
x504: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x294 = "Error: Expected (, but reached end of input.".left[Char]
val x319 = "Error: Expected ), but reached end of input.".left[Char]
val x663 = {(x486:Int,x487:java.lang.String) => 
val x593 = x486
val x594 = x487
val x595 = x594.length
val x596 = x593 < x595
val x662 = if (x596) {
val x597 = x594.charAt(x593)
val x598 = '(' == x597
val x661 = if (x598) {
val x609 = if (x596) {
val x599 = x597 == '('
val x607 = if (x599) {
val x600 = x593 + 1
val x601 = x597.right[java.lang.String]
val x602 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x600,x601)
x602
} else {
val x603 = "Error: Expected (, got "+x597
val x604 = x603+"."
val x605 = x604.left[Char]
val x606 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x593,x605)
x606
}
x607
} else {
val x608 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x593,x294)
x608
}
val x627 = {(x610:Int,x611:Char) => 
val x614 = x485
val x612 = x610
val x616 = x614(x612,x594)
val x613 = x611
val x624 = {(x617:Int,x618:scala.collection.immutable.List[Char]) => 
val x619 = x617
val x620 = x618
val x621 = new Tuple2[Char, scala.collection.immutable.List[Char]](x613,x620)
val x622 = x621.right[java.lang.String]
val x623 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x619,x622)
x623: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x625 = x616._2 match {
        case -\/(s) => (x616._1, -\/(s))
        case \/-(t) => x624(x616._1, t)
      }
x625: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x628 = x609._2 match {
        case -\/(s) => (x609._1, -\/(s))
        case \/-(t) => x627(x609._1, t)
      }
val x629 = x628._2 match {
        case -\/(s) => (x628._1, -\/(s))
        case \/-(t) => x505(x628._1, t)
      }
val x656 = {(x630:Int,x631:scala.collection.immutable.List[Char]) => 
val x632 = x630
val x634 = x632 < x595
val x646 = if (x634) {
val x635 = x594.charAt(x632)
val x636 = x635 == ')'
val x644 = if (x636) {
val x637 = x632 + 1
val x638 = x635.right[java.lang.String]
val x639 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x637,x638)
x639
} else {
val x640 = "Error: Expected ), got "+x635
val x641 = x640+"."
val x642 = x641.left[Char]
val x643 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x632,x642)
x643
}
x644
} else {
val x645 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x632,x319)
x645
}
val x633 = x631
val x654 = {(x647:Int,x648:Char) => 
val x649 = x647
val x650 = x648
val x651 = new Tuple2[scala.collection.immutable.List[Char], Char](x633,x650)
val x652 = x651.right[java.lang.String]
val x653 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]](x649,x652)
x653: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x655 = x646._2 match {
        case -\/(s) => (x646._1, -\/(s))
        case \/-(t) => x654(x646._1, t)
      }
x655: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x657 = x629._2 match {
        case -\/(s) => (x629._1, -\/(s))
        case \/-(t) => x656(x629._1, t)
      }
val x658 = x657._2 match {
        case -\/(s) => (x657._1, -\/(s))
        case \/-(t) => x516(x657._1, t)
      }
x658
} else {
val x659 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x593,x521)
val x660 = x659._2 match {
        case -\/(s) => (x659._1, -\/(s))
        case \/-(t) => x495(x659._1, t)
      }
x660
}
x661
} else {
val x659 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x593,x521)
val x660 = x659._2 match {
        case -\/(s) => (x659._1, -\/(s))
        case \/-(t) => x495(x659._1, t)
      }
x660
}
x662: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x485 = x663
val x665 = x485
val x667 = x665(x478,x479)
x667
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
