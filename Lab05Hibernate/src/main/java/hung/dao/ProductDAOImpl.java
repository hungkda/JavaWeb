package hung.dao;

import java.util.List;

import hung.entity.Product;
import hung.util.HibernateUtil;

import org.hibernate.Session;

public class ProductDAOImpl implements ProductDAO  {

	@Override
	public List<Product> getAllProduct() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Product> list = session.createQuery("from Product", Product.class).getResultList();
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
	public Product getProductById(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Product product = (Product)session.createQuery("from Product where MaSP = :maSp").setParameter("maSp", id).uniqueResult();		
			session.getTransaction().commit();
			session.close();
			return product;
		} catch (Exception ex) {
				ex.printStackTrace();
				session.close();
		}
		return null;

	}

	@Override
	public boolean insertProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(product);
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
	public boolean updateProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(product);
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
	public boolean deleteProduct(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Product where MaSP = :maSP").setParameter("maSP", id).executeUpdate();
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
