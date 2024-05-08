package dao.impl;

import java.util.List;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

public class CategoryDAOImpl extends AbstractDAOImpl<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}



	@Override
	public CategoryModel findCategoryById(Long id) {
		String sql = "select * from category where id = ?";
		return query(sql, new CategoryMapper(), id).get(0);
	}

	@Override
	public CategoryModel findCategoryByIdAndName(Long id, String name) {
		String sql = "select * from category where id = ? and name = ?";
		return query(sql, new CategoryMapper(), id, name).get(0);
	}

}
