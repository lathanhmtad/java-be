package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class SQLServerConnection {
	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String user = "NDD";
			String password = "123";
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DBEmployee;encrypt=true;trustServerCertificate=true";

			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
