package ObjectsAndClasses.recursion

object Calculator extends  App {
  sealed trait Expression {
    //not tail recursive
    def eval(): Calculation = {
      //Subtraction
        this match {
          case Subtraction(left, right) =>
            left.eval() match {
              case Failure(msg) => Failure(msg)
              case Success(leftResult) =>
                right.eval() match {
                  case Failure(msg) => Failure(msg)
                  case Success(rightResult) => Success(leftResult - rightResult)
                }

            }

          case Addition(left, right) =>
            left.eval() match {
              case Failure(msg) => Failure(msg)
              case Success(leftResult) =>
                right.eval() match {
                  case Failure(msg) => Failure(msg)
                  case Success(rightResult) => Success(leftResult + rightResult)
                }

            }

          case Division(left, right)=>
            left.eval() match {
              case Failure(msg) =>Failure(msg)
              case Success(leftResult) =>
                right.eval() match {
                  case Failure(msg) => Failure(msg)
                  case Success(rightResult) =>
                    if(rightResult <= 0){
                      Failure("Division by zero")
                    }else{
                      Success(leftResult / rightResult)
                    }
                }
            }

          case SquareRoot(expression) =>{
                expression.eval() match {
                  case Failure(msg) => Failure(msg)
                  case Success(expression) =>
                    if(expression < 1){
                      Failure("Math domain error")
                    }else{
                      Success(math.sqrt(expression))
                    }
                }

          }

          case Number(value:Double) => Success(value)
        }
    }

  }

  final case class Addition(left:Expression, right:Expression) extends Expression
  final case class Subtraction(left:Expression, right:Expression) extends Expression

  final case class Division(left:Expression, right:Expression) extends Expression {
  }

  final case class SquareRoot(expression:Expression) extends Expression {
  }
  final case class Number(value:Double) extends Expression {
  }

  sealed trait Calculation
  final case class Failure(msg: String) extends Calculation
  final case class Success(mgs:Double) extends Calculation



  assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval == Failure("Math domain error"))
  assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
  assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
}
