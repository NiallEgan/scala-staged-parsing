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
val x17 = {(x10:Int,x11:Tuple2[Char, Char]) => 
val x12 = x11._1
val x13 = x11._2
val x14 = List(x12,x13)
val x15 = x14.right[java.lang.String]
val x16 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x10,x15)
x16: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x54 = "Error: Expected c, but reached end of input.".left[Char]
val x38 = "Error: Expected a, but reached end of input.".left[Char]
val x25 = {(x18:Int,x19:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x20 = x19._1
val x21 = x19._2
val x22 = x20 :: x21
val x23 = x22.right[java.lang.String]
val x24 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x18,x23)
x24: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x79 = "Error: Expected b, but reached end of input.".left[Char]
val x110 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x113 = {(x8:Int,x9:java.lang.String) => 
val x26 = x9.length
val x27 = x8 < x26
val x112 = if (x27) {
val x28 = x9.charAt(x8)
val x29 = x28 == 'a'
val x109 = if (x29) {
val x66 = {(x41:Int,x42:Char) => 
val x62 = {(x57:Int,x58:Char) => 
val x59 = new Tuple2[Char, Char](x42,x58)
val x60 = x59.right[java.lang.String]
val x61 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x57,x60)
x61: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x43 = x41 < x26
val x56 = if (x43) {
val x44 = x9.charAt(x41)
val x45 = x44 == 'c'
val x53 = if (x45) {
val x46 = x41 + 1
val x47 = x44.right[java.lang.String]
val x48 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x46,x47)
x48
} else {
val x49 = "Error: Expected c, got "+x44
val x50 = x49+"."
val x51 = x50.left[Char]
val x52 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x41,x51)
x52
}
x53
} else {
val x55 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x41,x54)
x55
}
val x63 = x56._1
val x64 = x56._2
val x65 = x64 match {
        case -\/(s) => (x63, -\/(s))
        case \/-(t) => x62(x63, t)
      }
x65: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x40 = if (x27) {
val x37 = if (x29) {
val x30 = x8 + 1
val x31 = x28.right[java.lang.String]
val x32 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x30,x31)
x32
} else {
val x33 = "Error: Expected a, got "+x28
val x34 = x33+"."
val x35 = x34.left[Char]
val x36 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x8,x35)
x36
}
x37
} else {
val x39 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x8,x38)
x39
}
val x67 = x40._1
val x68 = x40._2
val x69 = x68 match {
        case -\/(s) => (x67, -\/(s))
        case \/-(t) => x66(x67, t)
      }
val x70 = x69._1
val x71 = x69._2
val x72 = x71 match {
        case -\/(s) => (x70, -\/(s))
        case \/-(t) => x17(x70, t)
      }
x72
} else {
val x73 = x28 == 'b'
val x108 = if (x73) {
val x97 = {(x82:Int,x83:Char) => 
val x84 = x7
val x86 = x84(x82,x9)
val x92 = {(x87:Int,x88:scala.collection.immutable.List[Char]) => 
val x89 = new Tuple2[Char, scala.collection.immutable.List[Char]](x83,x88)
val x90 = x89.right[java.lang.String]
val x91 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x87,x90)
x91: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x93 = x86._1
val x94 = x86._2
val x95 = x94 match {
        case -\/(s) => (x93, -\/(s))
        case \/-(t) => x92(x93, t)
      }
x95: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x81 = if (x27) {
val x78 = if (x73) {
val x30 = x8 + 1
val x31 = x28.right[java.lang.String]
val x32 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x30,x31)
x32
} else {
val x74 = "Error: Expected b, got "+x28
val x75 = x74+"."
val x76 = x75.left[Char]
val x77 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x8,x76)
x77
}
x78
} else {
val x80 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x8,x79)
x80
}
val x98 = x81._1
val x99 = x81._2
val x100 = x99 match {
        case -\/(s) => (x98, -\/(s))
        case \/-(t) => x97(x98, t)
      }
val x101 = x100._1
val x102 = x100._2
val x103 = x102 match {
        case -\/(s) => (x101, -\/(s))
        case \/-(t) => x25(x101, t)
      }
x103
} else {
val x104 = "Error: Token "+x28
val x105 = x104+" matches neither possible branch."
val x106 = x105.left[scala.collection.immutable.List[Char]]
val x107 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x8,x106)
x107
}
x108
}
x109
} else {
val x111 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x8,x110)
x111
}
x112: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x7 = x113
val x115 = x7
val x117 = x115(x0,x1)
x117
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
