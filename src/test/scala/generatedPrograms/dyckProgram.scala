import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class DyckParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x669:Int, x670:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x675 = {(x671:Int,x672:java.lang.String) => 
val x673 = throw new Exception("Bottom")
x673: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x676: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x675
val x492 = List()
val x493 = x492.right[java.lang.String]
val x684 = {(x679:Int,x680:Unit) => 
val x681 = x679
val x683 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x681,x493)
x683: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x521 = ().right[java.lang.String]
val x715 = {(x706:Int,x707:Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x708 = x706
val x709 = x707
val x710 = x709._1
val x711 = x709._2
val x712 = x710 ::: x711
val x713 = x712.right[java.lang.String]
val x714 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x708,x713)
x714: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x705 = {(x695:Int,x696:Tuple2[scala.collection.immutable.List[Char], Char]) => 
val x697 = x695
val x698 = x696
val x699 = x698._1
val x700 = x698._2
val x701 = List(x700)
val x702 = x699 ::: x701
val x703 = x702.right[java.lang.String]
val x704 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x697,x703)
x704: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x694 = {(x685:Int,x686:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x687 = x685
val x688 = x686
val x689 = x688._1
val x690 = x688._2
val x691 = x689 :: x690
val x692 = x691.right[java.lang.String]
val x693 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x687,x692)
x693: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x294 = "Error: Expected (, but reached end of input.".left[Char]
val x319 = "Error: Expected ), but reached end of input.".left[Char]
val x901 = {(x677:Int,x678:java.lang.String) => 
val x811 = x677
val x812 = x678
val x813 = x812.length
val x814 = x811 < x813
val x900 = if (x814) {
val x815 = x812.charAt(x811)
val x816 = '(' == x815
val x899 = if (x816) {
val x827 = if (x814) {
val x817 = x815 == '('
val x825 = if (x817) {
val x818 = x811 + 1
val x819 = x815.right[java.lang.String]
val x820 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x818,x819)
x820
} else {
val x821 = "Error: Expected (, got "+x815
val x822 = x821+"."
val x823 = x822.left[Char]
val x824 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x811,x823)
x824
}
x825
} else {
val x826 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x811,x294)
x826
}
val x845 = {(x828:Int,x829:Char) => 
val x832 = x676
val x830 = x828
val x834 = x832(x830,x812)
val x831 = x829
val x842 = {(x835:Int,x836:scala.collection.immutable.List[Char]) => 
val x837 = x835
val x838 = x836
val x839 = new Tuple2[Char, scala.collection.immutable.List[Char]](x831,x838)
val x840 = x839.right[java.lang.String]
val x841 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x837,x840)
x841: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x843 = x834._2 match {
        case -\/(s) => (x834._1, -\/(s))
        case \/-(t) => x842(x834._1, t)
      }
x843: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x846 = x827._2 match {
        case -\/(s) => (x827._1, -\/(s))
        case \/-(t) => x845(x827._1, t)
      }
val x847 = x846._2 match {
        case -\/(s) => (x846._1, -\/(s))
        case \/-(t) => x694(x846._1, t)
      }
val x874 = {(x848:Int,x849:scala.collection.immutable.List[Char]) => 
val x850 = x848
val x852 = x850 < x813
val x864 = if (x852) {
val x853 = x812.charAt(x850)
val x854 = x853 == ')'
val x862 = if (x854) {
val x855 = x850 + 1
val x856 = x853.right[java.lang.String]
val x857 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x855,x856)
x857
} else {
val x858 = "Error: Expected ), got "+x853
val x859 = x858+"."
val x860 = x859.left[Char]
val x861 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x850,x860)
x861
}
x862
} else {
val x863 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x850,x319)
x863
}
val x851 = x849
val x872 = {(x865:Int,x866:Char) => 
val x867 = x865
val x868 = x866
val x869 = new Tuple2[scala.collection.immutable.List[Char], Char](x851,x868)
val x870 = x869.right[java.lang.String]
val x871 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]](x867,x870)
x871: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x873 = x864._2 match {
        case -\/(s) => (x864._1, -\/(s))
        case \/-(t) => x872(x864._1, t)
      }
x873: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], Char]]]
}
val x875 = x847._2 match {
        case -\/(s) => (x847._1, -\/(s))
        case \/-(t) => x874(x847._1, t)
      }
val x876 = x875._2 match {
        case -\/(s) => (x875._1, -\/(s))
        case \/-(t) => x705(x875._1, t)
      }
val x894 = {(x877:Int,x878:scala.collection.immutable.List[Char]) => 
val x881 = x676
val x879 = x877
val x883 = x881(x879,x812)
val x880 = x878
val x891 = {(x884:Int,x885:scala.collection.immutable.List[Char]) => 
val x886 = x884
val x887 = x885
val x888 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x880,x887)
val x889 = x888.right[java.lang.String]
val x890 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]](x886,x889)
x890: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x892 = x883._2 match {
        case -\/(s) => (x883._1, -\/(s))
        case \/-(t) => x891(x883._1, t)
      }
x892: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x895 = x876._2 match {
        case -\/(s) => (x876._1, -\/(s))
        case \/-(t) => x894(x876._1, t)
      }
val x896 = x895._2 match {
        case -\/(s) => (x895._1, -\/(s))
        case \/-(t) => x715(x895._1, t)
      }
x896
} else {
val x897 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x811,x521)
val x898 = x897._2 match {
        case -\/(s) => (x897._1, -\/(s))
        case \/-(t) => x684(x897._1, t)
      }
x898
}
x899
} else {
val x897 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Unit]](x811,x521)
val x898 = x897._2 match {
        case -\/(s) => (x897._1, -\/(s))
        case \/-(t) => x684(x897._1, t)
      }
x898
}
x900: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x676 = x901
val x903 = x676
val x905 = x903(x669,x670)
x905
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
