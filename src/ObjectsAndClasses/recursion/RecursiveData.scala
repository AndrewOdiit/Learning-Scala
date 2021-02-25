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
  final case class Pair(head:Int, tail:IntList) extends IntList


  //structural recursion using pattern matching.
  sealed trait RecursiveTree {
    def sum(): Int ={
      this match {
        case Leaf(value) => value
        case Node(left, right) => left.sum + right.sum
      }
    }

    def double(): RecursiveTree ={
      this match {
        case Leaf(value) => Leaf(value*2)
        case Node(left, right) => Node(left.double, right.double)
      }
    }


  }

  case class Node(left:RecursiveTree, right:RecursiveTree) extends RecursiveTree {

  }

  case class Leaf(value:Int) extends RecursiveTree {

  }

  sealed trait Btree{
    def sum(): Int
    def double(): Btree
  }

  final case class PNode(l:Btree, r: Btree) extends Btree{
    override def sum(): Int = l.sum + r.sum

    override def double(): Btree = PNode(l.double(), r.double())
  }

  final case class Pleaf(value:Int) extends  Btree{
    override def sum(): Int = value

    override def double(): Btree = Pleaf(value * 2)
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
//  val bTree = Node(Leaf(1), Leaf(2))
//  val bTree2 = Node(Leaf(4), Leaf(5))
  val PTree = PNode(Pleaf(1), Pleaf(2))
  val PTree2 = PNode(Pleaf(4), Pleaf(5))
  val PTree3 = PNode(PNode(Pleaf(10), Pleaf(10)), PNode(Pleaf(10), Pleaf(10))) //49 + 64 --
//  assert(bTree.double() == Node(Leaf(2), Leaf(4)))
//  assert(bTree2.double() == Node(Leaf(8), Leaf(10)))
  assert(PTree.double() == PNode(Pleaf(2), Pleaf(4)))
  assert(PTree2.double() == PNode(Pleaf(8), Pleaf(10)))
  assert(PTree3.double() == PNode(PNode(Pleaf(20), Pleaf(20)), PNode(Pleaf(20), Pleaf(20))))


  println("All tests passed...")

}
