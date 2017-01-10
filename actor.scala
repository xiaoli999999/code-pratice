import java.net.{URL, URLEncoder} 
import scala.io.Source

object React {
	def main(args: Array[String]) = {
		var counter:Int = 0
		var txtgrp: List[String] = List()
		while(counter<5){
			Thread.sleep(50)
			println("event start")
			val html = Source.fromURL(new URL("http://baidu.com"))
			val s = html.mkString
			println(s)
			txtgrp = txtgrp ++ List(s)
			counter = counter + 1
		}
		
		
		var i = 0
		txtgrp.foreach(
			html=>
				println(html)
		)
		
		println(txtgrp)
	}
}