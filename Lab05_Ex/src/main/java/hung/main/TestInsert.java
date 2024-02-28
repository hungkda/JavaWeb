package hung.main;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import hung.dao.EmployeeDAOImpl;
import hung.entity.Employee;

public class TestInsert {
	public static void main(String[] args) {
		Employee p = new Employee();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		p.setEmpId(new BigInteger("9999"));
		p.setEmpName("Yasuo");
		p.setEmpNo("Y0175");	
		p.setHireDate(cal.getTime());
		p.setImage(null);
		p.setJob("Jonin");
		p.setSalary(9999);
		p.setDeptId(99);
		p.setMngId(null);
		
		boolean flag = new EmployeeDAOImpl().insertEmployee(p);
		if(flag==true) {
			System.out.println("Thêm mới thành công!");
		}else {
			System.out.println("Sảy ra lỗi thêm mới sản phẩm");
		}
	}
}
