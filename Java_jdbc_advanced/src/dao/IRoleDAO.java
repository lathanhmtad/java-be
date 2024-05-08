package dao;

import java.util.List;

import model.RoleModel;

public interface IRoleDAO extends IGenericDAO<RoleModel> {
	List<RoleModel> findAll();
}
