package ObjectsAndClasses.Traits

//YIKES THIS ONE WAS A BIG FAIL , BETTER LUCK NEXT TIME.
//THIS CODE IS EXCESSIVELY OVER ENGINEERED
object SealedTraits extends App{

  sealed trait Shape {
    def sides: Double

    def perimeter: Double

    def area: Double

    def shapeColor: Color

    def describe:String

    def getColor(): String={
      shapeColor.name match {
        case "Yellow" => shapeColor.name
        case "Pink" => shapeColor.name
        case "Red" => shapeColor.name
          //need to add case for dark or light color
        case _ => ColorType.shade(shapeColor)
      }
    }
  }

//  def getColourShade(color: Color)

  /*
  THIS SHOULD BE DEFINED AS PART OF THE TRAIT COLOR
   */
  object ColorType{
    //tells if color is dark or light
    def shade(color:Color): String={
      color match {
        case CustomColor("0", "0",_,_) => "dark"
        case CustomColor(_,"0","0",_) => "dark"
        case CustomColor("0",_,"0",_) => "dark"
        case _ => "light"
      }
    }
  }
  sealed trait Color{
    def r:String ="red"
    def g:String = "green"
    def b:String = "blue"
    def name:String
  }

  final case class Yellow() extends  Color{
    override def name: String = "Yellow"

    def apply(): String ={
      name
    }
  }

  final case class Red() extends  Color{
    val name: String = "Red"

    def apply(): String ={
      name
    }
  }

  final case class Pink() extends  Color{
    val name: String = "Pink"

    def apply(): String ={
      name
    }
  }

  //factory function that produces either a default Color or Custom color
  def ColorFactory(name:String="", r:String="" ,b:String="", g:String=""):Color={
       name match{
         case "Yellow" => Yellow()
         case "Red" => Red()
         case "Pink" => Pink()
         case _ => CustomColor(r,b,g,name)
       }
  }


  final case class defaultColor(name:String){

  }
  final case class CustomColor(override val r:String, override val g:String,
                                override val b:String, name:String) extends Color{
    def apply(): String ={
      s"$name  with hex code $r, $g, $b"
    }
  }



  object Draw{
    def apply(shape:Shape):String={
      shape match {
        case Rectangle(_,_,_) => shape.describe
        case Circle(_,_) => shape.describe
        case Square(_,_) => shape.describe
      }
    }
  }
  sealed trait Rectangular extends Shape{
    def length:Double
    def width: Double

    override def area: Double = length * width

    override def perimeter: Double = (2 * length) + (2 * width)

  }

  final case class Circle(radius:Float, shapeColor:Color) extends Shape{
    override def sides: Double = 0

    override def perimeter: Double = 2 * (Math.PI * radius)

    override def area: Double = Math.PI * Math.pow(radius, 2)

    override def describe: String = s"A ${getColor()} Circle with a radius of ${radius}"
  }

  final case class Rectangle(length:Double, width:Double, shapeColor:Color) extends  Rectangular {
    override def sides: Double = 4

    override def perimeter: Double = 2 * (length + width)

    override def area: Double = length * width
    val color = shapeColor

    override def describe: String = {
      s"A ${getColor()}  Rectangle with a lenght of $length and width of $width"
    }

  }

  final case class Square(sides:Double, shapeColor:Color) extends Rectangular{
    val length: Double = sides
    val width: Double = sides

    override def describe: String = s"A ${getColor()}  Square with sides of length $sides"
  }


  val circle = Circle(10, ColorFactory("Dark Blue", r="65536" ,b="256", g="255"))
  val blackCircle = Circle(15, ColorFactory("Black", r="0" ,b="0", g="0"))
  val rectangle = Rectangle(4, 3, ColorFactory("Yellow"))
  val square = Square(9, ColorFactory("Pink"))

  println(Draw(circle))
  println(Draw(rectangle))
  println(Draw(square))
  println(Draw(blackCircle))
}
