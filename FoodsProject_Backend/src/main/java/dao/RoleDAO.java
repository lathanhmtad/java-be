package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Role;
import util.HibernateUtils;

public class RoleDAO implements DAOInterface<Role> {

	@Override
	public boolean insert() {
		boolean flag = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if (sessionFactory != null) {
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();

				Role admin = new Role("admin", "Quản trị viên", "Người quản trị tối cao quản lý tất cả");
				Role user = new Role("user", "Người dùng", "Người lập tài khoản để mua hàng");
				Role seller = new Role("seller", "Người bán", "Người có quyền mua và đăng sản phẩm để bán");

				session.save(admin);
				session.save(user);
				session.save(seller);

				transaction.commit();
				flag = true;
			} catch (HibernateException e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
		return flag;
	}

	@Override
	public Role insert(Role o) {
		return null;
	}

	@Override
	public boolean update(Role o) {
		return false;
	}

	@Override
	public boolean delete(Role o) {
		return false;
	}

	@Override
	public Role getO(Role o) {
		Role role = null;

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if (sessionFactory != null) {
			Session session = null;
			Transaction tr = null;

			try {
				session = sessionFactory.openSession();
				tr = session.beginTransaction();

				role = session.get(Role.class, o.getId());

				tr.commit();
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
		return role;
	}

	@Override
	public List<Role> getAll() {
		return null;
	}

}
