
package context;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
     public Connection getConnection()throws Exception {
    	 String UserName = "sa";
			String PassWord = "Diyeph1@";
			String DriverURL= "jdbc:sqlserver://DESKTOP-AD9RIDV\\SQLEXPRESS:1433;DatabaseName=dbQUANLYBANHANG;encrypt=true;TrustServerCertificate=true;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(DriverURL, UserName, PassWord);
    }   
    public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 