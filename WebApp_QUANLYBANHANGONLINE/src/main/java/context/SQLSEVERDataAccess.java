/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

/**
 *
 * @author AD
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSEVERDataAccess {

    Connection cnn;
    Statement stm;
    PreparedStatement ps;

    public SQLSEVERDataAccess() {
        try {
			String UserName = "sa";
			String PassWord = "Diyeph1@";
			String DriverURL= "jdbc:sqlserver://localhost:1433;DatabaseName=dbQUANLYNHANSU;encrypt=true;TrustServerCertificate=true;";
			cnn = DriverManager.getConnection(DriverURL, UserName, PassWord);
			 this.cnn=DriverManager.getConnection(DriverURL,UserName,PassWord);
			 System.out.println("Da ket noi");
			this.stm = this.cnn.createStatement();
        } catch (SQLException ex) {
        } catch (Exception e) {
        }
    }

    public ResultSet getResultSet(String SQL) {
        try {
            ResultSet rs;
            rs = this.stm.executeQuery(SQL);
            return rs;
        } catch (Exception ex) {
        }
        return null;
    }
   //SELECT * FROM TBLAOINHANVIEN WHERE  IDLOAINHANVIEN=?
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
}


