import shapeless.Generic

import shapeless._
import shapeless.syntax._

// Intern and Employee have the same fields
case class Intern(name: String, email: String,id :Int, address:String)

case class Employee(ename:String,eemail: String,eid :Int, eaddress:String)

//creating an object of Intern
val intern = Intern("Mohit", "mohit@gmail.com", 1, "Delhi")

// creating a generic representation of the Intern case class
val genIntern = Generic[Intern]

// creating a generic representation of the Employee case class
val genEmployee = Generic[Employee]

//HList representation of the intern object
val rec = genIntern.to(intern)

//constructing employee from rec as both the case classes have same generic representation
val employee = genEmployee.from(rec)

println(employee)