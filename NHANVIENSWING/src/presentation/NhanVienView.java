package presentation;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import data.ProcessData;
import entities.NhanVien;
import entities.NhanVienBienChe;
import entities.NhanVienHopDong;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class NhanVienView extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldFullName;
	private JTextField textFieldDob;
	private JTextField textFieldCMND;
	private JTextField textFieldNgayVaoCoQuan;
	private JTextField textFieldHeSoLuong;
	private JTextField textFieldMucLuong;

	private JTable table;

	private JMenuItem menuItemReadFile;
	private JMenuItem menuItemReadDatabase;
	private JMenuItem menuItemWriteFile;

	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnNVBC;
	private JRadioButton rdbtnNVHD;

	private ButtonGroup genderGroup;
	private ButtonGroup employeeGroup;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienView frame = new NhanVienView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NhanVienView() {

		setTitle("Quản lý nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 43, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);

		menuItemReadFile = new JMenuItem("Đọc dữ liệu từ File và đưa vào bảng");
		menuItemReadFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(menuItemReadFile);
		menuItemReadFile.addActionListener(this);

		menuItemReadDatabase = new JMenuItem("Đọc dữ liệu từ database và đưa vào bảng");
		menuItemReadDatabase.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(menuItemReadDatabase);
		menuItemReadDatabase.addActionListener(this);

		menuItemWriteFile = new JMenuItem("Ghi dữ liệu trong bảng vào File");
		menuItemWriteFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(menuItemWriteFile);

		JLabel lblNewLabel_2 = new JLabel("Ảnh nhân viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(1, 75, 98, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(238, 10, 85, 17);
		contentPane.add(lblNewLabel);

		textFieldId = new JTextField();
		textFieldId.setBounds(333, 10, 400, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHTn.setBounds(248, 49, 85, 17);
		contentPane.add(lblHTn);

		textFieldFullName = new JTextField();
		textFieldFullName.setColumns(10);
		textFieldFullName.setBounds(343, 49, 400, 20);
		contentPane.add(textFieldFullName);

		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgySinh.setBounds(238, 106, 85, 17);
		contentPane.add(lblNgySinh);

		textFieldDob = new JTextField();
		textFieldDob.setColumns(10);
		textFieldDob.setBounds(333, 107, 400, 20);
		contentPane.add(textFieldDob);

		JLabel lblSCm = new JLabel("Số CMND");
		lblSCm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSCm.setBounds(238, 137, 85, 17);
		contentPane.add(lblSCm);

		textFieldCMND = new JTextField();
		textFieldCMND.setColumns(10);
		textFieldCMND.setBounds(333, 141, 400, 20);
		contentPane.add(textFieldCMND);

		JLabel lblNgyVoC = new JLabel("Ngày vào cơ quan");
		lblNgyVoC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyVoC.setBounds(213, 171, 114, 17);
		contentPane.add(lblNgyVoC);

		textFieldNgayVaoCoQuan = new JTextField();
		textFieldNgayVaoCoQuan.setColumns(10);
		textFieldNgayVaoCoQuan.setBounds(354, 171, 400, 20);
		contentPane.add(textFieldNgayVaoCoQuan);

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMale.setBounds(349, 75, 55, 25);
		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFemale.setBounds(423, 75, 43, 25);
		contentPane.add(rdbtnFemale);

		genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);

		JLabel lblNewLabel_2_1 = new JLabel("Giới tính");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(238, 79, 85, 17);
		contentPane.add(lblNewLabel_2_1);

		rdbtnNVBC = new JRadioButton("Nhân viên biên chế");
		rdbtnNVBC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNVBC.setBounds(178, 210, 147, 25);
		contentPane.add(rdbtnNVBC);

		rdbtnNVHD = new JRadioButton("Nhân viên hợp đồng");
		rdbtnNVHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNVHD.setBounds(353, 210, 155, 25);
		contentPane.add(rdbtnNVHD);

		employeeGroup = new ButtonGroup();
		employeeGroup.add(rdbtnNVBC);
		employeeGroup.add(rdbtnNVHD);

		JLabel lblHSLng = new JLabel("Hệ số lương");
		lblHSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHSLng.setBounds(49, 241, 77, 17);
		contentPane.add(lblHSLng);

		textFieldHeSoLuong = new JTextField();
		textFieldHeSoLuong.setColumns(10);
		textFieldHeSoLuong.setBounds(148, 242, 96, 19);
		contentPane.add(textFieldHeSoLuong);

		JLabel lblMcLng = new JLabel("Mức lương");
		lblMcLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMcLng.setBounds(324, 241, 67, 17);
		contentPane.add(lblMcLng);

		textFieldMucLuong = new JTextField();
		textFieldMucLuong.setColumns(10);
		textFieldMucLuong.setBounds(399, 242, 96, 19);
		contentPane.add(textFieldMucLuong);

		String data[][] = {};
		String header[] = { "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "Số chứng minh", "Ngày vào cơ quan",
				"Loại nhân viên", "Hệ số lương", "Mức lương" };
		DefaultTableModel tableModel = new DefaultTableModel(data, header);
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(75);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(7).setPreferredWidth(75);
		table.getColumnModel().getColumn(7).setPreferredWidth(75);

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(this);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 313, 887, 258);
		contentPane.add(scrollPane);

		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(77, 271, 100, 25);
		contentPane.add(btnAdd);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemove.setBounds(225, 271, 91, 32);
		contentPane.add(btnRemove);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEdit.setBounds(358, 268, 91, 32);
		contentPane.add(btnEdit);

		JButton btnSearch = new JButton("Tìm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(491, 271, 91, 32);
		contentPane.add(btnSearch);

		this.setVisible(true);
	}

	private void addRecord(Object[] data) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(data);
	}

	public void setFormValue(NhanVien nv) {
		textFieldId.setText(nv.getId());
		textFieldFullName.setText(nv.getFullName());

		if (nv.getGender().equals("Nam")) {
			rdbtnMale.setSelected(true);
		} else if (nv.getGender().equals("Nữ")) {
			rdbtnFemale.setSelected(true);
		}

		textFieldDob.setText(nv.getDob());
		textFieldCMND.setText(nv.getIdentityCard());
		textFieldNgayVaoCoQuan.setText(nv.getNgayVaoCoQuan());

		if (nv instanceof NhanVienBienChe) {
			rdbtnNVBC.setSelected(true);
			textFieldHeSoLuong.setText(String.valueOf(((NhanVienBienChe) nv).getHeSoLuong()));
			textFieldMucLuong.setText("");
		} else if (nv instanceof NhanVienHopDong) {
			rdbtnNVHD.setSelected(true);
			textFieldMucLuong.setText(String.valueOf(((NhanVienHopDong) nv).getMucLuong()));
			textFieldHeSoLuong.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// read data from database and display it in view
		if (e.getActionCommand().equals(menuItemReadDatabase.getText())) {
			ProcessData processData = new ProcessData();

			Hashtable<String, NhanVien> list = processData.list(); // get data from database

			// iterate through the data and display it to the interface
			Set<String> employeeIds = list.keySet();
			for (String employeeId : employeeIds) {
				NhanVien nv = list.get(employeeId);
				if (nv instanceof NhanVienBienChe) {
					Object[] data = new Object[] { nv.getId(), nv.getFullName(), nv.getGender(), nv.getDob(),
							nv.getIdentityCard(), nv.getNgayVaoCoQuan(), "Nhân viên biên chế",
							((NhanVienBienChe) nv).getHeSoLuong(), "" };
					this.addRecord(data); // add value into table
				} else if (nv instanceof NhanVienHopDong) {
					Object[] data = new Object[] { nv.getId(), nv.getFullName(), nv.getGender(), nv.getDob(),
							nv.getIdentityCard(), nv.getNgayVaoCoQuan(), "Nhân viên hợp đồng", "",
							((NhanVienHopDong) nv).getMucLuong() };
					this.addRecord(data); // add value into table
				}
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = this.table.getSelectedRow();
			System.out.println("Selected row: " + selectedRow);
			if (selectedRow != -1) {
				String id = (String) this.table.getValueAt(selectedRow, 0);
				String fullName = (String) this.table.getValueAt(selectedRow, 1);
				String gender = (String) this.table.getValueAt(selectedRow, 2);
				String dob = (String) this.table.getValueAt(selectedRow, 3);
				String cmnd = (String) this.table.getValueAt(selectedRow, 4);
				String ngayVaoCoQuan = (String) this.table.getValueAt(selectedRow, 5);
				String typeEmployee = (String) this.table.getValueAt(selectedRow, 6);
				String heSoLuong = String.valueOf(this.table.getValueAt(selectedRow, 7));
				String mucLuong = String.valueOf(this.table.getValueAt(selectedRow, 8));
				if (typeEmployee.equals("Nhân viên biên chế")) {
					NhanVien nv = new NhanVienBienChe(id, fullName, ngayVaoCoQuan, gender, cmnd, dob,
							Double.parseDouble(heSoLuong));
					this.setFormValue(nv);
				} else if (typeEmployee.equals("Nhân viên hợp đồng")) {
					NhanVien nv = new NhanVienHopDong(id, fullName, ngayVaoCoQuan, gender, cmnd, dob,
							Double.parseDouble(mucLuong));
					this.setFormValue(nv);
				}
			}
		}
	}
}
