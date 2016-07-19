import shapeless._
import syntax.std.tuple._

val t  = (1,   "String",   2.0)

//tuple to Hlist conversion

val tupletoHlist = t.productElements


val hlist = 1 :: "String" :: 2.0 ::HNil


//Hlist to tuple conversion

val hlistToTuple = hlist.tupled


//operations supported by Shapeless on tuples

t.reverse
t.tail
t :+ "yay"
t ++ ("yay", 5.0)
