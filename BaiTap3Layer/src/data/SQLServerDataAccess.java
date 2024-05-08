package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Hashtable;

import entities.NhanVien;
import entities.NhanVienBienChe;
import entities.NhanVienHopDong;

public class SQLServerDataAccess {
	private Connection conn = null;

	String sqlFind = " select * from tblEmployee where id=?";

	String sqlInsert = "insert into tblEmployee VALUES(?,?,?,?,?,?,?,?)";

	String sqlUpdate = "update tblEmployee set full_name=?, dob=?, gender=?, cccd=?, ngay_vao_co_quan=?, id_type=?, he_so_luong=?, muc_luong=?";

	String sqlDelete = " delete from tblEmployee where id=?";

	String sqlSelect = " select * from tblEmployee";

	public int insert(NhanVien nv) {
		return 0;
	}

	public int delete(NhanVien nv) {
		return 0;
	}

	public int update(NhanVien nv) {
		return 0;
	}

	public NhanVien find(String id) {
		return null;
	}

	public Hashtable<String, NhanVien> list() {
		Hashtable<String, NhanVien> listStaff = new Hashtable<>();

		// open connection to database
		conn = SQLServerConnection.getConnection();

		// create PreparedStatement object execute SQL statements against a database.
		PreparedStatement ps = null;

		// create ResultSet object get results from query execution
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sqlSelect);
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = String.valueOf(rs.getInt(1));
				String fullName = String.valueOf(rs.getString(2));
				Date dob = rs.getDate(3);
				String gender = rs.getString(4);
				String identityCard = rs.getString(5);
				Date ngayVaoCoQuan = rs.getDate(6);
				int typeEmployee = rs.getInt(7);
				double heSoLuong = rs.getDouble(8);
				double mucLuong = rs.getDouble(9);

				NhanVien nv = null;
				if (typeEmployee == 1) { // Nhân viên biên chế
					nv = new NhanVienBienChe(id, fullName, dob, gender, identityCard, ngayVaoCoQuan, heSoLuong);
				} else if (typeEmployee == 2) { // Nhân viên hợp đồng
					nv = new NhanVienHopDong(id, fullName, dob, gender, identityCard, ngayVaoCoQuan, mucLuong);
					listStaff.put(id, nv);
				}
				listStaff.put(id, nv);
			}
			ps.close();
			rs.close();
			return listStaff;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}
		
		System.out.println(123);
		return null;
	}
}
