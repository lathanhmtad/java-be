package com.ndd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ndd.dao.IGenericDAO;
import com.ndd.mapper.RowMapper;
import com.ndd.utils.JDBCUtil;

public class AbstractDAOImpl<T> implements IGenericDAO<T> {

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
		List<T> results = new ArrayList<>();
		
		try(Connection conn = JDBCUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			
			// set parameters
			setParams(ps, params);
			
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					T object = rowMapper.mapRow(rs);
					results.add(object);
				}
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setParams(PreparedStatement ps, Object[] params) {
		for(int i = 0; i < params.length; i++) {
			try {
				if(params[i] instanceof String) {
					ps.setString(i + 1, (String) params[i]);
				}
				else if(params[i] instanceof Long) {
					ps.setLong(i + 1, (Long) params[i]);
				}
				else if(params[i] instanceof Timestamp) {
					ps.setTimestamp(i + 1, (Timestamp) params[i]);
				}
				else if(params[i] instanceof Integer) {
					ps.setInt(i + 1, (Integer) params[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
