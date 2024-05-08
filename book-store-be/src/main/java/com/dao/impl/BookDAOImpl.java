package com.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.IBookDAO;
import com.model.Book;
import com.utils.HibernateUtil;

public class BookDAOImpl implements IBookDAO {

	@Override
	public boolean insertBook(Book b) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();

			session.save(b);

			tr.commit();

			session.close();
			return true;
		}
		return false;
	}

	@Override
	public List<Book> getAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			try {
				Session session = sessionFactory.openSession();
				
				// trả về danh sách các đối tượng Book với mỗi Book được gán kèm danh sách các image của nó.
				List<Book> books = session.createQuery("SELECT distinct b FROM Book b left JOIN FETCH b.images", Book.class).list();

				session.close();
				if (books != null) {
					return books;
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
