package hung.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner; 	

public class UpdateData {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {
			// Tạo kết nối
			Connection connection =ConnectionUtils.getMySQLConnection();

			// Tạo truy vấn cập nhật
			String sql = "UPDATE product"
			+ " SET ProName = ?," //
			+ " ProQty = ?," // pstm.setInt(2,150);
			+ " ProPrice =? "
			+ " WHERE ProID = ? ";
			
			PreparedStatement pstm = connection.prepareStatement(sql);
			// gán giá trị cho các biến tham số
			pstm.setInt(4, 4);
			pstm.setString(1,"HP");
			pstm.setInt(2, 150);
			pstm.setFloat(3, 2500);
			// Thực thi câu lệnh truy vấn
			int rowCount = pstm.executeUpdate();
			System.out.println("Đã cập nhật bản ghi: " +rowCount);
	}
}
