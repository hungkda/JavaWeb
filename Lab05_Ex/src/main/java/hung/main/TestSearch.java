package hung.main;

import java.util.List;

import hung.dao.EmployeeDAOImpl;
import hung.entity.Employee;

public class TestSearch {
	public static void main(String[] args) {
		List<Employee> list = new EmployeeDAOImpl().getEmployeeByName("ADAMS");
		if(list == null)
			return;
		for(Employee item:list) {
			System.out.printf("\n%-10s",item.getEmpId());
			System.out.printf("%-15s",item.getEmpName());
			System.out.printf("%-15s",item.getEmpNo());
			System.out.printf("%-30s",item.getHireDate());
			System.out.printf("%-15s",item.getImage());
			System.out.printf("%-15s",item.getJob());
			System.out.printf("%-15.0f",item.getSalary());
			System.out.printf("%-15s",item.getDeptId());
			System.out.printf("%-15s",item.getMngId());
		}
	}
}
