package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Role;
import model.User;
import util.HibernateUtils;

public class UserDAO implements DAOInterface<User> {

	@Override
	public boolean insert() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if (sessionFactory != null) {
			Session session = null;
			Transaction tr = null;
			try {
				session = sessionFactory.openSession();
				tr = session.beginTransaction();

				RoleDAO roleDAO = new RoleDAO();
				Role adminRole = new Role();
				adminRole.setId("admin"); 
				adminRole = roleDAO.getO(adminRole); // get full data
				
				User us = new User();
				us.setFullName("Nguyễn Đăng Duy");
				us.setEmail("admin@gmail.com");
				us.setCreateAt(new Date(System.currentTimeMillis()));
				us.setRole(adminRole);
				
				session.save(us);
				tr.commit();

				return true;
			} catch (HibernateException e) {
				if (tr != null) {
					tr.rollback();
				}
				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
		return false;
	}

	@Override
	public User insert(User o) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if (sessionFactory != null) {
			Session session = null;
			Transaction tr = null;

			try {
				session = sessionFactory.openSession();
				tr = session.beginTransaction();

				session.save(o);

				tr.commit();

				int oId = o.getId();

				o = session.get(User.class, oId);

				return o;
			} catch (HibernateException e) {
				if (tr != null) {
					tr.rollback();
				}
				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(User o) {
		return false;
	}

	@Override
	public boolean delete(User o) {
		return false;
	}

	@Override
	public User getO(User o) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

}
