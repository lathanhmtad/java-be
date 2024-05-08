package com.ndd.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.ndd.dao.ICategoryDAO;
import com.ndd.model.CategoryModel;
import com.ndd.services.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO iCategoryDAO;
	
	
	@Override
	public List<CategoryModel> findAll() {
		return iCategoryDAO.findAll();
	}
	
}
