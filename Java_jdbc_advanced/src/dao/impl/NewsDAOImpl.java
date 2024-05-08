package dao.impl;

import java.util.List;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.NewsModel;

public class NewsDAOImpl extends AbstractDAOImpl<NewsModel> implements INewsDAO {

	public List<NewsModel> findAll() {
		String sql = "select * from news";
		return query(sql, new NewsMapper());
	}

	@Override
	public NewsModel findNewsById(Long id) {
		
		return null;
	}

}
