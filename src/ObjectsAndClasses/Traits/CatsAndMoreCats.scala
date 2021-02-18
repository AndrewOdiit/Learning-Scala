package ObjectsAndClasses.Traits

object CatsAndMoreCats extends  App {
  //lol , override can be used inside the trait.
  trait Feline {
     def colour:String
     def sound:String = {
       "roar"
     }
   }

  case class Tiger(colour:String) extends Feline{
  }

  case class Cat(colour:String, fav_food:String) extends  Feline{
    override def sound: String = {
      "Meow"
    }
  }

  case class Lion(colour:String, maneSize:Int)extends  Feline{
  }

  val tiger = Tiger("Yellow")
  val cat  = Cat("Black", "Mice")
  val lion = Lion("Brown", 10)
  println(tiger.colour, tiger.sound)
  println(cat.colour, cat.fav_food, cat.sound)
  println(lion.colour, lion.sound, lion.maneSize)
}
