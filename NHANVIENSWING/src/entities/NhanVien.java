package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class NhanVien implements INHANVIEN {
	private String id;
	private String fullName;
	private Date dob;
	private String gender;
	private String identityCard;
	private Date ngayVaoCoQuan;

	public NhanVien(String id, String fullName, String dob, String gender, String identityCard, String ngayVaoCoQuan) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = convert(dob);
		this.gender = gender;
		this.identityCard = identityCard;
		this.ngayVaoCoQuan = convert(ngayVaoCoQuan);
	}

	public String getNgayVaoCoQuan() {
		return convert(ngayVaoCoQuan);
	}

	public void setNgayVaoCoQuan(String ngayVaoCoQuan) {
		this.ngayVaoCoQuan = convert(ngayVaoCoQuan);
	}

	public String getDob() {
		return convert(dob);
	}

	public void setDob(String dob) {
		this.dob = convert(dob);
	}

	public Date convert(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date d = null;
		try {
			d = sdf.parse(date);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String convert(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return sdf.format(date);
	}

	public int tinhThamNien() {
		Date now = new Date(System.currentTimeMillis());

		long diff = now.getTime() - this.ngayVaoCoQuan.getTime();

		return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

}
