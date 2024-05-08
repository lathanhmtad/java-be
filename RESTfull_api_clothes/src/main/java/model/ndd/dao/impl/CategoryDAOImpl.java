package model.ndd.dao.impl;

import java.util.List;

import com.ndd.dao.ICategoryDAO;
import com.ndd.mapper.CategoryMapper;
import com.ndd.model.Category;

public class CategoryDAOImpl extends AbstractDAOImpl<Category> implements ICategoryDAO {

	@Override
	public List<Category> findAll() {
		String sql = "select * from Category";
		return query(sql, new CategoryMapper());
	}
	
	
}
