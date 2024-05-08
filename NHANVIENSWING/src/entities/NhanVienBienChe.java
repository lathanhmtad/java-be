package entities;

import java.util.Date;

public class NhanVienBienChe extends NhanVien {
	private double heSoLuong;

	public NhanVienBienChe() {
	}

	public NhanVienBienChe(String id, String fullName, Date dob, String gender, String identityCard, Date ngayVaoCoQuan,
			double heSoLuong) {
		super(id, fullName, dob, gender, identityCard, ngayVaoCoQuan);
		this.heSoLuong = heSoLuong;
	}

	public NhanVienBienChe(String id, String fullName, String dob, String gender, String identityCard,
			String ngayVaoCoQuan, double heSoLuong) {
		super(id, fullName, dob, gender, identityCard, ngayVaoCoQuan);
		this.heSoLuong = heSoLuong;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public double tinhPhuCap() {
		int thamNien = tinhThamNien();
		if (thamNien >= 10) {
			return 0.1 * luongCB + 500000;
		}
		return 0.1 * luongCB + 200000;
	}

	@Override
	public double tinhThucLinh() {
		return heSoLuong * luongCB + tinhPhuCap();
	}
	
	

}
