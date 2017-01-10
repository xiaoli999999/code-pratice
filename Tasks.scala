import java.util.Timer
import java.util.TimerTask

import scala.concurrent._

import java.net.URL 
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

object TimedEvent{
	val timer = new Timer
	var counter = 0
	var currentgrp: List[String] = List()
	def delayedSuccess[T](secs: Int, value: T): Future[String] = {
		val result = Promise[String]
		timer.schedule(new TimerTask() {
		  def run() = {
		    println(value.toString * 100)
			val html = Source.fromURL(new URL("http://baidu.com"))("UTF-8").mkString
			result.success(html)
			//counter = counter + 1
			//currentgrp = currentgrp ++ List(html)
			//var m = currentgrp.groupBy{e=>e}
			/*m.foreach {
				e=>
					println(e._1+"->"+e._2.size+"\n")
			}*/
		  }
		}, secs * 1000)
		result.future
	}
	
}



def task1(input: Int) = TimedEvent.delayedSuccess(1, input + 1)
println(Await.result({
	(1 to 5).foldLeft(Future successful List.empty[String]) { (k, t) =>
		k.flatMap { case v => task1(t).map(r => (r :: v)) }
	}
}, duration.Duration.Inf).toString)


