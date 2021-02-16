package ObjectsAndClasses.patternmatching

import ObjectsAndClasses.CaseClasses.Cat

object FeedTheCats extends App {

  object ChipShop{
     def willServe(cat: Cat):Boolean ={
       cat match{
         case Cat(_, "Chips", _) => true
         case Cat(color,food, name) => false //better to use underscore.
       }
     }
   }
  val oswald = Cat("grey", "Chips","Oswald")
  val garfield = Cat("yellow", "Fish Sticks","Garfield")
  println(ChipShop.willServe(oswald))
  println(ChipShop.willServe(garfield))
}
