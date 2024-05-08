package entities;

import java.util.Date;

public class NhanVienHopDong extends NhanVien {
	private double mucLuong;

	public NhanVienHopDong(String id, String fullName, Date dob, String gender, String cccd, Date ngayVaoCoQuan,
			double mucLuong) {
		super(id, fullName, dob, gender, cccd, ngayVaoCoQuan);
		this.mucLuong = mucLuong;
	}

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}

}
