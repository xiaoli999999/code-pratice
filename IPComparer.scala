import scala.io._
import java.io._

object Test {
   def main(args: Array[String]) {
      if(args.length!=2){
		println("args error!")
		return
	  }
      println("Following is the content read:")
	  
	  var s1 = Set[String]() // the small one
	  var s2 = Set[String]() // the big one
	  
      for( line <- Source.fromFile(args(0)).getLines)
			s1 += line
	  for( line <- Source.fromFile(args(1)).getLines)
			s2 += line
	  val s3 = s2&~s1
	  
	  val writer = new PrintWriter(new File("result.txt" ))
		
	  s3.foreach{
		e => 
			writer.write(e+" \n")
	  }
	  writer.close()
   }
}