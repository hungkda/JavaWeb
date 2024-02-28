package hung.main;

import java.math.BigInteger;
import java.util.Calendar;

import hung.dao.EmployeeDAOImpl;
import hung.entity.Employee;

public class TestUpdate {
	public static void main(String[] args) {
			
			Employee p = new EmployeeDAOImpl().getEmployeeById(new BigInteger("9999"));
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 1999);
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			
			p.setEmpId(new BigInteger("9999"));
			p.setEmpName("Yasu");
			p.setEmpNo("Y017");	
			p.setHireDate(cal.getTime());
			p.setImage(null);
			p.setJob("Joni");
			p.setSalary(999);
			p.setDeptId(9);
			p.setMngId(new BigInteger("9999"));
			boolean flag = new EmployeeDAOImpl().updateEmployee(p);
			if(flag==true) {
				System.out.println("Sửa đổi dữ liệu thành công!");
			}else {
				System.out.println("Sảy ra lỗi khi sửa sản phẩm");
			}
	}
}
