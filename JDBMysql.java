import java.sql.*;

public class JDBMysql {
	public static void main(String[] args) {
		
		try {
		
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://0.0.0.0:3306/test";
			
			String user = "root"; 
			String password = "root";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement statement = conn.createStatement();
			
			String sql = "select * from company";
			
			ResultSet rs = statement.executeQuery(sql);
			
			int id = 0;
			String name = "";
			while(rs.next()) {
		
				 // 选择sname这列数据
				 id = rs.getInt("id");
				 name = rs.getString("name");
				 // 输出结果
				 System.out.println(id+" "+name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}