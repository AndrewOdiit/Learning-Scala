package GenericsAndFunctions.SequencingComputation.exercises

object MapExercises  extends  App{
  sealed trait LinkedList[A]{
    def map[B](fn: A => B): LinkedList[B]={
      this match {
        //transform head from A to B and go deeper.
        case Pair(hd, tl) => Pair(fn(hd),tl.map(fn))
        case End() => End[B]()
      }
    }
  }

  final case class Pair[A](head: A, tail: LinkedList[A]) extends
    LinkedList[A]
  final case class End[A]() extends LinkedList[A]

  sealed trait Maybe[A]{
    //context stays the same in map but the value changes.
    def map[B](fn: A => B): Maybe[B]={
       this match {
         case Full(value) => Full(fn(value))
         case Empty() => Empty[B]()
       }
    }
  }

  final case class Full[A](value:A) extends  Maybe[A]
  final case class Empty[A]() extends  Maybe[A]


  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))
  assert(list.map(a=>{((a * 2) + 1 )/ 3}) ==  Pair(1, Pair(1, Pair(2, End()))) )
}
