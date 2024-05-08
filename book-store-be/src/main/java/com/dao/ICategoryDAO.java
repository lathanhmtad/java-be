package com.dao;

import java.util.List;

import com.model.Category;

public interface ICategoryDAO {
	 List<Category> getAll();
	
	 boolean insertCategory(Category c);
	
	 Category getCategoryById(Long id);
}
