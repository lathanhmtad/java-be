package com.ndd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndd.model.Category;
import com.ndd.model.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs) {
		try {
			Product p = new Product();
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));
			p.setThumbnail(rs.getBytes("thumbnail"));
			p.setPrice(rs.getDouble("price"));
			p.setDescription(rs.getString("description"));
			
			Category c = new Category();
			c.setId(rs.getLong("category_id"));
			c.setName(rs.getString("category_name"));
			
			p.setCategory(c);
			
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
