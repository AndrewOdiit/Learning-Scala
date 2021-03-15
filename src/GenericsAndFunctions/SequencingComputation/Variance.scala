package GenericsAndFunctions.SequencingComputation

/*
from book
We
should only use covariant types where the container type is immutable. If the
container allows muta on we should only use invariant types.

??? --> is a subtype an immutable container type ? --> Non Generic type is immutable see page 155
 */
object Variance extends App {
  sealed trait Maybe[+A]
  final case class Full[A](value: A) extends Maybe[A]
  case object Empty extends Maybe[Nothing]
  //nothing is a subtype of all types in scala

  val perhaps: Maybe[Int] = Empty

}
