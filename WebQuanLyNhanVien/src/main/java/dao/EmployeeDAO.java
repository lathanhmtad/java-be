package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Work;
import utils.JDBCUtil;

public class EmployeeDAO implements DAOInterface<Employee> {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static EmployeeDAO getInstance() {
		return new EmployeeDAO();
	}

	@Override
	public int insert(Employee t) {
		int result = 0;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO employee (full_name, dob, address, start_date, end_date, salary, work_id)\r\n"
					+ "VALUES (?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getFullName());
			ps.setDate(2, new Date(t.getDob().getTime()));
			ps.setString(3, t.getAddress());
			ps.setDate(4, new Date(t.getWorkStartDate().getTime()));
			ps.setDate(5, new Date(t.getWorkEndDate().getTime()));
			ps.setDouble(6, t.getSalary());
			ps.setInt(7, t.getWork().getId());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(Employee t) {
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "UPDATE employee\r\n"
					+ "SET full_name = ?, dob = ?, address=?, start_date=?, end_date=?, salary=?, work_id=?\r\n"
					+ "WHERE id = ?";
			
			conn = JDBCUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getFullName());
			ps.setDate(2, new Date(t.getDob().getTime()));
			ps.setString(3, t.getAddress());
			ps.setDate(4, new Date(t.getWorkStartDate().getTime()));
			ps.setDate(5, new Date(t.getWorkEndDate().getTime()));
			ps.setDouble(6, t.getSalary());
			ps.setInt(7, t.getWork().getId());
			ps.setInt(8, t.getId());
			
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(Employee t) {
		String sql = "DELETE FROM employee WHERE id = ?";

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getId());

			int result = ps.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Employee getObject(int id) {

		try {
			String sql = "SELECT e.*, w.name AS work_name\r\n" + "FROM employee e \r\n"
					+ "JOIN work w ON e.work_id = w.id \r\n" + "WHERE e.id = ?";

			conn = JDBCUtil.getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			Employee e = new Employee();

			while (rs.next()) {
				String fullName = rs.getString("full_name");
				Date dob = rs.getDate("dob");
				String address = rs.getString("address");
				Date workStartDate = rs.getDate("start_date");
				Date workEndDate = rs.getDate("end_date");
				double salary = rs.getDouble("salary");

				int workId = rs.getInt("work_id");
				String workName = rs.getString("work_name");
				Work work = new Work(workId, workName);

				e.setId(id);
				e.setFullName(fullName);
				e.setDob(dob);
				e.setAddress(address);
				e.setWorkStartDate(workStartDate);
				e.setWorkEndDate(workEndDate);
				e.setSalary(salary);
				e.setWork(work);

			}
			return e;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getList() {

		ArrayList<Employee> list = null;

		try {
			conn = JDBCUtil.getConnection();

			String sql = "SELECT e.*, w.name AS work_name\r\n" + "FROM employee e\r\n"
					+ "JOIN work w ON e.work_id = w.id;";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				Date dob = rs.getDate("dob");
				String address = rs.getString("address");
				Date workStartDate = rs.getDate("start_date");
				Date workEndDate = rs.getDate("end_date");
				double salary = rs.getDouble("salary");

				int workId = rs.getInt("work_id");
				String workName = rs.getString("work_name");
				Work work = new Work(workId, workName);

				Employee e = new Employee();
				e.setId(id);
				e.setFullName(fullName);
				e.setDob(dob);
				e.setAddress(address);
				e.setWorkStartDate(workStartDate);
				e.setWorkEndDate(workEndDate);
				e.setSalary(salary);
				e.setWork(work);

				list.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int getNumberPage() {
		String query = "SELECT COUNT(*) FROM employee";

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			int total = 0;
			while (rs.next()) {
				total = rs.getInt(1);
			}
			int pageSize = 3;

			int numberPage;
			if (total % pageSize != 0) {
				numberPage = total / pageSize + 1;
			} else
				numberPage = total / pageSize;
			return numberPage;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<Employee> getPaging(int index) {
		ArrayList<Employee> list = null;

		try {
			conn = JDBCUtil.getConnection();

			String sql = "SELECT e.*, w.name AS work_name\r\n" + "FROM employee e  \r\n"
					+ "JOIN work w ON e.work_id = w.id \r\n" + "ORDER BY e.id\r\n" + "LIMIT ?, ?";

			int pageSize = 3;

			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * pageSize);
			ps.setInt(2, pageSize);

			rs = ps.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				Date dob = rs.getDate("dob");
				String address = rs.getString("address");
				Date workStartDate = rs.getDate("start_date");
				Date workEndDate = rs.getDate("end_date");
				double salary = rs.getDouble("salary");

				int workId = rs.getInt("work_id");
				String workName = rs.getString("work_name");
				Work work = new Work(workId, workName);

				Employee e = new Employee();
				e.setId(id);
				e.setFullName(fullName);
				e.setDob(dob);
				e.setAddress(address);
				e.setWorkStartDate(workStartDate);
				e.setWorkEndDate(workEndDate);
				e.setSalary(salary);
				e.setWork(work);

				list.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
