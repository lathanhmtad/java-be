package entities;

import java.util.Date;

public abstract class NhanVien {
	private String id;
	private String fullName;
	private Date dob;
	private String gender;
	private String cccd;
	private Date ngayVaoCoQuan;

	public NhanVien() {
	}

	public NhanVien(String id, String fullName, Date dob, String gender, String cccd, Date ngayVaoCoQuan) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.cccd = cccd;
		this.ngayVaoCoQuan = ngayVaoCoQuan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public Date getNgayVaoCoQuan() {
		return ngayVaoCoQuan;
	}

	public void setNgayVaoCoQuan(Date ngayVaoCoQuan) {
		this.ngayVaoCoQuan = ngayVaoCoQuan;
	}

	@Override
	public String toString() {
		return "NHANVIEN [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", gender=" + gender + ", cccd="
				+ cccd + ", ngayVaoCoQuan=" + ngayVaoCoQuan + "]";
	}

	public int tinhThamNien() {
		return 0;
	}
}
