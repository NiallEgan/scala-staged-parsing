import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class BracketsAParser extends ((scala.collection.BufferedIterator[Char])=>(\/[java.lang.String, scala.collection.immutable.List[Char]])) {
def apply(x97:scala.collection.BufferedIterator[Char]): \/[java.lang.String, scala.collection.immutable.List[Char]] = {
val x101 = {x98: (scala.collection.BufferedIterator[Char]) => 
val x99 = throw new Exception("Bottom")
x99: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
var x102: scala.Function1[scala.collection.BufferedIterator[Char], \/[java.lang.String, scala.collection.immutable.List[Char]]] = x101
val x89 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x19 = "Error: Expected a, but reached end of input.".left[Char]
val x120 = {x117: (Char) => 
val x118 = List(x117)
val x119 = x118.right[java.lang.String]
x119: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x133 = "Error: Expected (, but reached end of input.".left[Char]
val x150 = "Error: Expected ), but reached end of input.".left[Char]
val x168 = {x163: (Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x164 = x163._1
val x165 = x163._2
val x166 = x164 :: x165
val x167 = x166.right[java.lang.String]
x167: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x183 = {x178: (Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x179 = x178._1
val x180 = x178._2
val x181 = x179 ::: x180
val x182 = x181.right[java.lang.String]
x182: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x198 = {x193: (Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x194 = x193._1
val x195 = x193._2
val x196 = x194 :: x195
val x197 = x196.right[java.lang.String]
x197: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
val x210 = {x103: (scala.collection.BufferedIterator[Char]) => 
val x104 = x103.hasNext
val x208 = if (x104) {
val x105 = x103.head
val x106 = 'a' == x105
val x206 = if (x106) {
val x116 = if (x104) {
val x107 = x105 == 'a'
val x114 = if (x107) {
val x108 = x103.next()
val x109 = x108.right[java.lang.String]
x109
} else {
val x111 = "Error: Expected a, got "+x105
val x112 = x111+"."
val x113 = x112.left[Char]
x113
}
x114
} else {
x19
}
val x121 = x116 >>= x120
x121
} else {
val x123 = '(' == x105
val x204 = if (x123) {
val x134 = if (x104) {
val x124 = x105 == '('
val x131 = if (x124) {
val x125 = x103.next()
val x126 = x125.right[java.lang.String]
x126
} else {
val x128 = "Error: Expected (, got "+x105
val x129 = x128+"."
val x130 = x129.left[Char]
x130
}
x131
} else {
x133
}
val x161 = {x152: (Char) => 
val x153 = x102
val x154 = x153(x103)
val x158 = {x155: (scala.collection.immutable.List[Char]) => 
val x156 = new Tuple2[Char, scala.collection.immutable.List[Char]](x152,x155)
val x157 = x156.right[java.lang.String]
x157: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x159 = x154 >>= x158
x159: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x176 = {x138: (scala.collection.immutable.List[Char]) => 
val x139 = x103.hasNext
val x151 = if (x139) {
val x140 = x103.head
val x141 = x140 == ')'
val x148 = if (x141) {
val x142 = x103.next()
val x143 = x142.right[java.lang.String]
x143
} else {
val x145 = "Error: Expected ), got "+x140
val x146 = x145+"."
val x147 = x146.left[Char]
x147
}
x148
} else {
x150
}
val x162 = x151 >>= x161
val x169 = x162 >>= x168
val x173 = {x170: (scala.collection.immutable.List[Char]) => 
val x171 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x138,x170)
val x172 = x171.right[java.lang.String]
x172: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]
}
val x174 = x169 >>= x173
x174: \/[java.lang.String, Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]
}
val x191 = {x135: (Char) => 
val x136 = x102
val x137 = x136(x103)
val x177 = x137 >>= x176
val x184 = x177 >>= x183
val x188 = {x185: (scala.collection.immutable.List[Char]) => 
val x186 = new Tuple2[Char, scala.collection.immutable.List[Char]](x135,x185)
val x187 = x186.right[java.lang.String]
x187: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x189 = x184 >>= x188
x189: \/[java.lang.String, Tuple2[Char, scala.collection.immutable.List[Char]]]
}
val x192 = x134 >>= x191
val x199 = x192 >>= x198
x199
} else {
val x201 = "Error: Token "+x105
val x202 = x201+" matches neither possible branch."
val x203 = x202.left[scala.collection.immutable.List[Char]]
x203
}
x204
}
x206
} else {
x89
}
x208: \/[java.lang.String, scala.collection.immutable.List[Char]]
}
x102 = x210
val x212 = x102
val x213 = x212(x97)
x213
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
