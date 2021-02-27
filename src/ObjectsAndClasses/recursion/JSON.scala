package ObjectsAndClasses.recursion

object JSON extends App{

  //This is not finished , maybe i'll come back to it. lol.
  //this is kind of a mess, but it works, ...i'll get better at this with time.
  sealed trait JSON {
    def print():String={
      this match {
        case SeqCell(_,_) => "[" + this.printElements() + "]"
        case ObjectCell(_,_) => this.printElements()
      }
    }
    def printElements(): String ={
      this match {
        case StringValue(string)  => this.print()
        case BooleanValue(boolean) => boolean.toString
        case NumberValue(numberValue) => numberValue.toString
        case SeqCell(head, tail) => {
          tail match {
            case SeqEnd => head.print()
            case  _ => head.printElements() + "," + tail.printElements()
          }
        }

          //overly simplified , cannot handle recursive cases.
        case ObjectCell(key, value) => "{" + key +  ":" + value.print() + "}"
      }
    }
  }

  sealed trait SequenceType extends  JSON {
  }


  final case class ObjectCell(key:String, value:JSON) extends  JSON {
  }

  final case object ObjectEnd extends  JSON
  final case class SeqCell(head:JSON, tail:SequenceType) extends SequenceType
  final case object SeqEnd  extends SequenceType
  final case class StringValue(string:String) extends  JSON{
    override def print(): String = {
      """"""" + string + """""""
    }
  }
  final case class BooleanValue(boolean: Boolean) extends JSON{
    override def print(): String = boolean.toString
  }
  final case class NumberValue(numberValue: Double) extends  JSON{
    override def print(): String = numberValue.toString
  }


  println(SeqCell(StringValue("a string"),SeqCell(NumberValue(1.0),SeqCell(BooleanValue(true),SeqEnd))).print)
  println(ObjectCell("a",SeqCell(StringValue("a string"),SeqCell(NumberValue(1.0),SeqCell(BooleanValue(true),SeqEnd)))).print())
}
