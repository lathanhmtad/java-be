package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import entities.Category;
import entities.News;

public class ProcessData {
	public static Vector<Category> getListCategory() {
		Vector<Category> list = new Vector<>();

		Connection conn = SQLServerConnection.getConnection();

		PreparedStatement ps = null;

		ResultSet rs = null;
		try {
			String query = "select * from tbLOAI";

			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);

				Category loaiTin = new Category(id, name);

				list.add(loaiTin);

			}

			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}

		return list;

	}

	public static ArrayList<News> getListNews() {
		ArrayList<News> result = new ArrayList<>();

		Connection conn = SQLServerConnection.getConnection();

		PreparedStatement ps = null;

		ResultSet rs = null;
		try {
			String query = "select * from tbTINTUC";

			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);

				News news = new News();
				news.setId(id);
				news.setTitle(title);
				news.setContent(content);

				result.add(news);

			}

			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}

		return result;
	}

	public static int insertNews(News o) {
		Connection conn = SQLServerConnection.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "insert into tbTINTUC values(?, ?, ?)";

			ps = conn.prepareStatement(query);

			ps.setString(1, o.getTitle());
			ps.setString(2, o.getContent());
			ps.setInt(3, o.getCategory().getId());

			result = ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}

		return result;
	}

	public static int deleteNews(int id) {
		Connection conn = SQLServerConnection.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "delete tbTINTUC where MATINTUC = ?";

			ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			result = ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}

		return result;
	}

	public static int updateNews(News news) {
		Connection conn = SQLServerConnection.getConnection();
		PreparedStatement ps = null;
		int k = 0;
		try {
			String query = "update tbTINTUC\r\n" + "	set TIEUDE = ?, NOIDUNG = ?, MALOAI = ? where MATINTUC = ?";

			ps = conn.prepareStatement(query);

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getContent());
			ps.setInt(3, news.getCategory().getId());
			ps.setInt(4, news.getId());

			k = ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}

		return k;

	}

	public static News searchNews(int id) {
		News result = null;
		Connection conn = SQLServerConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT tbTINTUC.MATINTUC, tbTINTUC.TIEUDE, tbTINTUC.NOIDUNG, tbLOAI.MALOAI, tbLOAI.TENLOAI\r\n"
					+ "FROM tbTINTUC \r\n"
					+ "INNER JOIN tbLOAI ON tbTINTUC.MALOAI = tbLOAI.MALOAI where MATINTUC = ?";

			ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				result = new News();
				result.setId(rs.getInt(1));
				result.setTitle(rs.getString(2));
				result.setContent(rs.getString(3));
				
				Category category = new Category();
				category.setId(rs.getInt(4));
				category.setName(rs.getString(5));
				
				result.setCategory(category);
				
			}

			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLServerConnection.closeConnection(conn);
		}

		return result;

	}

}
