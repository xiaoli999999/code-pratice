import java.util.{Date, Timer, TimerTask}

import scala.concurrent._
import java.net.URL

import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global
import java.io._

case class RequestInfo(body: String, warste: Long)

object ConnectTest extends App {

	try {
	  //var currentgrp: List[String] = List()
		//var average_time: List[Double] = List()
		val writer = new PrintWriter(new File("./result.txt"))

	def delayedSuccess[T](secs: Int, value: Int): Future[Future[RequestInfo]] = {
		val timer = new Timer
		val result = Promise[Future[RequestInfo]]

		timer.schedule(new TimerTask() {
			def run() = {
				//println(value.toString * 100)
				//val t0 = System.nanoTime : Double

				val html = Future {
					val t1 = new Date()
					val body = Source.fromURL(new URL("http://19.125.100.4:9000/66?isDebug=true"), "UTF-8").getLines().mkString("\n")
					val t2 = new Date()
					RequestInfo(body, t2.getTime - t1.getTime)
				}
				result.success(html)

				//val t1 = System.nanoTime : Double
				//average_time = average_time ++ List((t1 - t0) / 1000000.0 )

				//println("Elapsed time " + (t1 - t0) / 1000000.0 + " msecs")
				timer.cancel()
				//counter = counter + 1
				//currentgrp = currentgrp ++ List(html)
				//var m = currentgrp.groupBy{e=>e}
				/*m.foreach {
          e=>
            println(e._1+"->"+e._2.size+"\n")
        }*/
			}
		}, secs * 0)
		result.future
	}


	def task1(input: Int) = delayedSuccess(1, input + 1)

	Await.result({
		val t3 = new Date()

		(1 to 400).foldLeft(Future successful List.empty[Future[RequestInfo]]) { (k, t) =>
			for {
				task <- task1(t)
				each <- k
			} yield {
				task :: each
			}
		}.map { listFuture  =>
			Future.sequence(listFuture).map { s =>
				val t4 = new Date()

				val map = s.groupBy(e => e.body)
				map.foreach{
					e=>
						val value:String = e._1 + "->" + e._2.size
						println(value)
				}
				println(s"time: ${ t4.getTime - t3.getTime }")

				val timeList = s.map(_.warste)
				var average_time_res = timeList.sum
				var average_time_counter = average_time_res / timeList.size

				average_time_res = average_time_res / average_time_counter
				println(s"平均时间为: $average_time_res msecs\r\n")


				timeList.foreach{ e =>
					writer.write("Elapsed time "+e+" msecs\r\n")
				}
				writer.write(s"\n平均时间为: $average_time_counter msecs")

				val resMap = s.map(_.body).groupBy(e=>e)
				var File_counter = 0
				resMap.foreach { e=>
					File_counter = File_counter + 1
					val writer2 = new PrintWriter(new File("./"+File_counter+".txt"))
					writer2.write(e._2.size+"\r\n")
					writer2.write(e._1+"\n")
					writer2.close()
				}

				writer.close()
			}
		}
	}.flatMap(identity), duration.Duration.Inf)

	} catch {
		case e: Exception => e.printStackTrace()
	}

}