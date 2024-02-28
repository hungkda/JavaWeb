package hung.dao;

import java.math.BigInteger;
import java.util.List;

import hung.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(BigInteger id);
	public List<Employee> getEmployeeByName(String name);
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(BigInteger id);
}

