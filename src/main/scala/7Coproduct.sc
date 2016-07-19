import shapeless.{:+:, CNil, Coproduct, Poly1}
import java.lang.Object

type ISB = Int :+: String :+: Boolean :+: CNil

val isb = Coproduct[ISB]("foo")

isb.select[Int]
isb.select[String]



object size extends Poly1 {
  implicit def caseInt = at[Int](i => (i, i))
  implicit def caseString = at[String](s => (s, s.length))
  implicit def caseBoolean = at[Boolean](b => (b, 1))
}

val a = isb map size

a.select[(String, Int)]
a.select[(Int,Int)]



