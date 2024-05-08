package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {

	@Override
	public RoleModel mapRow(ResultSet rs) {
		RoleModel result = null;
		try {
			result = new RoleModel();
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
