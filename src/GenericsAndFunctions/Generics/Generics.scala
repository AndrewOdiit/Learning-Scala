package GenericsAndFunctions.Generics

import scala.annotation.tailrec

object Generics extends App {
  sealed trait  Result[A]
  final case class Failure[A](msg:String) extends Result[A]
  final case class Success[A](value:A) extends  Result[A]
  sealed trait GenericList[A] {
    def apply(nth:Int):Result[A] ={
      if (nth >= this.length()){
        Failure("Index out of bounds")
      }else{
        helper(nth, 0, this)
      }
    }

    @tailrec
    final def helper[A](nth:Int, pos:Int, current:GenericList[A]): Result[A] ={
      current match {
        case End() => Failure("Number not found ...")
        case Pair(head, tail) =>{
          if (nth == pos){
            Success(head)
          }else{
            helper(nth, pos+1,tail)
          }

        }
      }

    }
    def length[A](): Int ={
     this match {
       case End() => 0
       case Pair(_, tail) => 1 + tail.length()
   }
    }

    /*
  IMPLEMENT A CONTAINS METHOD...
   */
    def contains[A](value:A): Boolean ={
        this match {
          case End() => false
          case Pair(head, tail)=>{
            if (value == head){
              true
            }else{
              tail.contains(value)
            }
          }
        }
    }
  }
  final case class End[A]() extends  GenericList[A]
  final case class Pair[A](head:A, tail:GenericList[A]) extends GenericList[A]{

  }
  //implement length function
  val example = Pair(1, Pair(2, Pair(3, End())))
//  assert(example.length == 3)
//  assert(example.tail.length == 2)
//  assert(End().length == 0)
//  println("Tests passed...")


  assert(example.contains(3) == true)
  assert(example.contains(4) == false)
  assert(End().contains(0) == false)
  println("Contains test cases passed...")

  assert(example(0) == Success(1))
  assert(example(1) == Success(2))
  assert(example(2) == Success(3))
  assert(example(3) == Failure("Index out of bounds"))
  println("apply(nth) test cases passed...")

}
