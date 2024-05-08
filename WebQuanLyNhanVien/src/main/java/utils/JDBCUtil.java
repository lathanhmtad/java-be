package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mysql://localhost:3306/employees";
			String user = "root";
			String pass = "1234";
			conn = DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
