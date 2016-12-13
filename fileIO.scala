import java.io._

object Demo {
   def strDecode(str:String): String = {
		var newStr: String = str.replace("\\n","\n")
		newStr = newStr.replace("\\t","\t")
		newStr
   }
   def main(args: Array[String]): Unit = {
	  println("args length: "+args.length)
	  
	  if(args.length>=2){ 
		val fileName: String = args.toList(0)
		val fileContent: String = strDecode(args.toList(1))
		println("ok, start to write file!")
		
		val writer = new FileWriter(new File(fileName+".txt"))
		writer.write(fileContent)
		writer.close()
		
		println("read from "+fileName+".txt")
		scala.io.Source.fromFile(fileName+".txt" ).foreach{ 
			print 
		}
		println()
		// use java.io.FileWriter
		val out = new java.io.FileWriter("./out.txt")
		out.write("hello world\n\n123")
		out.close()
		// use scala.io.Source
		scala.io.Source.fromFile(new java.io.File("out.txt")).getLines().foreach(println)
		
		println("\ncompleted!")
		
	  }else{
		println("arguments are not justify!")
	  }
   }
}