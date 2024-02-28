package hung.main;

import java.math.BigInteger;

import hung.dao.EmployeeDAOImpl;

public class TestDelete {
	public static void main(String[] args) {
			
			boolean flag = new EmployeeDAOImpl().deleteEmployee(new BigInteger("123"));
			if(flag==true) {
				System.out.println("Đã xóa sản phẩm có mã 123!");
			}else {
				System.out.println("Sảy ra lỗi khi xóa sản phẩm");
			}
	
	}

}
