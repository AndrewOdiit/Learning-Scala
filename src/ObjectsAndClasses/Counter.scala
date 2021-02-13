package ObjectsAndClasses

object Counter extends App {
   class SimpleCounter(val num:Int){
     def inc:SimpleCounter = inc()
     def dec:SimpleCounter = dec()
     def inc(by:Int=1)={
          new SimpleCounter(this.num + by)
      }

     def dec(by:Int=1)={
        new SimpleCounter(this.num - by)
     }

     def adjust(adder:Adder):SimpleCounter={
       new SimpleCounter(num=adder(this.num))
     }
   }

  class Adder(amount: Int){
    //this will be called everytime an adder instance is called.
    def apply(in: Int): Int = in + amount
  }

  val counter:SimpleCounter = new SimpleCounter(0);
  println(counter.inc.dec(2).inc(10).num) //--9?
  val adder = new Adder(amount = 5)
  println(new SimpleCounter(10).inc.dec.inc.inc.adjust(adder).num) //--12 ?

}
