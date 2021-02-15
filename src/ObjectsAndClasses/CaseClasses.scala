package ObjectsAndClasses


object CaseClasses extends App {
  case class Cat(color:String, food:String, name:String)
  val oswald = Cat(color="Grey", food="tuna", name="Oswald")
  println(oswald.toString)

  case class Director(firstName:String, lastName:String, yearOfBirth:Int){
    def name(): String = {
      this.firstName + " " + this.lastName
    }

    def oldest(director1: Director, director2: Director):Director={
      if (director1.yearOfBirth < director2.yearOfBirth) director1
      else if (director1.yearOfBirth > director2.yearOfBirth) director2
      else throw new NoSuchFieldException
    }
  }

  object Director{
    def oldest(director1: Director, director2: Director):Director={
      if (director1.yearOfBirth < director2.yearOfBirth) director1
      else if (director1.yearOfBirth > director2.yearOfBirth) director2
      else throw new NoSuchFieldException
    }

  }

  case class Film(name:String, yearOfRelease:Int, imdbRating:Double, director: Director){

    def directorsAge():Int={
      this.yearOfRelease - director.yearOfBirth
    }

    def isDirectedBy(director: Director):Boolean={
      this.director.name() == director.name()
    }
  }

  object Film{
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

//  val director1 = new Director(firstName = "Christopher", lastName = "Nolan", yearOfBirth = 1970)
//  val director2 = new Director(firstName = "Michael", lastName = "Bay", yearOfBirth = 1965)
//
//  val directorSingleton = Director //call without brackets to avoid invoking apply method.
//  println(directorSingleton.oldest(director1, director2).name())
//
//  val film1 = new Film(name="Transformers: Dark side of the moon", yearOfRelease =2011, imdbRating = 6.2, director=director2)
//  val film2 = new Film(name="Tenet", yearOfRelease = 2020, imdbRating = 7.5, director = director1)
//
//  val filmSingleton = Film
//  println(filmSingleton.highestRating(film1, film2).name)
//
//  println(filmSingleton.oldestDirectorATTheTime(film1, film2).name)



  //case class Counter

  case class Counter(count:Int=0){
    def inc(by:Int=1) ={
      this.copy(this.count + by)
    }

    def dec(by:Int=1):Counter={
      this.copy(this.count - by)
    }
  }

  val counter = Counter()
  println(counter.inc().inc().inc().dec().toString)


}
