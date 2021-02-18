package ObjectsAndClasses.Traits

object ShapingUp  extends  App {
  trait Shape {
    def sides:Double
    def perimeter:Double
    def area:Double
  }
  trait Rectangular extends Shape{
    def length:Double
    def width: Double

    override def area: Double = length * width

    override def perimeter: Double = (2 * length) + (2 * width)
  }

  case class Circle(radius:Float)extends Shape{
    override def sides: Double = 0

    override def perimeter: Double = 2 * (Math.PI * radius)

    override def area: Double = Math.PI * Math.pow(radius, 2)
  }

  case class Rectangle(length:Double, width:Double) extends  Rectangular {
    override def sides: Double = 4

    override def perimeter: Double = 2 * (length + width)

    override def area: Double = length * width
  }

  case class Square(sides:Double) extends Rectangular{
    val length = sides
    val width = sides
  }

  val circle = Circle(5)
  val rectangle=Rectangle(4, 5)
  val square =Square(3)
  println(s" Circle area ${circle.area} perimeter ${circle.perimeter}")
  println(s" Rectangle area ${rectangle.area} perimeter ${rectangle.perimeter}")
  println(s" Square area ${square.area} perimeter ${square.perimeter}")
}
