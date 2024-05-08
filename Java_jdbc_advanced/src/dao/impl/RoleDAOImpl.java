package dao.impl;

import java.util.List;

import dao.IRoleDAO;
import mapper.RoleMapper;
import model.RoleModel;

public class RoleDAOImpl extends AbstractDAOImpl<RoleModel> implements IRoleDAO {

	@Override
	public List<RoleModel> findAll() {
		String sql = "select * from role";
		return query(sql, new RoleMapper());
	}

	
}
