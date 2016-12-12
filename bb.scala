import java.io._
import scala.io.Source

object Test {
	val multiplier = (i:Int) => i * i
	
	def matchTest(x:Any): String = x match {
		case 1 => "one"
		case 2 => "two"
		case _ => "many"
	}
	
	def writeFile(fileName:String,Content:String) = {
		val writer = new PrintWriter(new File(fileName+".txt"))
		writer.write(Content)
		writer.close()
	}
	
	def readFile(fileName:  String) = {
		Source.fromFile("test.txt" ).foreach{ 
        print 
      }
	}
	
	def main(args: Array[String]) {
		println(multiplier(3))
		println(matchTest(1))
		println(matchTest(2))
		println(matchTest(3333))
		writeFile("test","asd\nasd\nasd\n")
		readFile("test.txt")
	}
}