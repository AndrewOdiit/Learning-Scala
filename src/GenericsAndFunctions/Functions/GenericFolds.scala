package GenericsAndFunctions.Functions

object GenericFolds {

  sealed trait LinkedList[A]{
    //this style helps with type inference.
    def fold[B](end:B)(pair:(A, B)=>B):B={
         this match {
           case End() => end
           case Pair(hd, tail) => pair(hd, tail.fold(end){pair})
         }
    }
  }
  case class End[A]() extends LinkedList[A]
  case class Pair[A](hd: A, tl: LinkedList[A]) extends LinkedList[A]

}
