package ObjectsAndClasses.patternmatching

import ObjectsAndClasses.CaseClasses.{Director, Film}

object MoveCritic  extends  App{

  case object Dad{
    def rate(movie:Film): Double ={
      val director = movie.director.name()
      director match {
        case "Clint Eastwood" => 10.0
        case "John McTiernan" => 7.0
        case _ =>3.0
      }
    }
  }

  println(Dad.rate(Film("Gran Torino", 2008, 8.1,Director("Clint", "Eastwood", 1930))))
  println(Dad.rate(Film("Die Hard", 1988, 7.4,Director("John", "McTiernan", 1951))))
  println(Dad.rate(Film("Avatar", 2009, 7.8,Director("James", "Cameroon", 1954))))

}
