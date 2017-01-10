import scala.io._
object Map {
	def main(args: Array[String]): Unit = {
		var num = 0
		var m = Map()
		for( line <- Source.fromFile("222.txt").getLines)
			m += Map(num->line)
		println(m(0))
	}
}