package model.ndd.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ndd.dao.IGenericDAO;
import com.ndd.mapper.RowMapper;

public class AbstractDAOImpl<T> implements IGenericDAO<T> {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "1234";
			String url = "jdbc:mysql://localhost:3306/product_manager";
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
	    List<T> results = new ArrayList<>();

	    try (Connection conn = getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            T t = rowMapper.mapRow(rs);
	            results.add(t);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return results;
	}


	@Override
	public boolean update(String sql, Object... params) {
		return false;
	}

	@Override
	public boolean delete(String sql, Object... params) {
		return false;
	}
	
	
//	private void setParams(PreparedStatement ps, Object... params) {
//		
//	}

	
	
}
