package ObjectsAndClasses

object CatsAndHollywood extends  App {
  class Cat(val name:String, val colour:String, val food: String){
    def about:String={
      s"Name: ${this.name}, Colour ${this.colour}, Food ${this.food}"
    }
  }

  object ChipShop{
    def willServer(cat:Cat): Boolean ={cat.food == "Chips"}
  }

  val oswald = new Cat("Oswald", "Black", "Milk")
  val henderson = new Cat("Henderson", "Ginger", "Chips")
  val quentin = new Cat("Quentin", "Tabby and white", "Curry")

  /*
  println(ChipShop.willServer(oswald))
  println(ChipShop.willServer(henderson))
  println(ChipShop.willServer(quentin))

  println(oswald.about)
  println(henderson.about)
  println(quentin.about)
   */

//Directional Debut
  class Director(val firstName:String, val lastName:String, val yearOfBirth:Int) {
  def name(): String = {
    this.firstName + " " + this.lastName
  }
}

  class Film(val name:String, val yearOfRelease:Int, val imdbRating:Double, val director: Director){

    def directorsAge():Int={
      this.yearOfRelease - director.yearOfBirth
    }

    def isDirectedBy(director: Director):Boolean={
      this.director.name() == director.name()
    }

    def copy(name:String="Original Sin ", yearOfRelease:Int=2001, imdbRating:Double=6.1, director: Director): Film ={
          new Film(name=name,yearOfRelease=yearOfRelease, director=director, imdbRating=imdbRating)
    }

    def describe()={
     s"${this.name},${this.yearOfRelease}, ${this.imdbRating}, ${this.director.name()}"
    }
  }

  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someBody = new Director("Just", "Some Body", 1990)


  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7,
    eastwood)
  val outlawJoseyWales
  = new Film("The Outlaw Josey Wales", 1976, 7.9,
    eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990,
    7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8,
    mcTiernan)


  println(eastwood.yearOfBirth)
  println(dieHard.director.name)
  println(invictus.isDirectedBy(nolan))

  println(inception.copy(director = mcTiernan).describe())
}
