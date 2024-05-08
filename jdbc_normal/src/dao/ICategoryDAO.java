package dao;

import java.util.List;

import model.Category;

public interface ICategoryDAO {
	List<Category> findAll();
	
	Long insert(Category c);
}
