package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.ICategoryDAO;
import com.model.Category;
import com.utils.HibernateUtil;

public class CategoryDAOImpl implements ICategoryDAO {

	@Override
	public List<Category> getAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

			List<Category> list = session.createQuery("FROM Category", Category.class).list();

			session.close();

			if (list != null) {
				return list;
			}
		}

		return null;
	}

	@Override
	public boolean insertCategory(Category c) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();

			session.save(c);

			tr.commit();
			session.close();
			
			return true;
		}

		return false;
	}

	@Override
	public Category getCategoryById(Long id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

			Category result = session.get(Category.class, id);

			session.close();
			
			if(result != null) {
				return result;
			}
		}

		return null;
	}

}
