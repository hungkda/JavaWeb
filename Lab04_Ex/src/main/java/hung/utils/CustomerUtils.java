package hung.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hung.beans.Customer;

public class CustomerUtils {
	//Đọc danh sách customer
		public static List<Customer> queryCustomer(Connection conn) throws SQLException {
			String sql = "Select a.CusID, a.CusUser, a.CusPass, a.CusName, a.CusPhone, a.CusAdd,"
					+ " a.CusEmail, a.CusFacebook, a.CusSkyper, a.CusStatus from USER_ACCOUNT a ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				int cusID = rs.getInt("CusID");
				String cusUser = rs.getString("CusUser");
				String cusPass = rs.getString("CusPass");
				String cusName = rs.getString("CusName");
				String cusPhone = rs.getString("CusPhone");
				String cusAdd = rs.getString("CusAdd");
				String cusEmail = rs.getString("CusEmail");
				String cusFacebook = rs.getString("CusFacebook");
				String cusSkyper = rs.getString("CusSkyper");
				int cusStatus = rs.getInt("CusStatus");
				
				Customer customer = new Customer();
				
				customer.setCusId(cusID);
				customer.setCusUser(cusUser);
				customer.setCusPass(cusPass);
				customer.setCusName(cusName);
				customer.setCusPhone(cusPhone);
				customer.setCusAdd(cusAdd);
				customer.setCusEmail(cusEmail);
				customer.setCusFacebook(cusFacebook);
				customer.setCusSkyper(cusSkyper);
				customer.setCusStatus(cusStatus);
				
				list.add(customer);
			}
			return list;
		}
		
		//Tìm kiếm theo mã customer
			public static Customer findCustomer (Connection conn, int cusID) throws SQLException {
					String sql = "Select a.CusID, a.CusUser, a.CusPass, a.CusName, a.CusPhone, a.CusAdd, a.CusEmail, "
							+ "a.CusFacebook, a.CusSkyper, a.CusStatus from USER_ACCOUNT a where a.CusID=?";
					PreparedStatement pstm = conn.prepareStatement(sql);
					pstm.setInt(1, cusID);
					ResultSet rs = pstm.executeQuery();
					while (rs.next()) {
						String cusUser = rs.getString("CusUser");
						String cusPass = rs.getString("CusPass");
						String cusName = rs.getString("CusName");
						String cusPhone = rs.getString("CusPhone");
						String cusAdd = rs.getString("CusAdd");
						String cusEmail = rs.getString("CusEmail");
						String cusFacebook = rs.getString("CusFacebook");
						String cusSkyper = rs.getString("CusSkyper");
						int cusStatus = rs.getInt("CusStatus");
						
						Customer customer = new Customer(cusID, cusUser, cusPass, cusName, cusPhone, cusAdd, cusEmail, cusFacebook, cusSkyper, cusStatus);
						
						return customer;
					}
					return null;
				}
			
			//Tìm kiếm theo cusUser
			public static List<Customer> searchCustomer (Connection conn, String cusUser) throws SQLException {
					String sql = "Select a.CusID, a.CusUser, a.CusPass, a.CusName, a.CusPhone, a.CusAdd, a.CusEmail, "
							+ "a.CusFacebook, a.CusSkyper, a.CusStatus from USER_ACCOUNT a where a.CusUser like '%" + cusUser + "%'";
					PreparedStatement pstm = conn.prepareStatement(sql);
					ResultSet rs = pstm.executeQuery();
					List<Customer> list = new ArrayList<Customer>();
					while (rs.next()) {
						int cusID = rs.getInt("CusID");
						String cusUserStr = rs.getString("CusUser");
						String cusPass = rs.getString("CusPass");
						String cusName = rs.getString("CusName");
						String cusPhone = rs.getString("CusPhone");
						String cusAdd = rs.getString("CusAdd");
						String cusEmail = rs.getString("CusEmail");
						String cusFacebook = rs.getString("CusFacebook");
						String cusSkyper = rs.getString("CusSkyper");
						int cusStatus = rs.getInt("CusStatus");
						
						Customer customer = new Customer(cusID, cusUserStr, cusPass, cusName, cusPhone, cusAdd, cusEmail, cusFacebook, cusSkyper, cusStatus);
						
						list.add(customer);
					}
					return list;
				}
			
		//Thêm mới customer
		public static void insertCustomer (Connection conn, Customer customer) throws SQLException {
			String sql = "Insert into USER_ACCOUNT (CusUser, CusPass, CusName, CusPhone,"
					+ " CusAdd, CusEmail, CusFacebook, CusSkyper, CusStatus) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, customer.getCusUser());
			pstm.setString(2, customer.getCusPass());
			pstm.setString(3, customer.getCusName());
			pstm.setString(4, customer.getCusPhone());
			pstm.setString(5, customer.getCusAdd());
			pstm.setString(6, customer.getCusEmail());
			pstm.setString(7, customer.getCusFacebook());
			pstm.setString(8, customer.getCusSkyper());
			pstm.setInt(9, customer.getCusStatus());
			
			pstm.executeUpdate();
		}
		
		//Cập nhật customer
		public static void updateCustomer (Connection conn, Customer customer) throws SQLException {
			String sql = "Update USER_ACCOUNT set CusUser =?, CusPass =?, CusName =?, CusPhone =?, CusAdd =?, "
					+ "CusEmail =?, CusFacebook =?, CusSkyper =?, CusStatus =? where CusID=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(10, customer.getCusId());
			pstm.setString(1, customer.getCusUser());
			pstm.setString(2, customer.getCusPass());
			pstm.setString(3, customer.getCusName());
			pstm.setString(4, customer.getCusPhone());
			pstm.setString(5, customer.getCusAdd());
			pstm.setString(6, customer.getCusEmail());
			pstm.setString(7, customer.getCusFacebook());
			pstm.setString(8, customer.getCusSkyper());
			pstm.setInt(9, customer.getCusStatus());
			
			pstm.executeUpdate(); 
		}
		
		//Xóa một customer
		public static void deleteCustomer (Connection conn, int cusID) throws SQLException {
			String sql = "Delete From USER_ACCOUNT where CusID= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cusID);
			pstm.executeUpdate();
		}
}
