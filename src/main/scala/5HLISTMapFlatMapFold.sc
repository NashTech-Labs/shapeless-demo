import shapeless.{HNil, Poly1, Poly2}
import shapeless.poly._
import shapeless.syntax.zipper._
import scala.reflect.runtime.universe._
import shapeless.syntax.typeable._


object findHead extends (Set ~> Option) {
  def apply[T](s: Set[T]) = s.headOption
}

val hlistOfSet = Set(1.2f,1,23,4) :: Set("you","me",1) :: HNil

//map operation on Hlist using polymorphic function1

val heads = hlistOfSet map findHead


//map operation on Hlist using polymorphic function2

val xs =1 ::"hello" :: HNil
object inc extends Poly1
{
  implicit def caseInt=at[Int](_+1)
  implicit def caseString=at[String](_.reverse)
}
val ys = xs map inc



//flatMap operation in Hlists



val hlist = (23 :: "foo" :: HNil)  :: (true :: HNil) :: HNil

val flatList = hlist flatMap identity


//foldLeft on Hlists

object size extends Poly1 {
  implicit def caseInt = at[Int](x ⇒ 1)

  implicit def caseString = at[String](_.length)

  implicit def caseTuple[T, U](implicit st: Case.Aux[T, Int], su: Case.Aux[U, Int]) =
    at[(T, U)](t ⇒ size(t._1) + size(t._2))
}

object addSize extends Poly2 {
  implicit def default[T](implicit st: size.Case.Aux[T, Int]) =
    at[Int, T] { (acc, t) => acc + size(t) }
}


val list2 = 23 :: "foo" :: (13, "wibble") :: HNil

println("here:::"+ list2.foldLeft(0)(addSize))




