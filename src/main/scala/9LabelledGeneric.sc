import shapeless._
import shapeless.Generic
import record._
import syntax.singleton._



//case class Book
case class Book(author: String, title: String, id: Int, price: Double)

//case class ExtendedBook having one field extra(inPrint) as that of the Book
case class ExtendedBook(author: String, title: String, id: Int, price: Double, inPrint: Boolean)

//creating a Book object
val book = Book("Benjamin Pierce", "Types and Programming Languages", 262162091, 44.11)

//LabelledGeneric representation of the Book
val bookGen = LabelledGeneric[Book]

//LabelledGeneric representation of the ExtendedBook
val bookExtGen = LabelledGeneric[ExtendedBook]

//HList representation of the book
val rec = bookGen.to(book)
rec('author)


//creating ExtendedBook object from book by using + operator for the extra field(inPrint) along with its value(true)
val bookExtended = bookExtGen.from(rec + ('inPrint ->> true))






















//case class FreeSampleBook having one field less(price) as that of the Book
case class FreeSampleBook(author: String, title: String, id: Int)

//LabelledGeneric representation of the FreeSampleBook
val freeSampleBookGen = LabelledGeneric[FreeSampleBook]

//creating FreeSampleBook object from book by using - operator for the absent field(price)
val freeSampleBook= freeSampleBookGen.from(bookGen.to(book) - ('price))
