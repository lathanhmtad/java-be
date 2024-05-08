package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.INewsDAO;
import model.News;
import utils.JDBCUtil;

public class NewsDAOImpl implements INewsDAO {

	@Override
	public List<News> findAll() {
		String sql = "select * from news";
		List<News> results = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					News news = new News();
					news.setTitle(rs.getString("title"));
					news.setShortDescription(rs.getString("shortdescription"));
					news.setId(rs.getLong("id"));
					news.setContent(rs.getString("content"));
					news.setCategoryId(rs.getLong("categoryid"));
					results.add(news);
				}
			}
			return results;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Long insert(News news) {
		String sql = "insert into news(title, shortdescription, content, categoryid) value(?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Long id = null;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			conn.setAutoCommit(false);
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getShortDescription());
			ps.setString(3, news.getContent());
			ps.setLong(4, news.getCategoryId());

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return id;
	}
}
