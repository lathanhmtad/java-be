package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet resultSet) {
		Category c = new Category();
		try {
			c.setId(resultSet.getLong("id"));
			c.setName(resultSet.getString("name"));
			c.setCode(resultSet.getString("code"));
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
