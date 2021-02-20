package ObjectsAndClasses.Traits

object DataModelling extends App{
  //sum data type

  /*
  A traffic light is red, green, or yellow. Translate this descrip on into Scala code.
   */
  sealed trait TrafficLight{
    def color: String
  }

  // These should be objects ,since there is no need to instantiate
  final case class RedLight() extends TrafficLight{
    val color ="Red"
  }
  final case class YellowLight() extends TrafficLight{
    val color ="Yellow"
  }
  final case class GreenLight() extends TrafficLight{
    val color ="Green"
  }

  /*
  A calculator on may succeed (with an Int result) or fail (with a String message).
  Implement this.
   */
  sealed trait CalculatorResult

  final case class Success() extends  CalculatorResult {
    def apply(): Int ={
      1
    }
  }

  final case class Fail() extends  CalculatorResult {
    def apply():String={
      "Calculation failed."
    }
  }


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
