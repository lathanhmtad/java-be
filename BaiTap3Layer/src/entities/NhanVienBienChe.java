package entities;

import java.util.Date;

public class NhanVienBienChe extends NhanVien {
	private double heSoLuong;

	public NhanVienBienChe(String id, String fullName, Date dob, String gender, String cccd, Date ngayVaoCoQuan,
			double heSoLuong) {
		super(id, fullName, dob, gender, cccd, ngayVaoCoQuan);
		this.heSoLuong = heSoLuong;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

}
