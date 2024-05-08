package com.ndd.dao;

import java.util.List;

import com.ndd.model.Category;

public interface ICategoryDAO extends IGenericDAO<Category> {
	List<Category> findAll();
	
}
