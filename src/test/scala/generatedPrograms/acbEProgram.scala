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
val x19 = {(x10:Int,x11:Tuple2[Char, Char]) => 
val x12 = x10
val x13 = x11
val x14 = x13._1
val x15 = x13._2
val x16 = List(x14,x15)
val x17 = x16.right[java.lang.String]
val x18 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x12,x17)
x18: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x46 = "Error: Expected a, but reached end of input.".left[Char]
val x64 = "Error: Expected c, but reached end of input.".left[Char]
val x29 = {(x20:Int,x21:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x22 = x20
val x23 = x21
val x24 = x23._1
val x25 = x23._2
val x26 = x24 :: x25
val x27 = x26.right[java.lang.String]
val x28 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x22,x27)
x28: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x96 = "Error: Expected b, but reached end of input.".left[Char]
val x201 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x204 = {(x8:Int,x9:java.lang.String) => 
val x120 = x8
val x121 = x9
val x122 = x121.length
val x123 = x120 < x122
val x203 = if (x123) {
val x124 = x121.charAt(x120)
val x125 = 'a' == x124
val x200 = if (x125) {
val x136 = if (x123) {
val x126 = x124 == 'a'
val x134 = if (x126) {
val x127 = x120 + 1
val x128 = x124.right[java.lang.String]
val x129 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x127,x128)
x129
} else {
val x130 = "Error: Expected a, got "+x124
val x131 = x130+"."
val x132 = x131.left[Char]
val x133 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x120,x132)
x133
}
x134
} else {
val x135 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x120,x46)
x135
}
val x163 = {(x137:Int,x138:Char) => 
val x139 = x137
val x141 = x139 < x122
val x153 = if (x141) {
val x142 = x121.charAt(x139)
val x143 = x142 == 'c'
val x151 = if (x143) {
val x144 = x139 + 1
val x145 = x142.right[java.lang.String]
val x146 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x144,x145)
x146
} else {
val x147 = "Error: Expected c, got "+x142
val x148 = x147+"."
val x149 = x148.left[Char]
val x150 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x139,x149)
x150
}
x151
} else {
val x152 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x139,x64)
x152
}
val x140 = x138
val x161 = {(x154:Int,x155:Char) => 
val x156 = x154
val x157 = x155
val x158 = new Tuple2[Char, Char](x140,x157)
val x159 = x158.right[java.lang.String]
val x160 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]](x156,x159)
x160: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x162 = x153._2 match {
        case -\/(s) => (x153._1, -\/(s))
        case \/-(t) => x161(x153._1, t)
      }
x162: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, Char]]]
}
val x164 = x136._2 match {
        case -\/(s) => (x136._1, -\/(s))
        case \/-(t) => x163(x136._1, t)
      }
val x165 = x164._2 match {
        case -\/(s) => (x164._1, -\/(s))
        case \/-(t) => x19(x164._1, t)
      }
x165
} else {
val x166 = 'b' == x124
val x199 = if (x166) {
val x174 = if (x123) {
val x167 = x124 == 'b'
val x172 = if (x167) {
val x127 = x120 + 1
val x128 = x124.right[java.lang.String]
val x129 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x127,x128)
x129
} else {
val x168 = "Error: Expected b, got "+x124
val x169 = x168+"."
val x170 = x169.left[Char]
val x171 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x120,x170)
x171
}
x172
} else {
val x173 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x120,x96)
x173
}
val x192 = {(x175:Int,x176:Char) => 
val x179 = x7
val x177 = x175
val x181 = x179(x177,x121)
val x178 = x176
val x189 = {(x182:Int,x183:scala.collection.immutable.List[Char]) => 
val x184 = x182
val x185 = x183
val x186 = new Tuple2[Char, scala.collection.immutable.List[Char]](x178,x185)
val x187 = x186.right[java.lang.String]
val x188 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x184,x187)
x188: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x190 = x181._2 match {
        case -\/(s) => (x181._1, -\/(s))
        case \/-(t) => x189(x181._1, t)
      }
x190: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x193 = x174._2 match {
        case -\/(s) => (x174._1, -\/(s))
        case \/-(t) => x192(x174._1, t)
      }
val x194 = x193._2 match {
        case -\/(s) => (x193._1, -\/(s))
        case \/-(t) => x29(x193._1, t)
      }
x194
} else {
val x195 = "Error: Token "+x124
val x196 = x195+" matches neither possible branch."
val x197 = x196.left[scala.collection.immutable.List[Char]]
val x198 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x120,x197)
x198
}
x199
}
x200
} else {
val x202 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x120,x201)
x202
}
x203: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x7 = x204
val x206 = x7
val x208 = x206(x0,x1)
x208
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
