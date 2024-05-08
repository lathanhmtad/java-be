package com.ndd.dao;

import java.util.List;

import com.ndd.model.NewsModel;

public interface INewsDAO extends IGenericDAO<NewsModel> {
	List<NewsModel> findByCategoryId(Long id);
	
	Long save(NewsModel newModel);
}
