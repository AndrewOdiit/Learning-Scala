package ObjectsAndClasses.recursion

import scala.annotation.tailrec

object RecursiveData extends App {
  sealed trait IntList {
    def length(): Int ={
      @tailrec
      def helper(myList:IntList, l:Int):Int={
        myList match {
          case End => l
          case Pair(_, tail) => helper(tail,l+1)
        }
      }
      helper(this, 0)
    }

    def product():Int={
      def mul(myList:IntList, acc:Int):Int={
        myList match {
          case End => acc
          case Pair(head, tail) =>mul(tail, acc * head)
        }
      }
      mul(this, 1)

    }
  }
  case object End extends IntList
  final case class Pair(head:Int, tail:IntList) extends IntList{

  }



  val linkedList = Pair(1,Pair(2, Pair(3, Pair(4, Pair(5,End)))))
  val example = Pair(1, Pair(2, Pair(3, End)))
  println(linkedList.length)
  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)

  assert(example.product == 6)
  assert(example.tail.product == 6)
  assert(End.product == 1)
  println("All tests passed...")
}
