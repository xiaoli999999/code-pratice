import java.sql.*;
import java.io.*;

public class JDBCTest {
	public static void main(String[] args){
		
		try{
			//先加载jar文件sqljdbc4.jar
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//利用windows账号登陆，不指定账号密码
			String dbURL = "jdbc:sqlserver://0.0.0.0:1433;DatabaseName=test;integratedSecurity=true;";
			Connection con = DriverManager.getConnection(dbURL);
			System.out.println("数据库连接成功");
			
			
			Statement stmt = con.createStatement(); 
			String query = "select * from tb;";
			ResultSet rs = stmt.executeQuery(query); 
			System.out.println("搜索完成");
			
			
			
			while(rs.next()){
				System.out.println(rs.getString("id")+" "+rs.getString("name"));
			}
			con.close();
		}catch(Exception e){
			System.out.println("发生错误");
			StringWriter sw = new StringWriter();   
            PrintWriter pw = new PrintWriter(sw);   
            e.printStackTrace(pw);   

			System.out.println("\r\n");
			System.out.println(sw.toString());
			System.out.println("\r\n");
		}
		
	}
}