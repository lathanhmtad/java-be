package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import business.BusinessLogicNhanVien;
import entities.NhanVien;

public class GUINhanVien extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lbeMaNV, lbeHoTen, lbeGioiTinh, lbeSoChungMinh, lbeNgayVaoCoQuan, lbeHesoluong, lbeMucLuong;
	public JTextField txtMaNV, txtHoTen, txtNgaySinh, txtSoChungMinh, txtNgayVaoCoQuan, txtHeSoLuong, txtMucluong;
	public JRadioButton rdoNam, rdoNu, rdoNVBC, rdoNVHD;
	private ButtonGroup btgGioiTinh, btgNhanVien;
	private JButton btnThem, btnXoa, btnSua, btnTim, btnReadFile, btnWriteFile;
	public JTable tblNhanVien;
	public JScrollPane jScrollPane;

	private JButton btnReadDatabase;

	private BusinessLogicNhanVien businessLogicNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUINhanVien frame = new GUINhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUINhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000, 600);
		this.setLayout(null);

		businessLogicNhanVien = new BusinessLogicNhanVien(this);

		lbeMaNV = new JLabel("Mã nhân viên:");
		lbeMaNV.setBounds(30, 30, 100, 30);
		this.add(lbeMaNV);

		lbeHoTen = new JLabel("Họ tên:");
		lbeHoTen.setBounds(30, 70, 100, 30);
		this.add(lbeHoTen);

		lbeGioiTinh = new JLabel("Giới tính:");
		lbeGioiTinh.setBounds(30, 110, 100, 30);
		this.add(lbeGioiTinh);

		JLabel lbeNgaySinh = new JLabel("Ngày sinh:");
		lbeNgaySinh.setBounds(30, 150, 100, 30);
		getContentPane().add(lbeNgaySinh);

		lbeSoChungMinh = new JLabel("Số chứng minh:");
		lbeSoChungMinh.setBounds(30, 190, 100, 30);
		getContentPane().add(lbeSoChungMinh);

		lbeNgayVaoCoQuan = new JLabel("Ngày vào cơ quan:");
		lbeNgayVaoCoQuan.setBounds(30, 230, 120, 30);
		getContentPane().add(lbeNgayVaoCoQuan);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(150, 30, 150, 30);
		getContentPane().add(txtMaNV);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(150, 70, 150, 30);
		getContentPane().add(txtHoTen);

		btgGioiTinh = new ButtonGroup();

		rdoNam = new JRadioButton("Nam", true);
		rdoNam.setBounds(150, 110, 100, 30);
		getContentPane().add(rdoNam);
		btgGioiTinh.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(250, 110, 100, 30);
		getContentPane().add(rdoNu);
		btgGioiTinh.add(rdoNu);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(150, 150, 150, 30);
		getContentPane().add(txtNgaySinh);

		txtSoChungMinh = new JTextField();
		txtSoChungMinh.setBounds(150, 190, 150, 30);
		getContentPane().add(txtSoChungMinh);

		txtNgayVaoCoQuan = new JTextField();
		txtNgayVaoCoQuan.setBounds(150, 230, 150, 30);
		getContentPane().add(txtNgayVaoCoQuan);

		btgNhanVien = new ButtonGroup();
		rdoNVBC = new JRadioButton("Nhân viên biên chế", true);
		rdoNVBC.setBounds(30, 270, 150, 30);
		getContentPane().add(rdoNVBC);

		btgNhanVien.add(rdoNVBC);
		rdoNVHD = new JRadioButton("Nhân viên hợp đồng");
		rdoNVHD.setBounds(250, 270, 150, 30);
		getContentPane().add(rdoNVHD);

		btgNhanVien.add(rdoNVHD);
		lbeHesoluong = new JLabel("Hệ số lương");
		lbeHesoluong.setBounds(30, 310, 100, 30);
		getContentPane().add(lbeHesoluong);

		txtHeSoLuong = new JTextField();
		txtHeSoLuong.setBounds(130, 310, 100, 30);
		getContentPane().add(txtHeSoLuong);

		lbeMucLuong = new JLabel("Mức lương");
		lbeMucLuong.setBounds(250, 310, 100, 30);
		getContentPane().add(lbeMucLuong);

		txtMucluong = new JTextField();
		txtMucluong.setBounds(350, 310, 100, 30);
		getContentPane().add(txtMucluong);

		btnThem = new JButton("Thêm mới");
		btnThem.setBounds(30, 350, 100, 30);
		getContentPane().add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(140, 350, 100, 30);
		getContentPane().add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(260, 350, 100, 30);
		getContentPane().add(btnXoa);

		btnTim = new JButton("Tìm");
		btnTim.setBounds(370, 350, 80, 30);
		getContentPane().add(btnTim);

		btnReadFile = new JButton("Đọc file");
		btnReadFile.setBounds(470, 350, 100, 30);
		getContentPane().add(btnReadFile);

		btnWriteFile = new JButton("Ghi file");
		btnWriteFile.setBounds(580, 350, 100, 30);
		getContentPane().add(btnWriteFile);

		btnReadDatabase = new JButton("Đọc database");
		btnReadDatabase.setBounds(700, 350, 150, 30);
		getContentPane().add(btnReadDatabase);
		btnReadDatabase.addActionListener(this);

		String data[][] = {};
		String header[] = { "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "Số chứng minh", "Ngày vào cơ quan",
				"Loại nhân viên", "Hệ số lương", "Mức lương" };
		DefaultTableModel tableModel = new DefaultTableModel(data, header);
		tblNhanVien = new JTable(tableModel);
		jScrollPane = new JScrollPane(tblNhanVien);
		jScrollPane.setBounds(20, 400, 950, 150);
		this.add(jScrollPane);

		this.setVisible(true);
	}

	public void insertDataToTable(Hashtable<String, NhanVien> list) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnReadDatabase) { // đọc dữ liệu từ database và đưa vào bảng
			businessLogicNhanVien.loadDataToTable();
		}
		else if(e.getSource() == btnThem) { // thêm nhân viên khi ấn vào nút thêm
			
			// lấy dữ liệu nhập vào từ form và tạo ra đối tượng nhân viên
			String id = txtHoTen.getText();
			String gender = rdoNam.isSelected() ? "Nam" : "Nữ";
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
//			businessLogicNhanVien.insertNhanVien()
		}

	}
}
