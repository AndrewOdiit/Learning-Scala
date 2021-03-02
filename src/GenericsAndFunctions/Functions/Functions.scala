package GenericsAndFunctions.Functions

object Functions extends App {
  sealed trait IntList {
    def length: Int =  fold[Int](0, (_, tl) => 1 + tl)
    def double: IntList = {
      fold[IntList](End,(hd, tl) => Pair(hd * 2, tl))
    }

    def product: Int =  fold[Int](1, (hd, tl) => hd * tl)
    def sum: Int = fold[Int](0, (hd, tl) => (hd + tl))

    def fold[A](n: A, fn:(Int, A)=>A): A ={
      this match {
        case End =>n
        case Pair(hd, tl) => fn(hd, tl.fold(n, fn))
      }
    }
  }


  case object End extends IntList
  case class Pair(hd: Int, tl: IntList) extends IntList


  val example = Pair(1, Pair(2, Pair(3, End)))
  assert(example.length == 3)
  assert(example.product == 6)
  assert(example.double == Pair(2, Pair(4, Pair(6, End))))
  println("Skeleton is fine...")
}
