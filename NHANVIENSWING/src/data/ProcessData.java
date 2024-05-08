package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import entities.NhanVien;
import entities.NhanVienBienChe;
import entities.NhanVienHopDong;

public class ProcessData {
	private Connection conn = null;

	String sqlFind = " select * from tblEmployee where id=?";

	String sqlInsert = "insert into tblEmployee VALUES(?,?,?,?,?,?,?,?)";

	String sqlUpdate = "update tblEmployee set full_name=?, dob=?, gender=?, cccd=?, ngay_vao_co_quan=?, id_type=?, he_so_luong=?, muc_luong=?";

	String sqlDelete = " delete from tblEmployee where id=?";

	String sqlSelect = " select * from tblEmployee";

	public int insert(NhanVien nv) {
		int res = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sqlInsert);
			ps.setString(1, nv.getFullName());

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date dob = null;
			java.sql.Date ngayVaoCoQuan = null;
			try {
				dob = new java.sql.Date(format.parse(nv.getDob()).getTime());
				ngayVaoCoQuan = new java.sql.Date(format.parse(nv.getNgayVaoCoQuan()).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ps.setDate(2, dob);
			ps.setString(3, nv.getGender());
			ps.setDate(4, ngayVaoCoQuan);

			if (nv instanceof NhanVienBienChe) {
				ps.setInt(5, 1);
				ps.setDouble(6, ((NhanVienBienChe) nv).getHeSoLuong());
			} else if (nv instanceof NhanVienHopDong) {
				ps.setInt(5, 2);
				ps.setDouble(6, ((NhanVienHopDong) nv).getMucLuong());
			}

			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}
		return res;
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

		return null;
	}
}
