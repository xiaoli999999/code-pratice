object ImplicitDemo {
	def display(input: String): Unit = println(input)
	def display2(input: Int): Unit = println(input+1)
	implicit def typeConvertor(input:Int): String = input.toString
	implicit def typeConvertor(input: String): Int = input.toInt
	
	def main(args: Array[String]): Unit = {
		display("1212")
		display(12)
		
		//display2("22")
  }
}