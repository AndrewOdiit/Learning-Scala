package ObjectsAndClasses.Traits

object ZeroDivision extends App {
  sealed trait DivisionResult
  object Divide{
    def apply(a:Int, b:Int):DivisionResult ={
       if (b <= 0){
         Infinite
       }else{
         Finite(a / b)
       }
    }
  }
  case object Infinite extends DivisionResult

  case class Finite(result: Double) extends DivisionResult{
    def apply(): Double = {
      result
    }
  }

  def getDivisionResult(a:Int, b:Int): String ={
    Divide(a,b) match {
      case Infinite => "Zero division error has occurred"
      case Finite(result) => s" $a / $b ==> ${result}"
    }
  }


  println(getDivisionResult(1,0))
  println(getDivisionResult(12,4))
}
