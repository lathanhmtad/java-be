package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLServerConnection {
	
	private static Connection conn = null;
	
	public static Connection getConnection()
	{
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=News;encrypt=true;trustServerCertificate=true";
			String username = "NDD";
			String password = "123";
			
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection c) {
		try
		{
			if(c != null) {
				c.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
