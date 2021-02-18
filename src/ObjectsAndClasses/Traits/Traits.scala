package ObjectsAndClasses.Traits

import java.util.Date

class Traits {
  trait Visitor{
    def id: String
    def createdAT: Date
    def age:Long = new Date().getTime - createdAT.getTime
  }

  class User(val email:String) extends  Visitor{
    //it's good practice to never define val's in a trait
    override def id: String = ???

    override def createdAT: Date = ???
  }

  case class Anonymous(id: String, createdAT:Date) extends Visitor{
    /*lol we can implement the def in trait as val in
      extending method.
     */

  }


}
