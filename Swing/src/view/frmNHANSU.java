package view;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.DANHSACHNHANVIEN;
import model.NHANVIEN;
import model.NHANVIENBC;
import model.NHANVIENHOPDONG;

public class frmNHANSU extends JFrame implements ActionListener {

	private JLabel lbeMaNV, lbeHoten, lbeNgaysinh, lbeGioitinh, lbeSCM, lbeNgayvaocoquang, lbeHesoluong, lbeMucluong;
	private JTextField txtMaNV, txtHoten, txtNgaysinh, txtSCM, txtNgayvaocoquang, txtHesoluong, txtMucluong;
	private JRadioButton rdoNam, rdoNu, rdoNVBC, rdoNVHD;
	private ButtonGroup btgGioiTinh, btgNhanVien;
	public JButton btnThem, btnXoa, btnSua, btnTim;
	public JTable table;
	private DANHSACHNHANVIEN danhsach;

	public frmNHANSU() {
		setSize(1000, 1000);
		setLayout(null);
		this.addWindowListener(new MyWindowClose());
		lbeMaNV = new JLabel("Mã nhân viên:");
		lbeMaNV.setBounds(30, 30, 100, 30);
		this.add(lbeMaNV);
		lbeHoten = new JLabel("Họ tên:");
		lbeHoten.setBounds(30, 70, 100, 30);
		this.add(lbeHoten);
		lbeGioitinh = new JLabel("Giới tính:");
		lbeGioitinh.setBounds(30, 110, 100, 30);
		this.add(lbeGioitinh);
		lbeNgaysinh = new JLabel("Ngày sinh:");
		lbeNgaysinh.setBounds(30, 150, 100, 30);
		this.add(lbeNgaysinh);
		lbeSCM = new JLabel("Số chứng minh:");
		lbeSCM.setBounds(30, 190, 100, 30);
		this.add(lbeSCM);
		lbeNgayvaocoquang = new JLabel("Ngày vào cơ quang:");
		lbeNgayvaocoquang.setBounds(30, 230, 200, 30);
		this.add(lbeNgayvaocoquang);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(150, 30, 150, 30);
		this.add(txtMaNV);
		txtHoten = new JTextField();
		txtHoten.setBounds(150, 70, 150, 30);
		this.add(txtHoten);

		btgGioiTinh = new ButtonGroup();
		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(150, 110, 100, 30);
		this.add(rdoNam);
		btgGioiTinh.add(rdoNam);
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(250, 110, 100, 30);
		this.add(rdoNu);
		btgGioiTinh.add(rdoNu);

		txtNgaysinh = new JTextField();
		txtNgaysinh.setBounds(150, 150, 150, 30);
		this.add(txtNgaysinh);

		txtSCM = new JTextField();
		txtSCM.setBounds(150, 190, 150, 30);
		this.add(txtSCM);

		txtNgayvaocoquang = new JTextField();
		txtNgayvaocoquang.setBounds(150, 230, 150, 30);
		this.add(txtNgayvaocoquang);

		btgNhanVien = new ButtonGroup();
		rdoNVBC = new JRadioButton("Nhân viên biên chế:");
		rdoNVBC.setBounds(30, 270, 200, 30);
		this.add(rdoNVBC);
		btgNhanVien.add(rdoNVBC);

		rdoNVHD = new JRadioButton("Nhân viên hợp đồng");
		rdoNVHD.setBounds(250, 270, 200, 30);
		this.add(rdoNVHD);
		btgNhanVien.add(rdoNVHD);

		lbeHesoluong = new JLabel("Hệ số lương:");
		lbeHesoluong.setBounds(30, 310, 100, 30);
		this.add(lbeHesoluong);

		txtHesoluong = new JTextField();
		txtHesoluong.setBounds(130, 310, 100, 30);
		this.add(txtHesoluong);
		lbeMucluong = new JLabel("Hệ số lương:");
		lbeMucluong.setBounds(250, 310, 100, 30);
		this.add(lbeMucluong);
		txtMucluong = new JTextField();
		txtMucluong.setBounds(350, 310, 100, 30);
		this.add(txtMucluong);

		btnThem = new JButton("Thêm mới");
		btnThem.setBounds(30, 350, 100, 30);
		this.add(btnThem);
		btnThem.addActionListener(this);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(140, 350, 100, 30);
		this.add(btnSua);
		btnSua.addActionListener(this);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(260, 350, 100, 30);
		this.add(btnXoa);
		btnXoa.addActionListener(this);

		btnTim = new JButton("Tìm");
		btnTim.setBounds(370, 350, 100, 30);
		this.add(btnTim);
		btnTim.addActionListener(this);
		danhsach = new DANHSACHNHANVIEN();

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { {}, }, new String[] { "MNV", "Họ và tên", "Giới tính",
				"Ngày sinh", "Số chứng minh", "Ngày vào cơ quan", "Loại nhân viên", "Hệ số lương", "Mức lương" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.setBackground(Color.WHITE);
		table.setBounds(20, 432, 174, 10);

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setBounds(0, 0, 10, 10);
		this.add(table);
		this.add(table);
		table.setRowHeight(24);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 443, 1116, 120);
		this.add(scrollPane);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnThem) {
			if (Them()) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String id = txtMaNV.getText();
				String fullname = txtHoten.getText();
				String gender = rdoNam.isSelected() ? "Nam" : "Nữ";
				String dob = txtNgaysinh.getText();
				String soChungMinh = txtSCM.getText();
				String ngayVaoCoQuan = txtNgayvaocoquang.getText();
				String typeNhanVien = rdoNVBC.isSelected() ? "Nhân viên biên chế" : "Nhân viên hợp đồng";
				String hesoluong = txtHesoluong.getText();
				String mucLuong = txtMucluong.getText();

				System.out.println(id + " " + fullname + " " + gender + " " + dob + " " + soChungMinh + " "
						+ ngayVaoCoQuan + " " + typeNhanVien + " " + hesoluong + " " + mucLuong);

				model.addRow(new Object[] { id, fullname, gender, dob, soChungMinh, ngayVaoCoQuan, typeNhanVien,
						hesoluong, mucLuong });
				JOptionPane.showMessageDialog(this, "Thêm mới thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Thêm mới không thành công");				
			}
		} else if (ae.getSource() == btnXoa) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa thông tin này không", "Thông báo",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

			if (result < 1) {
				Xoa();
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(selectedRow);
					model.fireTableDataChanged();
				}
				JOptionPane.showMessageDialog(this, "Nhân viên đã được xóa");
			}
		} else if (ae.getSource() == btnTim) {
			NHANVIEN nv = Tim(txtMaNV.getText());
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (int i = 0; i < model.getRowCount(); i++) {
				String rowId = (String)model.getValueAt(i + 1, 0);
				System.out.println(rowId + " " + nv.getManv());
				if (rowId.equals(nv.getManv())) {
					table.setRowSelectionInterval(i, i);
					break;
				}
			}

		} else if (ae.getSource() == btnSua) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn sửa thông tin này không", "Thông báo",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			if (result < 1) {
				Sua();
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String id = (String) table.getValueAt(selectedRow, 0);
					String fullname = (String) table.getValueAt(selectedRow, 1);
					String gender = (String) table.getValueAt(selectedRow, 2);
					String dob = (String) table.getValueAt(selectedRow, 3);
					String soChungMinh = (String) table.getValueAt(selectedRow, 4);
					String ngayVaoCoQuan = (String) table.getValueAt(selectedRow, 5);
					String typeNhanVien = (String) table.getValueAt(selectedRow, 6);
					String hesoluong = (String) table.getValueAt(selectedRow, 7);
					String mucLuong = (String) table.getValueAt(selectedRow, 8);

					table.setValueAt(id, selectedRow, 1);
					table.setValueAt(fullname, selectedRow, 2);
					table.setValueAt(gender, selectedRow, 3);
					table.setValueAt(dob, selectedRow, 4);
					table.setValueAt(soChungMinh, selectedRow, 5);
					table.setValueAt(ngayVaoCoQuan, selectedRow, 6);
					table.setValueAt(typeNhanVien, selectedRow, 7);
					table.setValueAt(hesoluong, selectedRow, 8);
					table.setValueAt(mucLuong, selectedRow, 9);

				}
				JOptionPane.showMessageDialog(this, "Nhân viên đã được sửa");
			}
		}

	}

	private void SetValue(NHANVIEN nv) {
		txtMaNV.setText(nv.getManv());
		txtHoten.setText(nv.getHoten());
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		txtNgaysinh.setText(d.format(nv.getNgaysinh()).toString());
		txtNgayvaocoquang.setText(d.format(nv.getNgayvaocoquan()).toString());
		txtSCM.setText(String.valueOf(nv.getSoCM()));
		if (nv.getGioitinh().equals("Nam"))
			this.rdoNam.setSelected(true);
		else
			this.rdoNu.setSelected(true);

		if (nv instanceof NHANVIENBC) {
			double hesoluong = ((NHANVIENBC) nv).getHesoluong();
			txtHesoluong.setText(String.valueOf(hesoluong));
		} else {
			double mucluong = ((NHANVIENHOPDONG) nv).getMucluong();
			txtMucluong.setText(String.valueOf(mucluong));
		}
	}

	private NHANVIEN Tim(String manv) {
		NHANVIEN nv = danhsach.FindStaff(manv);
		return nv;
	}

	private void Xoa() {
		String manv = txtMaNV.getText();
		danhsach.RemoveStaff(manv);
	}

	private boolean Them() {
		try {
			String Manv = txtMaNV.getText();
			String Hoten = txtHoten.getText();
			String Gioitinh = "";
			if (rdoNam.isSelected())
				Gioitinh = "Nam";
			else
				Gioitinh = "Nữ";
			long SoCM = Long.parseLong(txtSCM.getText());
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			Date Ngaysinh = d.parse(txtNgaysinh.getText());
			Date Ngayvaocoquan = d.parse(txtNgayvaocoquang.getText());
			NHANVIEN nv;
			if (rdoNVBC.isSelected()) {
				double Hesoluong = Double.parseDouble(txtHesoluong.getText());
				nv = new NHANVIENBC(Manv, Hoten, Gioitinh, Ngaysinh, SoCM, Ngayvaocoquan, Hesoluong);
			} else {
				double muluong = Double.parseDouble(txtMucluong.getText());
				nv = new NHANVIENHOPDONG(Manv, Hoten, Gioitinh, Ngaysinh, SoCM, Ngayvaocoquan, muluong);
			}
			danhsach.AddStaff(nv);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}

	private boolean Sua() {
		try {
			String Manv = txtMaNV.getText();
			String Hoten = txtHoten.getText();
			String Gioitinh = "";
			if (rdoNam.isSelected())
				Gioitinh = "Nam";
			else
				Gioitinh = "Nữ";
			long SoCM = Long.parseLong(txtSCM.getText());
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			Date Ngaysinh = d.parse(txtNgaysinh.getText());
			Date Ngayvaocoquan = d.parse(txtNgayvaocoquang.getText());
			NHANVIEN nv;
			if (rdoNVBC.isSelected()) {
				double Hesoluong = Double.parseDouble(txtHesoluong.getText());
				nv = new NHANVIENBC(Manv, Hoten, Gioitinh, Ngaysinh, SoCM, Ngayvaocoquan, Hesoluong);
			} else {
				double muluong = Double.parseDouble(txtMucluong.getText());
				nv = new NHANVIENHOPDONG(Manv, Hoten, Gioitinh, Ngaysinh, SoCM, Ngayvaocoquan, muluong);
			}
			danhsach.EditStaff(nv);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}

}
