package hung.dao;

import java.util.List;

import org.hibernate.Session;

import hung.entity.Department;
import hung.entity.Employee;
import hung.util.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public List<Department> getAllDepartment() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Department> list = session.createQuery("from Department", Department.class).getResultList();
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
	public Department getDepartmentById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Department department = (Department)session.createQuery("from Department where DEPT_ID = :dept_id").setParameter("dept_id", id).uniqueResult();		
			session.getTransaction().commit();
			session.close();
			return department;
		} catch (Exception ex) {
				ex.printStackTrace();
				session.close();
		}
		return null;
	}

	@Override
	public boolean insertDepartment(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(department);
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
	public boolean updateDepartment(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(department);
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
	public boolean deleteDepartment(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Department where DEPT_ID = :dept_id").setParameter("dept_id", id).executeUpdate();
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
