import shapeless.HNil

val list = "Scala" :: 1 :: true :: Nil



list(0)



val hlist = 10 :: "anyString" :: 1.0 :: HNil

hlist(0)

// toUpperCase is not defined on Any
//list.head.toUpperCase

hlist.tail.head.toUpperCase()