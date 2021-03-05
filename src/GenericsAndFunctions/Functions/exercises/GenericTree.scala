package GenericsAndFunctions.Functions.exercises

object GenericTree extends App{
  sealed trait BTree[A] {
    def double():BTree[Int] ={
      this match {
        case Leaf(value:Int) => Leaf(value * 2)
        case Node(left, right) => Node(left.double(), right.double())
        case _ => throw new Exception("Something went wrong")
      }

    }

//    def fold_and_double():BTree[Int]{
//       fold
//    }
    //review this in the morning...try and use or adapt for double method.
    def fold[B](leaf: A => B)(node:(B, B)=>B):B ={ //not too bad , just some issues with types leaf takes A (values) --> B leaf(value)
        this match {
          case Leaf(value) => leaf(value)
          case Node(left, right) => node(left.fold(leaf){node}, right.fold(leaf){node})
        }
    }


  }

  final case class Node[A](left:BTree[A], right:BTree[A]) extends  BTree[A]
  final case class Leaf[A](value:A) extends BTree[A]


  val example = Node


}
