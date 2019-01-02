import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class acbEParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x0:Int, x1:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x6 = {(x2:Int,x3:java.lang.String) => 
val x4 = throw new Exception("Bottom")
x4: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x7: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x6
val x25 = "Error: Expected a, but reached end of input.".left[Char]
val x43 = "Error: Expected c, but reached end of input.".left[Char]
val x66 = {(x57:Int,x58:Tuple2[Char, Char]) => 
val x59 = x57
val x60 = x58
val x61 = x60._1
val x62 = x60._2
val x63 = List(x61,x62)
val x64 = x63.right[java.lang.String]
val x65 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x59,x64)
x65: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x75 = "Error: Expected b, but reached end of input.".left[Char]
val x106 = {(x97:Int,x98:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x99 = x97
val x100 = x98
val x101 = x100._1
val x102 = x100._2
val x103 = x101 :: x102
val x104 = x103.right[java.lang.String]
val x105 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x99,x104)
x105: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x114 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x117 = {(x8:Int,x9:java.lang.String) => 
val x10 = x8
val x11 = x9
val x12 = x11.length
val x13 = x10 < x12
val x116 = if (x13) {
val x14 = x11.charAt(x10)
val x15 = 'a' == x14
val x113 = if (x15) {
val x27 = if (x13) {
val x16 = x14 == 'a'
val x24 = if (x16) {
val x17 = x10 + 1
val x18 = x14.right[java.lang.String]
val x19 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x18)
x19
} else {
val x20 = "Error: Expected a, got "+x14
val x21 = x20+"."
val x22 = x21.left[Char]
val x23 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x10,x22)
x23
}
x24
} else {
val x26 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x10,x25)
x26
}
val x55 = {(x28:Int,x29:Char) => 
val x30 = x28
val x32 = x30 < x12
val x45 = if (x32) {
val x33 = x11.charAt(x30)
val x34 = x33 == 'c'
val x42 = if (x34) {
val x35 = x30 + 1
val x36 = x33.right[java.lang.String]
val x37 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x35,x36)
x37
} else {
val x38 = "Error: Expected c, got "+x33
val x39 = x38+"."
val x40 = x39.left[Char]
val x41 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x30,x40)
x41
}
x42
} else {
val x44 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x30,x43)
x44
}
val x31 = x29
val x53 = {(x46:Int,x47:Char) => 
val x48 = x46
val x49 = x47
val x50 = new Tuple2[Char, Char](x31,x49)
val x51 = x50.right[java.lang.String]
val x52 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x48,x51)
x52: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x54 = x45._2 match {
        case -\/(s) => (x45._1, -\/(s))
        case \/-(t) => x53(x45._1, t)
      }
x54: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x56 = x27._2 match {
        case -\/(s) => (x27._1, -\/(s))
        case \/-(t) => x55(x27._1, t)
      }
val x67 = x56._2 match {
        case -\/(s) => (x56._1, -\/(s))
        case \/-(t) => x66(x56._1, t)
      }
x67
} else {
val x68 = 'b' == x14
val x112 = if (x68) {
val x77 = if (x13) {
val x69 = x14 == 'b'
val x74 = if (x69) {
val x17 = x10 + 1
val x18 = x14.right[java.lang.String]
val x19 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x17,x18)
x19
} else {
val x70 = "Error: Expected b, got "+x14
val x71 = x70+"."
val x72 = x71.left[Char]
val x73 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x10,x72)
x73
}
x74
} else {
val x76 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x10,x75)
x76
}
val x95 = {(x78:Int,x79:Char) => 
val x82 = x7
val x80 = x78
val x84 = x82(x80,x11)
val x81 = x79
val x92 = {(x85:Int,x86:scala.collection.immutable.List[Char]) => 
val x87 = x85
val x88 = x86
val x89 = new Tuple2[Char, scala.collection.immutable.List[Char]](x81,x88)
val x90 = x89.right[java.lang.String]
val x91 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x87,x90)
x91: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x93 = x84._2 match {
        case -\/(s) => (x84._1, -\/(s))
        case \/-(t) => x92(x84._1, t)
      }
x93: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x96 = x77._2 match {
        case -\/(s) => (x77._1, -\/(s))
        case \/-(t) => x95(x77._1, t)
      }
val x107 = x96._2 match {
        case -\/(s) => (x96._1, -\/(s))
        case \/-(t) => x106(x96._1, t)
      }
x107
} else {
val x108 = "Error: Token "+x14
val x109 = x108+" matches neither possible branch."
val x110 = x109.left[scala.collection.immutable.List[Char]]
val x111 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x10,x110)
x111
}
x112
}
x113
} else {
val x115 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x10,x114)
x115
}
x116: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x7 = x117
val x119 = x7
val x121 = x119(x0,x1)
x121
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
