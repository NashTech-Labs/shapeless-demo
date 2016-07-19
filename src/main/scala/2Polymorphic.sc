

import shapeless.{HNil, Poly1}
import shapeless.poly._



val listToSet = new (List ~> Set){
  def apply[T](list:List[T]):Set[T]= list.toSet
}

val result = listToSet(List(1.0,2.0,3.0,4.0))




object size extends Poly1 {
  implicit def caseInt = at[Int](x ⇒ 1)

  implicit def caseString = at[String](_.length)

  implicit def caseTuple[T, U](implicit st: Case.Aux[T, Int], su: Case.Aux[U, Int]) =
    at[(T, U)](t ⇒ size(t._1) + size(t._2))
}


size(23)
size("FOO")
size((23, "foo"))
size(((23, "foo"), 13))
size(((23,23),"foo"))


//passing polymorphic functions to methods

// findHead is a function from Sets to Options with no type specific cases

object findHead extends (Set ~> Option) {
  def apply[T](s: Set[T]) = s.headOption
}


def pairApply(f: Set ~> Option) = (f(Set(1, 2, 3)), f(Set('a', 'b', 'c')), f(Set("head", 2, "deepti")), f(Set()))

pairApply(findHead)





