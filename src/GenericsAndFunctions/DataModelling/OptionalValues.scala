package GenericsAndFunctions.DataModelling

object OptionalValues extends  App{
  sealed trait Maybe[A] {
    def fold[B](empty:B, fn:(A)=>B):B={
      this match {
        case Full(value) =>fn(value)
        case Empty() =>  empty
      }
    }
  }

  final case class Full[A](value:A) extends Maybe[A]
  final case class Empty[A]() extends  Maybe[A]

//  val perhaps: Maybe[Int] = Empty[Int]
//  val definitely: Maybe[Int] = Full[Int](2)


}
