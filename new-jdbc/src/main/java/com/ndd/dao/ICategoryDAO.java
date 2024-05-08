package com.ndd.dao;

import java.util.List;

import com.ndd.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO {
	List<CategoryModel> findAll();
}
