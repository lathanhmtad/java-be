package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class DANHSACHNHANVIEN implements IIO {
	private Hashtable<String, NHANVIEN> ListStaff;

	public DANHSACHNHANVIEN() {

		ListStaff = new Hashtable<String, NHANVIEN>();
	}

	public void AddStaff(NHANVIEN nv) {
		this.ListStaff.put(nv.getManv(), nv);
	}

	public NHANVIEN FindStaff(String Manv) {
		return this.ListStaff.get(Manv);
	}

	public void RemoveStaff(String Manv) {
		this.ListStaff.remove(Manv);
	}

	public void EditStaff(NHANVIEN nv) {
		this.ListStaff.replace(nv.getManv(), nv);
	}

	@Override
	public void ReadFile() {
		FileReader fr;
		try {
			fr = new FileReader("D:\\QUANLYNHANVIEN.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			int i = 0;
			while ((s = br.readLine()) != null) {
				String[] strinfor = s.split("[,]+");
				NHANVIEN nhanvien = null;
				DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
				String manv = strinfor[1];
				String hoten = strinfor[2];
				String gioitinh = strinfor[3];
				Date ngaysinh = d.parse(strinfor[4]);
				long socm = Long.parseLong(strinfor[5]);
				Date ngayvaocoquan = d.parse(strinfor[6]);
				if (strinfor[0].equals("B")) {
					double hesoluong = Double.parseDouble(strinfor[7]);
					nhanvien = new NHANVIENBC(manv, hoten, gioitinh, ngaysinh, socm, ngayvaocoquan, hesoluong);
				} else if (strinfor[0].equals("H")) {
					double mucluong = Double.parseDouble(strinfor[7]);
					nhanvien = new NHANVIENHOPDONG(manv, hoten, gioitinh, ngaysinh, socm, ngayvaocoquan, mucluong);
				}
				this.ListStaff.put(nhanvien.getManv(), nhanvien);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void WriteFile() {
		FileWriter fw;
		try {
			String strInfor = "";
			fw = new FileWriter("D:\\QUANLYNHANVIEN.txt");
			double hesoluong_mucluong;
			for (NHANVIEN nhanvien : ListStaff.values()) {
				if (nhanvien instanceof NHANVIENBC) {
					hesoluong_mucluong = ((NHANVIENBC) nhanvien).getHesoluong();
					strInfor += "B,";
				} else {
					hesoluong_mucluong = ((NHANVIENHOPDONG) nhanvien).getMucluong();
					strInfor += "H,";
				}
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				strInfor += nhanvien.getManv() + "," + nhanvien.getHoten() + "," + nhanvien.getGioitinh() + ","
						+ formatter.format(nhanvien.getNgaysinh()) + "," + String.valueOf(nhanvien.getSoCM()) + ","
						+ formatter.format(nhanvien.getNgayvaocoquan()) + "," + hesoluong_mucluong + "\r\n";

			}
			fw.write(strInfor);
			fw.close();
		} catch (IOException e) {
		}
	}

}
