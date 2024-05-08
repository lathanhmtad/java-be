package dao;

import java.util.List;

import model.NewsModel;

public interface INewsDAO extends IGenericDAO<NewsModel>{
	List<NewsModel> findAll();
	
	NewsModel findNewsById(Long id);
}
