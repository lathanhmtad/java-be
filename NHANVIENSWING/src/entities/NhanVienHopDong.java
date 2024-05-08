package entities;

import java.util.Date;

public class NhanVienHopDong extends NhanVien {
	private double mucLuong;

	public NhanVienHopDong() {
		super();
	}

	public NhanVienHopDong(String id, String fullName, Date ngayVaoCoQuan, String gender, String identityCard, Date dob,
			double mucLuong) {
		super(id, fullName, ngayVaoCoQuan, gender, identityCard, dob);
		this.mucLuong = mucLuong;
	}

	public NhanVienHopDong(String id, String fullName, String ngayVaoCoQuan, String gender, String identityCard,
			String dob, double mucLuong) {
		super(id, fullName, ngayVaoCoQuan, gender, identityCard, dob);
		this.mucLuong = mucLuong;
	}

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}

	@Override
	public double tinhPhuCap() {
		int thamNien = tinhThamNien();
		if (thamNien >= 2) {
			return 0.1 * mucLuong + 200000;
		}
		return 0.1 * mucLuong + 100000;
	}

	@Override
	public double tinhThucLinh() {
		return luongCB + mucLuong + tinhPhuCap();
	}

	@Override
	public String toString() {
		return "NhanVienHopDong [mucLuong=" + mucLuong + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getNgayVaoCoQuan()=" + getNgayVaoCoQuan() + ", getGender()=" + getGender() + ", getIdentityCard()="
				+ getIdentityCard() + ", getDob()=" + getDob() + "]";
	}

}
