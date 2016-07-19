def monomorphicfunc(s: String): Int = s.length


monomorphicfunc("foo")



def polymorphicfunc[T](l: List[T]): Set[T] = l.toSet

polymorphicfunc(List(1))
polymorphicfunc(List("foo", "bar", "baz"))
polymorphicfunc(List("deepti", 1,None, 12))

//creating a monomorphic function value

val a = monomorphicfunc _

a("deepti!!!")

//creating a polymorphic function value

val b = polymorphicfunc _

//b(List(1,2,3))




