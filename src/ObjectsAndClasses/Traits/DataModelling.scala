package ObjectsAndClasses.Traits

object DataModelling extends App{
  //sum data type

  /*
  A traffic light is red, green, or yellow. Translate this description on into Scala code.
   */
  sealed trait TrafficLight{
    def color: String
  }

  // These should be objects ,since there is no need to instantiate
  final case object RedLight extends TrafficLight{
    val color ="Red"
  }
  final case object YellowLight extends TrafficLight{
    val color ="Yellow"
  }
  final case  object GreenLight extends TrafficLight{
    val color ="Green"
  }

  /*
    implement the next method
   */
  def nextLight(trafficLight:TrafficLight): TrafficLight={
    trafficLight match {
      case RedLight => YellowLight
      case YellowLight => GreenLight
      case GreenLight => RedLight
    }
  }

//  println(s" Red --> ${nextLight(RedLight).color}")
//  println(s" Yellow --> ${nextLight(YellowLight).color}")
//  println(s" Green --> ${nextLight(GreenLight).color}")



  /*
  A calculator on may succeed (with an Int result) or fail (with a String message).
  Implement this.
   */
  sealed trait Calculation

  final case class Success(result:Int) extends  Calculation {
    def apply(): Int ={
      result
    }
  }

  final case class Failure(reason:String) extends  Calculation {}

  case object Calculator{
    def +(a:Calculation, b:Int): Calculation ={
       a match{
         case Success(someInt) => Success(someInt + b)
         case Failure(someMsg) => Failure(someMsg)
       }
    }

    def -(a:Calculation, b:Int): Calculation ={
      a match {
        case Success(someInt) => Success(someInt - b)
        case Failure(someMsg) => Failure(someMsg)
      }
    }


    def /(a:Calculation, b:Int):Calculation={
      a match {
        case Failure(someMsg) => Failure(someMsg)
        case _ if b <= 0 => Failure("Division by zero")
        case Success(someInt) => Success(someInt/b)
      }

    }
  }

  assert(Calculator.+(Success(1), 1) == Success(2))
  assert(Calculator.-(Success(1), 1) == Success(0))
  assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
  println("Calculator (+/-) tests passed...")

  assert(Calculator./(Success(4), 2) == Success(2))
  assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
  assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))
  println("Calculator (division) tests passed...")

  /*
  Bottled water has a size (an Int ), a source (which is a well, spring, or tap), and
  a Boolean carbonated. Implement this in Scala.
   */
  case class BottledWater(size:Int, source:Source, carbonated:Boolean){

  }

  sealed trait Source
  final case class Spring() extends Source{}
  final case class Well() extends Source{}
  final case class Tap() extends Source{}
}
