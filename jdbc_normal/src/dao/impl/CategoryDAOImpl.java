package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ICategoryDAO;
import model.Category;
import utils.JDBCUtil;

public class CategoryDAOImpl implements ICategoryDAO {

	@Override
	public List<Category> findAll() {
		String sql = "select * from category";
		List<Category> results = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Category category = new Category();
					category.setName(rs.getString("name"));
					category.setCode(rs.getString("code"));
					category.setId(rs.getLong("id"));
					results.add(category);
				}
			}
			return results;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Long insert(Category c) {
		String sql = "insert into category(name, code) value(?, ?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Long id = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			conn.setAutoCommit(false);
			ps.setString(1, c.getName());
			ps.setString(2, c.getCode());
			
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}
			conn.commit();
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
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
