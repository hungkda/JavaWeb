package hung.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;

import hung.entity.Employee;
import hung.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public List<Employee> getAllEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Employee> list = session.createQuery("from Employee").list();		
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
	public Employee getEmployeeById(BigInteger id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Employee employee = (Employee)session.createQuery("from Employee where EMP_ID = :empId").setParameter("empId", id).uniqueResult();		
			session.getTransaction().commit();
			session.close();
			return employee;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Employee> list = session.createQuery("from Employee where EMP_NAME = :empName").setParameter("empName", name).list();		
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
	public boolean insertEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(employee);
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
	public boolean updateEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(employee);
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
	public boolean deleteEmployee(BigInteger id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Employee where EMP_ID = :empId").setParameter("empId", id).executeUpdate();
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