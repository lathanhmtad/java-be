package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dao.ICustomerDAO;
import com.model.Customer;
import com.utils.HibernateUtil;

public class CustomerDAOImpl implements ICustomerDAO {

	@Override
	public boolean insertCustomer(Customer customer) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();

			session.save(customer);

			tr.commit();

			session.close();
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomerById(Long id) {
		return null;
	}

	@Override
	public boolean checkEmailExists(String email) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

			String hql = "From Customer where email = :email";
			Query<Customer> query = session.createQuery(hql, Customer.class);

			query.setParameter("email", email);
			Customer result = (Customer) query.uniqueResult();

			session.close();

			// email exists
			if (result != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Customer isValidVerificationCode(String email, String code) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

			String hql = "FROM Customer where email = :email and verificationCode = :code ";
			Query<Customer> query = session.createQuery(hql, Customer.class);

			query.setParameter("email", email);
			query.setParameter("code", code);

			Customer result = (Customer) query.uniqueResult();

			// customer exists
			if (result != null) {
				result.setVerified(true);
				session.beginTransaction();
				session.update(result);
				session.getTransaction().commit();
				session.close();
				return result;
			}
		}
		return null;
	}

	@Override
	public Customer getCustomerByEmailAndPassword(String email, String password) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

			String hql = "FROM Customer where email = :email and password = :password ";
			Query<Customer> query = session.createQuery(hql, Customer.class);

			query.setParameter("email", email);
			query.setParameter("password", password);

			Customer result = (Customer) query.uniqueResult();

			// customer exists
			if (result != null) {
				return result;
			}
		}
		return null;
	}

}
