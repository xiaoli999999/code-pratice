import java.sql.DriverManager
import java.sql.Connection
/**
  * Created by Administrator on 2016-12-9.
  */
object JDBCTest {
  def main(args: Array[String]) {
    // connect to the database named "mysql" on the localhost
    val driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    //val driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    val url = "jdbc:sqlserver://0.0.0.0:1433;DatabaseName=test;integratedSecurity=true;"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      println("class ok")
      connection = DriverManager.getConnection(url)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM tb;")
      while ( resultSet.next() ) {
        val id = resultSet.getString("id")
        val name = resultSet.getString("name")
        println(id+" "+name)
      }
      connection.close()
    } catch {
      case e:Any =>  e.printStackTrace
    }

  }
}
