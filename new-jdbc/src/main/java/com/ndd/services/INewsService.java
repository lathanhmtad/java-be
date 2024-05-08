package com.ndd.services;

import java.util.List;

import com.ndd.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	
	NewsModel save(NewsModel newsModel);
}
