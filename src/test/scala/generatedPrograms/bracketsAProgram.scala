import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class BracketsAParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x119:Int, x120:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x125 = {(x121:Int,x122:java.lang.String) => 
val x123 = throw new Exception("Bottom")
x123: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x126: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x125
val x134 = {(x129:Int,x130:Char) => 
val x131 = List(x130)
val x132 = x131.right[java.lang.String]
val x133 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x129,x132)
x133: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x38 = "Error: Expected a, but reached end of input.".left[Char]
val x158 = {(x151:Int,x152:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x153 = x152._1
val x154 = x152._2
val x155 = x153 :: x154
val x156 = x155.right[java.lang.String]
val x157 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x151,x156)
x157: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x150 = {(x143:Int,x144:Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x145 = x144._1
val x146 = x144._2
val x147 = x145 ::: x146
val x148 = x147.right[java.lang.String]
val x149 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x143,x148)
x149: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x142 = {(x135:Int,x136:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x137 = x136._1
val x138 = x136._2
val x139 = x137 :: x138
val x140 = x139.right[java.lang.String]
val x141 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x135,x140)
x141: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x203 = "Error: Expected ), but reached end of input.".left[Char]
val x182 = "Error: Expected (, but reached end of input.".left[Char]
val x110 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x269 = {(x127:Int,x128:java.lang.String) => 
val x159 = x128.length
val x160 = x127 < x159
val x268 = if (x160) {
val x161 = x128.charAt(x127)
val x162 = x161 == 'a'
val x266 = if (x162) {
val x172 = if (x160) {
val x170 = if (x162) {
val x163 = x127 + 1
val x164 = x161.right[java.lang.String]
val x165 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x163,x164)
x165
} else {
val x166 = "Error: Expected a, got "+x161
val x167 = x166+"."
val x168 = x167.left[Char]
val x169 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x127,x168)
x169
}
x170
} else {
val x171 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x127,x38)
x171
}
val x173 = x172._1
val x174 = x172._2
val x175 = x174 match {
        case -\/(s) => (x173, -\/(s))
        case \/-(t) => x134(x173, t)
      }
x175
} else {
val x176 = x161 == '('
val x265 = if (x176) {
val x221 = {(x206:Int,x207:Char) => 
val x208 = x126
val x210 = x208(x206,x128)
val x216 = {(x211:Int,x212:scala.collection.immutable.List[Char]) => 
val x213 = new Tuple2[Char, scala.collection.immutable.List[Char]](x207,x212)
val x214 = x213.right[java.lang.String]
val x215 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x211,x214)
x215: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x217 = x210._1
val x218 = x210._2
val x219 = x218 match {
        case -\/(s) => (x217, -\/(s))
        case \/-(t) => x216(x217, t)
      }
x219: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x237 = {(x190:Int,x191:scala.collection.immutable.List[Char]) => 
val x233 = {(x228:Int,x229:scala.collection.immutable.List[Char]) => 
val x230 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x191,x229)
val x231 = x230.right[java.lang.String]
val x232 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]](x228,x231)
x232: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x192 = x190 < x159
val x205 = if (x192) {
val x193 = x128.charAt(x190)
val x194 = x193 == ')'
val x202 = if (x194) {
val x195 = x190 + 1
val x196 = x193.right[java.lang.String]
val x197 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x195,x196)
x197
} else {
val x198 = "Error: Expected ), got "+x193
val x199 = x198+"."
val x200 = x199.left[Char]
val x201 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x190,x200)
x201
}
x202
} else {
val x204 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x190,x203)
x204
}
val x222 = x205._1
val x223 = x205._2
val x224 = x223 match {
        case -\/(s) => (x222, -\/(s))
        case \/-(t) => x221(x222, t)
      }
val x225 = x224._1
val x226 = x224._2
val x227 = x226 match {
        case -\/(s) => (x225, -\/(s))
        case \/-(t) => x142(x225, t)
      }
val x234 = x227._1
val x235 = x227._2
val x236 = x235 match {
        case -\/(s) => (x234, -\/(s))
        case \/-(t) => x233(x234, t)
      }
x236: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x254 = {(x185:Int,x186:Char) => 
val x187 = x126
val x189 = x187(x185,x128)
val x249 = {(x244:Int,x245:scala.collection.immutable.List[Char]) => 
val x246 = new Tuple2[Char, scala.collection.immutable.List[Char]](x186,x245)
val x247 = x246.right[java.lang.String]
val x248 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x244,x247)
x248: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x238 = x189._1
val x239 = x189._2
val x240 = x239 match {
        case -\/(s) => (x238, -\/(s))
        case \/-(t) => x237(x238, t)
      }
val x241 = x240._1
val x242 = x240._2
val x243 = x242 match {
        case -\/(s) => (x241, -\/(s))
        case \/-(t) => x150(x241, t)
      }
val x250 = x243._1
val x251 = x243._2
val x252 = x251 match {
        case -\/(s) => (x250, -\/(s))
        case \/-(t) => x249(x250, t)
      }
x252: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x184 = if (x160) {
val x181 = if (x176) {
val x163 = x127 + 1
val x164 = x161.right[java.lang.String]
val x165 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x163,x164)
x165
} else {
val x177 = "Error: Expected (, got "+x161
val x178 = x177+"."
val x179 = x178.left[Char]
val x180 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x127,x179)
x180
}
x181
} else {
val x183 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x127,x182)
x183
}
val x255 = x184._1
val x256 = x184._2
val x257 = x256 match {
        case -\/(s) => (x255, -\/(s))
        case \/-(t) => x254(x255, t)
      }
val x258 = x257._1
val x259 = x257._2
val x260 = x259 match {
        case -\/(s) => (x258, -\/(s))
        case \/-(t) => x158(x258, t)
      }
x260
} else {
val x261 = "Error: Token "+x161
val x262 = x261+" matches neither possible branch."
val x263 = x262.left[scala.collection.immutable.List[Char]]
val x264 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x127,x263)
x264
}
x265
}
x266
} else {
val x267 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x127,x110)
x267
}
x268: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x126 = x269
val x271 = x126
val x273 = x271(x119,x120)
x273
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
