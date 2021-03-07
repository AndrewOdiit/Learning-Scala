package GenericsAndFunctions.SequencingComputation.exercises

object SumTypeExercise extends App{
  sealed trait Sum[A, B] {
    def fold[C](left: A => C, right: B => C): C =
      this match {
        case Failure(a) => left(a)
        case Success(b) => right(b)
      }
    def map[C](fn: B => C):Sum[A, C] ={
      this match {
        case Failure(a) => Failure(a)
        case Success(b) => Success(fn(b))
      }
    }

    def flatMap[C](fn: B => Sum[C, A]):Sum[C, A] ={
      this match {
        case Failure(a) => Failure(a)
        case Success(b) => fn(b)
      }
    }
  }
  final case class Failure[A, B](value: A) extends Sum[A, B]
  final case class Success[A, B](value: B) extends Sum[A, B]
}
