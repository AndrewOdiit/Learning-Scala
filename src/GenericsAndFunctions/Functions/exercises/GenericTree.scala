package GenericsAndFunctions.Functions.exercises

object GenericTree extends App{
  sealed trait BTree[A] {
     //Make this work for both strings & integers, double should double whatever it find's there
//    def double():BTree[Int] ={
//      this match {
//        case Leaf(value:Int) => Leaf(value * 2)
//        case Node(left, right) => Node(left.double(), right.double())
//        case _ => throw new Exception("Something went wrong")
//      }
//
//    }


    /*
    override def toString: String = {
      //this demonstrates how fold would be used, but doesn't work.
      fold[String]((value:String)=>value, (left, right) => left + " " +  right)
    }
     */

    def printElements(): String ={
          this match {
            case Leaf(value) => value.toString
            case Node(left, right) => left.printElements() + " " + right.printElements()
          }
    }
    def fold[B](leaf: A => B)(node:(B, B)=>B):B ={
        this match {
          case Leaf(value) => leaf(value)
          case Node(left, right) => node(left.fold(leaf){node}, right.fold(leaf){node})
        }
    }



  }

  final case class Node[A](left:BTree[A], right:BTree[A]) extends  BTree[A]
  final case class Leaf[A](value:A) extends BTree[A]


  val tree = Node(Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

  println(tree.printElements())


}
