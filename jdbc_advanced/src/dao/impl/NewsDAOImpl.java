package dao.impl;

import java.util.List;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.News;

public class NewsDAOImpl extends AbstractDAOImpl<News> implements INewsDAO {

	@Override
	public List<News> findAll() {
		String sql = "select * from news";
		return query(sql, new NewsMapper());
	}

	@Override
	public Long insert(News news) {
		String sql = "insert into news(title, shortdescription, content, categoryid) values(?,?,?,?)";
		return insert(sql, news.getTitle(), news.getShortDescription(), news.getContent(), news.getCategoryId());
	}
	
	@Override
	public boolean deleteById(Long id) {
		String sql = "delete from news where id = ?";
		return update(sql, id);
	}
	
	
}
