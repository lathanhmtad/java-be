package com.ndd.dao.impl;

import java.util.List;

import com.ndd.dao.INewsDAO;
import com.ndd.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long id) {
		
		return null;
	}

	@Override
	public Long save(NewsModel newModel) {
		String sql = "insert into news(title, content, categoryid) values(?,?,?)";
		return null;
	}
	
}
