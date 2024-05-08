package dao.impl;

import java.util.List;

import mapper.CategoryMapper;
import mapper.RowMapper;
import model.Category;

public class CategoryDAOImpl extends AbstractDAOImpl<Category> {

	public List<Category> findAll() {
		String sql = "select * from category";
		RowMapper<Category> cateMapper = new CategoryMapper();
		return query(sql, cateMapper);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Category getCategoryById(Long id) {
		String sql = "select * from category where id = ?";
		return query(sql, new CategoryMapper(), id).get(0);
	}

	public Long insert(Category c) {
		String sql = "insert into category(name, code) values (?,?)";
		return insert(sql, c.getName(), c.getCode());
	}
	
	public boolean deleteById(Long id) {
		String sql = "delete from category where id = ?";
		return update(sql, id);
	}
	
}
