package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.BusinessLogicNews;
import data.ProcessData;
import entities.Category;
import entities.News;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class NewsView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel contentPane;
	public JTextField textFieldIdNews;
	public JTextField textFieldTitle;
	public JTable table;
	public JComboBox<Category> comboBoxCategory;

	private BusinessLogicNews businessLogicNews;
	public JButton btnAdd;
	public JButton btnDelete;
	public JTextArea textAreaContent;
	public DefaultTableModel tableModel;
	public JButton btnEdit;
	public JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsView frame = new NewsView();
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
	public NewsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		businessLogicNews = new BusinessLogicNews(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldIdNews = new JTextField();
		textFieldIdNews.setBounds(154, 10, 250, 32);
		contentPane.add(textFieldIdNews);
		textFieldIdNews.setColumns(10);

		JLabel lblNewLabel = new JLabel("Mã tin tức");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 23, 79, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tiêu đề");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 75, 79, 17);
		contentPane.add(lblNewLabel_1);

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(154, 62, 659, 32);
		contentPane.add(textFieldTitle);

		textAreaContent = new JTextArea();
		textAreaContent.setBounds(10, 194, 712, 93);
		contentPane.add(textAreaContent);

		JLabel lblNewLabel_2 = new JLabel("Nội dung");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 157, 58, 17);
		contentPane.add(lblNewLabel_2);

		// get list category from database save variable listCategory
		Vector<Category> listCategory = ProcessData.getListCategory();

		comboBoxCategory = new JComboBox<Category>(listCategory);
		comboBoxCategory.setBounds(154, 114, 250, 23);
		contentPane.add(comboBoxCategory);

		JLabel lblNewLabel_3 = new JLabel("Loại tin");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(52, 120, 46, 17);
		contentPane.add(lblNewLabel_3);

		String data[][] = {};
		String header[] = { "Mã tin tức", "Tiêu đề" };
		tableModel = new DefaultTableModel(data, header);

		// insert data to table
		ArrayList<News> listNews = ProcessData.getListNews();
		for (News news : listNews) {
			Object[] newRow = { news.getId(), news.getTitle() };
			tableModel.addRow(newRow);
		}
		table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(800);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 357, 887, 157);
		contentPane.add(scrollPane);

		btnAdd = new JButton("Thêm mới");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(20, 296, 111, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(this);

		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(147, 297, 85, 21);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(this);

		btnEdit = new JButton("Sửa");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(242, 297, 85, 21);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(this);

		btnSearch = new JButton("Tìm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(358, 297, 85, 21);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			int k = businessLogicNews.insert();
			if (k > 0) { // insert data successfully
				JOptionPane.showMessageDialog(this, "Chèn dữ liệu thành công");
				businessLogicNews.refreshTable();
				;
			} else {
				JOptionPane.showMessageDialog(this, "Chèn dữ liệu không thành công");
			}
		} else if (e.getSource() == btnDelete) {
			int k = businessLogicNews.remove();
			if (k > 0) { // remove data successfully
				JOptionPane.showMessageDialog(this, "Xóa dữ liệu thành công");
				businessLogicNews.refreshTable();

			} else {
				JOptionPane.showMessageDialog(this, "Xóa dữ liệu không thành công");
			}
		} else if (e.getSource() == btnEdit) {
			int k = businessLogicNews.edit();
			if (k > 0) { // edit data successfully
				JOptionPane.showMessageDialog(this, "Chỉnh sửa dữ liệu thành công");
				businessLogicNews.refreshTable();
			} else {
				JOptionPane.showMessageDialog(this, "Dữ liệu không tồn tại vui lòng nhập đúng dữ liệu");
			}
		} else if (e.getSource() == btnSearch) {
			News result = businessLogicNews.search();
			if (result != null) { // search data successfully
				JOptionPane.showMessageDialog(this, "Tìm dữ liệu thành công bấm ok để thấy kết quả trên form");
				businessLogicNews.setFormValue(result);

			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy tin tức");
			}
		}
	}

}
