package GenericsAndFunctions.SequencingComputation.exercises

object FlatMapExercise extends App {
  val list = List(1, 2, 3)
  println(list.flatMap(x => List(x, x * -1)))
}
