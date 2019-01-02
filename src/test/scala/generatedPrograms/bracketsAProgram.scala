import scalaz._
import Scalaz._
/*****************************************
  Emitting Generated Code                  
*******************************************/
class BracketsAParser extends ((Int, java.lang.String)=>(Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]])) {
def apply(x123:Int, x124:java.lang.String): Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]] = {
val x129 = {(x125:Int,x126:java.lang.String) => 
val x127 = throw new Exception("Bottom")
x127: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
var x130: scala.Function2[Int,java.lang.String,Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]] = x129
val x25 = "Error: Expected a, but reached end of input.".left[Char]
val x157 = {(x150:Int,x151:Char) => 
val x152 = x150
val x153 = x151
val x154 = List(x153)
val x155 = x154.right[java.lang.String]
val x156 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x152,x155)
x156: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x166 = "Error: Expected (, but reached end of input.".left[Char]
val x191 = "Error: Expected ), but reached end of input.".left[Char]
val x222 = {(x213:Int,x214:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x215 = x213
val x216 = x214
val x217 = x216._1
val x218 = x216._2
val x219 = x217 :: x218
val x220 = x219.right[java.lang.String]
val x221 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x215,x220)
x221: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x244 = {(x235:Int,x236:Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]) => 
val x237 = x235
val x238 = x236
val x239 = x238._1
val x240 = x238._2
val x241 = x239 ::: x240
val x242 = x241.right[java.lang.String]
val x243 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x237,x242)
x243: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x267 = {(x258:Int,x259:Tuple2[Char, scala.collection.immutable.List[Char]]) => 
val x260 = x258
val x261 = x259
val x262 = x261._1
val x263 = x261._2
val x264 = x262 :: x263
val x265 = x264.right[java.lang.String]
val x266 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x260,x265)
x266: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
val x114 = "Error: End of input encountered, but both branches still expecting input.".left[scala.collection.immutable.List[Char]]
val x277 = {(x131:Int,x132:java.lang.String) => 
val x133 = x131
val x134 = x132
val x135 = x134.length
val x136 = x133 < x135
val x276 = if (x136) {
val x137 = x134.charAt(x133)
val x138 = 'a' == x137
val x274 = if (x138) {
val x149 = if (x136) {
val x139 = x137 == 'a'
val x147 = if (x139) {
val x140 = x133 + 1
val x141 = x137.right[java.lang.String]
val x142 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x140,x141)
x142
} else {
val x143 = "Error: Expected a, got "+x137
val x144 = x143+"."
val x145 = x144.left[Char]
val x146 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x133,x145)
x146
}
x147
} else {
val x148 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x133,x25)
x148
}
val x158 = x149._2 match {
        case -\/(s) => (x149._1, -\/(s))
        case \/-(t) => x157(x149._1, t)
      }
x158
} else {
val x159 = '(' == x137
val x273 = if (x159) {
val x168 = if (x136) {
val x160 = x137 == '('
val x165 = if (x160) {
val x140 = x133 + 1
val x141 = x137.right[java.lang.String]
val x142 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x140,x141)
x142
} else {
val x161 = "Error: Expected (, got "+x137
val x162 = x161+"."
val x163 = x162.left[Char]
val x164 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x133,x163)
x164
}
x165
} else {
val x167 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x133,x166)
x167
}
val x211 = {(x194:Int,x195:Char) => 
val x198 = x130
val x196 = x194
val x200 = x198(x196,x134)
val x197 = x195
val x208 = {(x201:Int,x202:scala.collection.immutable.List[Char]) => 
val x203 = x201
val x204 = x202
val x205 = new Tuple2[Char, scala.collection.immutable.List[Char]](x197,x204)
val x206 = x205.right[java.lang.String]
val x207 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x203,x206)
x207: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x209 = x200._2 match {
        case -\/(s) => (x200._1, -\/(s))
        case \/-(t) => x208(x200._1, t)
      }
x209: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x233 = {(x176:Int,x177:scala.collection.immutable.List[Char]) => 
val x178 = x176
val x180 = x178 < x135
val x193 = if (x180) {
val x181 = x134.charAt(x178)
val x182 = x181 == ')'
val x190 = if (x182) {
val x183 = x178 + 1
val x184 = x181.right[java.lang.String]
val x185 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x183,x184)
x185
} else {
val x186 = "Error: Expected ), got "+x181
val x187 = x186+"."
val x188 = x187.left[Char]
val x189 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x178,x188)
x189
}
x190
} else {
val x192 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, Char]](x178,x191)
x192
}
val x212 = x193._2 match {
        case -\/(s) => (x193._1, -\/(s))
        case \/-(t) => x211(x193._1, t)
      }
val x223 = x212._2 match {
        case -\/(s) => (x212._1, -\/(s))
        case \/-(t) => x222(x212._1, t)
      }
val x179 = x177
val x231 = {(x224:Int,x225:scala.collection.immutable.List[Char]) => 
val x226 = x224
val x227 = x225
val x228 = new Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]](x179,x227)
val x229 = x228.right[java.lang.String]
val x230 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]](x226,x229)
x230: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x232 = x223._2 match {
        case -\/(s) => (x223._1, -\/(s))
        case \/-(t) => x231(x223._1, t)
      }
x232: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[scala.collection.immutable.List[Char], scala.collection.immutable.List[Char]]]]
}
val x256 = {(x169:Int,x170:Char) => 
val x173 = x130
val x171 = x169
val x175 = x173(x171,x134)
val x234 = x175._2 match {
        case -\/(s) => (x175._1, -\/(s))
        case \/-(t) => x233(x175._1, t)
      }
val x245 = x234._2 match {
        case -\/(s) => (x234._1, -\/(s))
        case \/-(t) => x244(x234._1, t)
      }
val x172 = x170
val x253 = {(x246:Int,x247:scala.collection.immutable.List[Char]) => 
val x248 = x246
val x249 = x247
val x250 = new Tuple2[Char, scala.collection.immutable.List[Char]](x172,x249)
val x251 = x250.right[java.lang.String]
val x252 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]](x248,x251)
x252: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x254 = x245._2 match {
        case -\/(s) => (x245._1, -\/(s))
        case \/-(t) => x253(x245._1, t)
      }
x254: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.Tuple2[Char, scala.collection.immutable.List[Char]]]]
}
val x257 = x168._2 match {
        case -\/(s) => (x168._1, -\/(s))
        case \/-(t) => x256(x168._1, t)
      }
val x268 = x257._2 match {
        case -\/(s) => (x257._1, -\/(s))
        case \/-(t) => x267(x257._1, t)
      }
x268
} else {
val x269 = "Error: Token "+x137
val x270 = x269+" matches neither possible branch."
val x271 = x270.left[scala.collection.immutable.List[Char]]
val x272 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x133,x271)
x272
}
x273
}
x274
} else {
val x275 = new Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]](x133,x114)
x275
}
x276: Tuple2[Int, scalaz.$bslash$div[java.lang.String, scala.collection.immutable.List[Char]]]
}
x130 = x277
val x279 = x130
val x281 = x279(x123,x124)
x281
}
}
/*****************************************
  End of Generated Code                  
*******************************************/
