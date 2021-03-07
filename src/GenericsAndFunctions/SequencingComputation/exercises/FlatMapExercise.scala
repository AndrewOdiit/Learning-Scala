package GenericsAndFunctions.SequencingComputation.exercises

import GenericsAndFunctions.SequencingComputation.exercises.MapExercises.{Empty, Full, Maybe}

object FlatMapExercise extends App {
  val list = List(1, 2, 3)
  println(list.flatMap(x => List(x, x * -1)))

  val list2: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))
  val func = (x: Maybe[Int]) => {x match {
    case Full(value) => if (value % 2 == 0) Full(value) else Empty
    case _ => None
    }
  }
  //alternatively , implement use FlatMap inside Map
  println(list2.map((x) => func(x)))
}
