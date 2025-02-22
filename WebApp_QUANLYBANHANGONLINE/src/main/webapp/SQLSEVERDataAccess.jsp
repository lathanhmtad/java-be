<%@ page import ="java.sql.CallableStatement "%>
<%@ page import= "java.sql.Connection "%>
<%@ page import= "java.sql.DriverManager" %>
<%@ page import= "java.sql.PreparedStatement" %>
<%@ page import= "java.sql.ResultSet" %>
<%@ page import= "java.sql.SQLException" %>
<%@ page import= "java.sql.Statement" %>
<%! 
public class SQLSEVERDataAccess {

    Connection cnn;
    Statement stm;
    PreparedStatement preparedStatement;

    public SQLSEVERDataAccess() {
    	try {
    	    // Đăng ký driver SQL Server
    	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	} catch (ClassNotFoundException e) {
    	    e.printStackTrace();
    	}
				String UserName = "NDD";
				String PassWord = "1234";
				String DriverURL= "jdbc:sqlserver://localhost:1433;DatabaseName=dbQUANLYBANHANG;encrypt=true;TrustServerCertificate=true;";
			try{
			cnn = DriverManager.getConnection(DriverURL, UserName, PassWord);
			stm=cnn.createStatement();
			}
			catch(Exception e){
				e.printStackTrace();
			} 
    }
    public ResultSet getResultSet(String SQL) {
        try {
            ResultSet rs;
            rs = this.stm.executeQuery(SQL);
            return rs;
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    }
    //SELECT * FROM TBLAOITINTUC WHERE  IDLOAITINTUC=?
        public ResultSet getResultSet(String SQL, Object[] param) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareStatement(SQL);
            int i = 1;
            for (Object value : param) {
                ps.setObject(i, value);
                i++;
            }
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //SQL (DELETE, UPDATE, INSERT)
        //INSERT INTO TBLOAINHANVIEN(IDLOAINHANVIEN,TENLOAINHANVIEN) VALUES(1,'NHAN VIEN BIEN CHE')
    public int ExecuteSQL(String SQL) {
        try {
            int k = 0;
            k = this.stm.executeUpdate(SQL);
            return k;
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return 0;
    }
    //INSERT INTO TBLOAINHANVIEN(IDLOAINHANVIEN,TENLOAINHANVIEN) VALUES(?,?)
    public int ExecuteSQL(String SQL, Object[] param) {
        try {
            int k = 0;
            PreparedStatement ps = this.cnn.prepareStatement(SQL);
            int i = 1;
            for (Object value : param) {
                ps.setObject(i, value);
                i++;
            }
            k = ps.executeUpdate();
            ps.close();
            return k;
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return 0;
    }

    public int Execute_StoredProcedures(String NameStoredProcedures, Object[] param) {
        try {
            int k = 0;
            CallableStatement  ps = this.cnn.prepareCall("{call "+NameStoredProcedures+"}");
            int i = 1;
            for (Object value : param) {     
                ps.setObject(i, value);
                i++;
            }
            k = ps.executeUpdate();
            ps.close();
            return k;
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return 0;
    }
    public ResultSet getResultSet_StoredProcedures(String NameStoredProcedures, Object[] param) {
        ResultSet rs = null;
        CallableStatement ps = null;
        try {
            ps = cnn.prepareCall("{call "+NameStoredProcedures+"}");
            if(param!=null)
            {
            int i = 1;
            for (Object value : param) {
                ps.setObject(i, value);
                i++;
            }
            }
            rs = ps.executeQuery();
            ps.close();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void testConnection(JspWriter out) {
        try {
            if (cnn != null) {
                out.println("Connection successsadful");
            } else {
                out.println("Connection failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

}

%>
