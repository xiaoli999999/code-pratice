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
		println(fileContent)
		println("ok, start to write file!")
		
		val writer = new FileWriter(new File(fileName+".txt"))
		writer.write(fileContent)
		writer.close()
		println("completed!")
		
	  }else{
		println("arguments are not justify!")
	  }
   }
}