/******
*
*第一个object要怎么写才能让结果等于23？
*
*******/
class A(s: String){def ddd()={println(s)}}
object ImplicitDemo {

	def display(input:String):Unit = println(input)
	implicit def typeConvertor(input:Int): String = input.toString
	implicit def typeConvertor(input:Boolean):String = if(input==true) "T" else "F"
	
	def display2(input:Int):Unit = println(input+1)
	implicit def typeConvertor2(input:String) = input.toInt
	
	def main(args: Array[String]): Unit = {
		display(12)
		display(true)
		display2(1)
		display2(typeConvertor2("1"))
		val a = new A("asd")
		println("基数输出 ")
		List(1, 2, 3, 4, 5, 6, 7).foreach(e => if(e%2!=0) println(e))
  }
}
/***********
* error: type mismatch;
* found   : input.type (with underlying type String)
* required: ?{def toInt: ?}
* Note that implicit conversions are not applicable because they are ambiguous:
* both method augmentString in object Predef of type (x: String)scala.collection.immutable.StringOps
* and method typeConvertor in object Main of type (input: String)Int
* are possible conversion functions from input.type to ?{def toInt: ?}
*        implicit def typeConvertor(input: String): Int = input.toInt
*                                                         ^
* error: value toInt is not a member of String
*        implicit def typeConvertor(input: String): Int = input.toInt
*                                                               ^
* two errors found
********/
