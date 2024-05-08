package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.ICartDAO;
import com.model.Cart;
import com.utils.HibernateUtil;

public class CartDAOImpl implements ICartDAO {

	@Override
	public boolean save(Cart cart) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();

			session.save(cart);

			tr.commit();

			session.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Long id) {
		return false;
	}

	@Override
	public boolean update(Cart newCart) {
		return false;
	}

	@Override
	public List<Cart> getAllCarts() {
		return null;
	}

}
