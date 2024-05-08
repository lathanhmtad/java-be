package com.ndd.services;

import java.util.List;

import com.ndd.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
