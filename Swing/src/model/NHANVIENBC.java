package model;

import java.util.Date;

public class NHANVIENBC extends NHANVIEN {
	private double Hesoluong;

	public double getHesoluong() {
		return Hesoluong;
	}

	@Override
	public double tinhPhuCap() {
		if (super.tinhThamnien() > 10)
			return (Luongcoban * 0.1 + 500000);
		else
			return (Luongcoban * 0.1 + 200000);
	}

	@Override
	public double tinhThucLinh() {
		return (this.Hesoluong * Luongcoban + this.tinhPhuCap());
	}

	public NHANVIENBC() {
		super();
	}

	public NHANVIENBC(String manv, String hoten, String gioitinh, Date ngaysinh, long soCM, Date ngayvaocoquan,
			double hesoluong) {
		super(manv, hoten, gioitinh, ngaysinh, soCM, ngayvaocoquan);
		Hesoluong = hesoluong;
	}
}