package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel result = null;
		try {
			result = new CategoryModel();
			result.setId(rs.getLong("id"));
			result.setName(rs.getString("name"));
			result.setCode(rs.getString("code"));
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
