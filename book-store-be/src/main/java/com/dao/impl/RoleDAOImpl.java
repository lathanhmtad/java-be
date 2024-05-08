package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.IRoleDAO;
import com.model.Role;
import com.utils.HibernateUtil;

public class RoleDAOImpl implements IRoleDAO {

	@Override
	public boolean insertRole(Role role) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
			session.save(role);
			
			tr.commit();
			session.close();
			
			return true;
		}
		return false;
	}

}
