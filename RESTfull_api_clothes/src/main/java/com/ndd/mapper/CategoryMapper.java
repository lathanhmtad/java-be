package com.ndd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndd.model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs) {
		Category c = new Category();
		try {
			c.setId(rs.getLong("id"));
			c.setName(rs.getString("name"));
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
