import shapeless.HMap
import shapeless.HNil

class BiMapIS[K, V]
implicit val intToString = new BiMapIS[Int,String]

implicit val stringToInt = new BiMapIS[String, Int]

val hm = HMap[BiMapIS](23 -> "foo", "bar" -> 13)

hm.get("bar")

//viewing the map as a polymorphic function value

import hm._
val l = 23 :: "bar" :: HNil
val m = l map hm

val map = Map(23 -> "foo", "bar" -> 13) //notice the type of key and value and compare it with that of HMap
map.get(23)