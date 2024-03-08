package hung.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;

import hung.entity.Category;
import hung.util.HibernateUtil;



public class CategoryDAOImpl implements CategoryDAO {
	@Override
	public List<Category> getAllCategory(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Category> list = session.createQuery("from Category", Category.class).getResultList();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;

	}

	@Override
	public Category getCategoryById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Category category = (Category)session.createQuery("from Category where CategoryId = :categoryId").setParameter("categoryId", id).uniqueResult();		
			session.getTransaction().commit();
			session.close();
			return category;
		} catch (Exception ex) {
				ex.printStackTrace();
				session.close();
		}
		return null;

	}

	@Override
	public boolean insertCategory(Category category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;

	}

	@Override
	public boolean updateCategory(Category category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;

	}

	@Override
	public boolean deleteCategory(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Category where CategoryId = :categoryId").setParameter("categoryId", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			if(res>0)
				return true;
				
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;

	}
}
