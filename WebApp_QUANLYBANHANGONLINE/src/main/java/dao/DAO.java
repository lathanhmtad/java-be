package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.SANPHAM;
import context.DBContext;


public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public SANPHAM getProductByID(String pid) {
        String query = "select * from tbSANPHAM where MASANPHAM = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new SANPHAM(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                		rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public static void main(String[] args) {
		DAO dao = new DAO();
		SANPHAM sp= dao.getProductByID("1");
		System.out.println(sp);
	}
}