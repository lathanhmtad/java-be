package business;

import java.util.Hashtable;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import data.SQLServerDataAccess;
import entities.NhanVien;
import entities.NhanVienBienChe;
import entities.NhanVienHopDong;
import presentation.GUINhanVien;

public class BusinessLogicNhanVien {
	private Hashtable<String, NhanVien> listStaff;
	private SQLServerDataAccess sqlServerDataAccess = new SQLServerDataAccess();
	private GUINhanVien frmNhanVien;

	public BusinessLogicNhanVien(GUINhanVien frmNhanVien) {
		this.frmNhanVien = frmNhanVien;
	}

	// hàm loadDataToTable() sẽ tải dữ liệu từ sql server và đưa nó vào trong view
	public void loadDataToTable() {

		// lấy dữ liệu từ cơ sở dữ liệu và lưu vào listStaff đã được khai báo ở trên
		listStaff = sqlServerDataAccess.list();

		// logic đưa dữ liệu vào bảng
		DefaultTableModel model = (DefaultTableModel) frmNhanVien.tblNhanVien.getModel();
		Set<String> keys = listStaff.keySet();
		for (String key : keys) {
			NhanVien nv = listStaff.get(key);
			if (nv instanceof NhanVienBienChe) {
				Object[] row = { nv.getId(), nv.getFullName(), nv.getGender(), nv.getDob(), nv.getCccd(),
						nv.getNgayVaoCoQuan(), "Biên chế", ((NhanVienBienChe) nv).getHeSoLuong(), 0 };
				model.addRow(row);
			} else if (nv instanceof NhanVienHopDong) {
				Object[] row = { nv.getId(), nv.getFullName(), nv.getGender(), nv.getDob(), nv.getCccd(),
						nv.getNgayVaoCoQuan(), "Hợp đồng", 0, ((NhanVienHopDong) nv).getMucLuong() };
				model.addRow(row);
			}
		}
	}

}
