package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IGenericDAO;
import mapper.RowMapper;
import utils.JDBCUtil;

public class AbstractDAOImpl<T> implements IGenericDAO<T> {

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
		List<T> results = new ArrayList<>();

		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

			// set parameters
			setParams(ps, params);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				T t = rowMapper.mapRow(rs);
				results.add(t);
			}

			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setParams(PreparedStatement ps, Object[] params) {

		for (int i = 0; i < params.length; i++) {

			try {
				if (params[i] instanceof Long) {
					ps.setLong(i + 1, (Long) params[i]);
				} else if(params[i] instanceof String) {
					ps.setString(i + 1, (String) params[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
