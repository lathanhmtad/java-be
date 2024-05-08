package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.Set;

import entities.IIO;
import entities.NhanVien;
import entities.NhanVienBienChe;
import entities.NhanVienHopDong;
import presentation.NhanVienView;

public class BusinessLogicEmployee implements IIO {	
	private Hashtable<String, NhanVien> listStaff;
	private NhanVienView nhanVienView;
	
	public BusinessLogicEmployee(NhanVienView nhanVienView) {
		this.nhanVienView = nhanVienView;
		listStaff = new Hashtable<>();
	}

	public NhanVien findStaff(String id) {
		return listStaff.get(id);
	}

	public void insertStaff(NhanVien nv) {
		listStaff.put(nv.getId(), nv);
	}

	public void updateStaff(NhanVien nv) {
		listStaff.put(nv.getId(), nv);
	}

	public void deleteStaff(String id) {
		listStaff.remove(id);
	}
	
	public void printList() {
		Set<String> keys = listStaff.keySet();

		for (String key : keys) {
			System.out.println(listStaff.get(key));
		}
	}

	public Set<String> getKeys() {
		return listStaff.keySet();
	}

	@Override
	public void readFile(String path) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File không tồn tại!");
			return;
		}
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);

			String line = null;
			while ((line = br.readLine()) != null) {
				String delim = ", ";
				String[] data = line.split(delim);

				String type = data[0];
				String id = data[1];
				String fullName = data[2];
				String gender = data[3];
				String dob = data[4];
				String identityCard = data[5];
				String ngayVaoCoQuan = data[6];

				if (type.equals("NVHD")) {
					double mucLuong = Double.parseDouble(data[7]);
					NhanVien nv = new NhanVienHopDong();

					nv.setId(id);
					nv.setFullName(fullName);
					nv.setGender(gender);
					nv.setDob(dob);
					nv.setIdentityCard(identityCard);
					nv.setNgayVaoCoQuan(ngayVaoCoQuan);
					((NhanVienHopDong) nv).setMucLuong(mucLuong);

					insertStaff(nv);
				} else if (type.equals("NVBC")) {
					double heSoLuong = Double.parseDouble(data[7]);
					NhanVien nv = new NhanVienBienChe();

					nv.setId(id);
					nv.setFullName(fullName);
					nv.setGender(gender);
					nv.setDob(dob);
					nv.setIdentityCard(identityCard);
					nv.setNgayVaoCoQuan(ngayVaoCoQuan);
					((NhanVienBienChe) nv).setHeSoLuong(heSoLuong);

					insertStaff(nv);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void writeFile(String path) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File không tồn tại!");
			return;
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			Set<String> keys = listStaff.keySet();
			for (String key : keys) {
				NhanVien nv = listStaff.get(key);
				if (nv instanceof NhanVienBienChe) {
					pw.println("NVBC, " + nv.getId() + ", " + nv.getFullName() + ", " + nv.getGender() + ", "
							+ nv.getDob() + ", " + nv.getIdentityCard() + ", " + nv.getNgayVaoCoQuan() + ", "
							+ ((NhanVienBienChe) nv).getHeSoLuong());
				} else if (nv instanceof NhanVienHopDong) {
					pw.println("NVHD, " + nv.getId() + ", " + nv.getFullName() + ", " + nv.getGender() + ", "
							+ nv.getDob() + ", " + nv.getIdentityCard() + ", " + nv.getNgayVaoCoQuan() + ", "
							+ ((NhanVienHopDong) nv).getMucLuong());
				}
			}
			pw.flush();
			System.out.println("Ghi thành công dữ liệu xuống file");
		} catch (FileNotFoundException e) {
			System.out.println("File không tồn tại!");
			e.printStackTrace();
			return;
		} finally {
			pw.close();
		}
	}

}
