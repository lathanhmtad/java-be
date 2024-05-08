package test;

import org.hibernate.SessionFactory;

import model.User;
import dao.RoleDAO;
import dao.UserDAO;
import model.Role;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//		System.out.println(sessionFactory);
		
//		RoleDAO roleDAO = new RoleDAO();
//		roleDAO.insert();
		
		
//		User us = new User();
//		us.setEmail("d0763705638@gmail.com");
//		us.setFullName("Duy");
//		
		UserDAO uDAO = new UserDAO();
		uDAO.insert();
//		us = uDAO.insert(us);
//		System.out.println(us);
	}
}
