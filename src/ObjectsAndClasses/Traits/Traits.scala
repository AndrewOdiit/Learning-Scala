package ObjectsAndClasses.Traits

import java.util.Date

object Traits  extends  App {
  /*
  sealing a trait allows the compiler to validate any
  pattern matching in the file.
  if all subtypes of a trait are know seal the trait.
  Consider making subtypes final if there is no case for extending them
   */
  sealed trait Visitor{
    def id: String
    def createdAT: Date
    def age:Long = new Date().getTime - createdAT.getTime

  }

  final case class User(id:String,email:String, createdAT:Date) extends  Visitor{
    //it's good practice to never define val's in a trait

  }

  final case class Anonymous(id: String, createdAT:Date) extends Visitor{
    /*lol we can implement the def in trait as val in
      extending method.
     */

  }

  object Visitor{
    /*
    compiler cannot see regular classes , but it can see
    case classes ?
     */
    def checkVisitor(visitor: Visitor): Boolean ={
      visitor match  {
        case User(_,_,_) => true
      }
    }
  }

  val user = User("88ZXY","andrew@email.com", new Date())
  val anonymous = Anonymous("7xs4", new Date())
  println(user.email, user.id, user.createdAT)
  println(anonymous.id, anonymous.createdAT)
  Visitor.checkVisitor(user)
  Visitor.checkVisitor(anonymous)


}

//case class User(value: Any, value1: Any, value2: Any)
