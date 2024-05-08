package dao;

import java.util.List;

import model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	
	CategoryModel findCategoryById(Long id);
	
	CategoryModel findCategoryByIdAndName(Long id, String name);
	
}
