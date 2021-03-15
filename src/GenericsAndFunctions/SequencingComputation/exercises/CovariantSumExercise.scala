package GenericsAndFunctions.SequencingComputation.exercises

object CovariantSumExercise  extends App{
  sealed trait Sum[+A, +B]{
     def flatMap[C](fn:(B)=> Sum[A, C]):Sum[A, C]={
       this match {
         case Success(v) => fn(v)
         case Failure(v)=> Failure(v)
       }
     }
  }

  final case class Success[B](value:B) extends Sum[Nothing, B]
  final case class Failure[A](value: A) extends Sum[A, Nothing]
}
