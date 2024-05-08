package dao;

import java.util.List;

import model.News;

public interface INewsDAO {
	List<News> findAll();
	
	Long insert(News news);
}
