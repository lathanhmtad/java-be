package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import mapper.RowMapper;

public class AbstractDAOImpl<T>  {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/new_schema";
			String user = "root";
			String password = "1234";

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

//	public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
//		List<T> results = new ArrayList<>();
//		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			setParams(ps, params);
//
//			try (ResultSet rs = ps.executeQuery()) {
//				while (rs.next()) {
//					results.add(rowMapper.mapRow(rs));
//				}
//			}
//			return results;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public List<T> query(String sql, RowMapper<T> rowMapper) {
		List<T> results = new ArrayList<>();
		try (Connection conn = getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql)) {
			

			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					T object = rowMapper.mapRow(rs);
					results.add(object);
				}
			}
			return results;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	private void setParams(PreparedStatement ps, Object... params) {
		for (int i = 1; i <= params.length; i++) {
			Object param = params[i - 1];
			try {
				if (param instanceof String) {
					ps.setString(i, (String) param);
				} else if (param instanceof Long) {
					ps.setLong(i, (Long) param);
				} else if(param instanceof Timestamp) {
					ps.setTimestamp(i, (Timestamp) param);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParams(ps, params);
			ps.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	public Long insert(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			setParams(ps, params);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1); 
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return id;
	}
}
