package ObjectsAndClasses


object CompanionObjects  extends App {
  /*a companion object is an object with the same name as a class
  that implements the apply() method.
  */
   class Person(val firstName:String, val lastName: String){
      def say_hi(): String ={
        s"Hello my names are ${firstName} ${lastName}"
      }
  }
  object Person {
    def apply(fullNames: String): Person = {
      val parts = fullNames.split(" ")
      new Person(parts(0), parts(1))
    }
  }

  val person = Person("Andrew Odiit")
  println(person.say_hi())



  //Directional Debut
  class Director(val firstName:String, val lastName:String, val yearOfBirth:Int) {
    def name(): String = {
      this.firstName + " " + this.lastName
    }
  }

  object Director{
    def apply(firstName:String, lastName:String, yearOfBirth:Int):Director={
        new Director(firstName = firstName, lastName=lastName, yearOfBirth=yearOfBirth)
    }
    def oldest(director1: Director, director2: Director):Director={
      if (director1.yearOfBirth < director2.yearOfBirth) director1
      else if (director1.yearOfBirth > director2.yearOfBirth) director2
      else throw new NoSuchFieldException
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

  object Film{
    def apply(name:String, yearOfRelease:Int, imdbRating:Double, director: Director):Film={
      new Film(name=name, yearOfRelease=yearOfRelease,director=director, imdbRating=imdbRating)
    }

    def highestRating(film1:Film, film2:Film):Film={
      if(film1.imdbRating > film2.imdbRating) film1
      else if (film2.imdbRating > film1.imdbRating) film2
      else throw new NoSuchElementException
    }
    def oldestDirectorATTheTime(film1:Film, film2:Film):Director={
      if(film1.directorsAge() > film2.directorsAge()) film1.director
      else if (film2.directorsAge() > film1.directorsAge()) film2.director
      else throw new NoSuchElementException
    }

  }

  val director1 = new Director(firstName = "Christopher", lastName = "Nolan", yearOfBirth = 1970)
  val director2 = new Director(firstName = "Michael", lastName = "Bay", yearOfBirth = 1965)

  val directorSingleton = Director //call without brackets to avoid invoking apply method.
  println(directorSingleton.oldest(director1, director2).name())

  val film1 = new Film(name="Transformers: Dark side of the moon", yearOfRelease =2011, imdbRating = 6.2, director=director2)
  val film2 = new Film(name="Tenet", yearOfRelease = 2020, imdbRating = 7.5, director = director1)

  val filmSingleton = Film
  println(filmSingleton.highestRating(film1, film2).describe())

  println(filmSingleton.oldestDirectorATTheTime(film1, film2).name())





}
