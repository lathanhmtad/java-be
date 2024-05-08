package main;

import java.util.List;

import dao.INewsDAO;
import dao.impl.CategoryDAOImpl;
import dao.impl.NewsDAOImpl;
import model.Category;
import model.News;

public class Main {
	public static void main(String[] args) {
		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
		
		
		List<Category> categoryList = categoryDAO.findAll();
		for (Category category : categoryList) {
			System.out.println(category);
		}
		System.out.println(categoryDAO.getCategoryById(3L));
		
		System.out.println("------------");
		
		INewsDAO iNewsDAO = new NewsDAOImpl();
		List<News> newsList = iNewsDAO.findAll();
		
		for (News news : newsList) {
			System.out.println(news);
		}
		
		Category c = new Category();
		c.setName("Học tập");
		c.setCode("hoc-tap");
		System.out.println(categoryDAO.deleteById(8L));
		
		News news = new News();
		news.setCategoryId(7L);
		news.setContent("Học sinh giỏi làm hư");
		news.setShortDescription("Học sinh giỏi năm nay tăng mạnh");
		news.setTitle("Học sinh giỏi title bà con ei");
		System.out.println(iNewsDAO.deleteById(5L));
		
	}
}
