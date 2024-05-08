package main;

import java.util.List;

import dao.ICategoryDAO;
import dao.INewsDAO;
import dao.impl.CategoryDAOImpl;
import dao.impl.NewsDAOImpl;
import model.Category;
import model.News;

public class Main {
	public static void main(String[] args) {
		ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
		
//		List<Category> results = iCategoryDAO.findAll();
//		for (Category category : results) {
//			System.out.println(category);
//		}
		
		System.out.println("------------");
		
		INewsDAO iNewsDAO = new NewsDAOImpl();
		
//		List<News> results2 = iNewsDAO.findAll();
//		for (News news : results2) {
//			System.out.println(news);
//		}
		
		
		Category c = new Category();
		c.setName("Dạy làm người");
		c.setCode("day-lam-nguoi");
		System.out.println(iCategoryDAO.insert(c));
		
		
		News news = new News();
		news.setShortDescription("Đời sống nay khó khăn quá");
		news.setContent("Làm sao để giàu trong đời sống khó khăn hiện nay");
		news.setCategoryId(3L);
		System.out.println(iNewsDAO.insert(news));
		
	}
}
