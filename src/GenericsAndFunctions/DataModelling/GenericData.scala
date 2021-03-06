package GenericsAndFunctions.DataModelling

object GenericData  extends App {
  //product type generic pattern
  final case class Pair[String, Int](a:String, b:Int){
  }
  val pair = Pair("hello", 1)
  //println(pair.a, pair.b)

  //sum type generic pattern
  sealed trait SumType[A, B]

  final case class Left[A, B](value:A) extends SumType[A, B]
  final case class Right[A, B](value:B) extends  SumType[A,B]

  val left = Left[Int, String](1)
  val right = Right[Int, String]("Hello")

  val sum: SumType[Int, String] = Right("Yo")
  sum match {
    case Left(value) => value
    case Right(value) => value
  }

}
