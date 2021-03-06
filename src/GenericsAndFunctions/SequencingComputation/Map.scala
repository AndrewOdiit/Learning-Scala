package GenericsAndFunctions.SequencingComputation

object Map extends App {
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
}
