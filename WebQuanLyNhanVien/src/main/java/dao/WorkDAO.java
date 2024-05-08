package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Work;
import utils.JDBCUtil;

public class WorkDAO implements DAOInterface<Work> {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static WorkDAO getInstance() {
		return new WorkDAO();
	}

	@Override
	public int insert(Work t) {
		return 0;
	}

	@Override
	public int update(Work t) {
		return 0;
	}

	@Override
	public int delete(Work t) {
		return 0;
	}

	@Override
	public Work getObject(int id) {
		return null;
	}

	@Override
	public ArrayList<Work> getList() {
		ArrayList<Work> list = null;
		try {
			conn = JDBCUtil.getConnection();

			String sql = "SELECT * FROM work";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Work work = new Work(id, name);
				list.add(work);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}

}
