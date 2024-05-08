package main;

import java.util.List;

import dao.ICategoryDAO;
import dao.INewsDAO;
import dao.IRoleDAO;
import dao.impl.CategoryDAOImpl;
import dao.impl.NewsDAOImpl;
import dao.impl.RoleDAOImpl;
import model.CategoryModel;
import model.NewsModel;
import model.RoleModel;

public class Main {
	public static void main(String[] args) {
		INewsDAO iNewsDAO = new NewsDAOImpl();

		List<NewsModel> listNews = iNewsDAO.findAll();

		for (NewsModel newsModel : listNews) {
			System.out.println(newsModel);
		}

		System.out.println("-------------");

		ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
		List<CategoryModel> listCategory = iCategoryDAO.findAll();
		for (CategoryModel cModel : listCategory) {
			System.out.println(cModel);
		}

		System.out.println("-------------");

		IRoleDAO iRoleDAO = new RoleDAOImpl();
		List<RoleModel> listRoleModel = iRoleDAO.findAll();
		for (RoleModel rModel : listRoleModel) {
			System.out.println(rModel);
		}
		
		System.out.println("-------------");

		System.out.println(iCategoryDAO.findCategoryByIdAndName(3L, "Đời sống"));
	}
}
