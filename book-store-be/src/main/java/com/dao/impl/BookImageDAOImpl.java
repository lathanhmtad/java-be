package com.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.IBookImageDAO;
import com.model.BookImage;
import com.utils.HibernateUtil;

public class BookImageDAOImpl implements IBookImageDAO {

	@Override
	public boolean insertBookImage(BookImage bImg) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {
			try {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				session.save(bImg);

				tr.commit();

				session.close();
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
