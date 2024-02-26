package nguyenmanhhung.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nguyenmanhhung.beans.NguyenManhHung_2110900052_Product;


public class NguyenManhHung_ProductUtils {
	//Đọc danh sách sản phẩm
		public static List<NguyenManhHung_2110900052_Product> queryProduct(Connection conn) throws SQLException {
			String sql = "Select a.MaSP_2110900052, a.TenSP_2110900052, a.SoLuong_2110900052, a.DonGia_2110900052, a.Anh_2110900052 from NguyenManhHung_2110900052_Product a ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<NguyenManhHung_2110900052_Product> list = new ArrayList<NguyenManhHung_2110900052_Product>();
			while (rs.next()) {
				String maSP = rs.getString("MaSP_2110900052");
				String tenSP = rs.getString("TenSP_2110900052");
				int soLuong = rs.getInt("SoLuong_2110900052");
				float donGia = rs.getFloat("DonGia_2110900052");
				String anh = rs.getString("Anh_2110900052");
				NguyenManhHung_2110900052_Product product = new NguyenManhHung_2110900052_Product(maSP, tenSP, soLuong, donGia, anh);
				list.add(product);
			}
			return list;
		}
		
		//Tìm kiếm theo mã sản phẩm
		public static NguyenManhHung_2110900052_Product findProduct (Connection conn, String maSP) throws SQLException {
				String sql = "Select a.MaSP_2110900052, a.TenSP_2110900052, a.SoLuong_2110900052, a.DonGia_2110900052, a.Anh_2110900052 from NguyenManhHung_2110900052_Product a where a.MaSP_2110900052=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, maSP);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					String tenSP = rs.getString("TenSP_2110900052");
					int soLuong = rs.getInt("SoLuong_2110900052");
					float donGia = rs.getFloat("DonGia_2110900052");
					String anh = rs.getString("Anh_2110900052");
					NguyenManhHung_2110900052_Product product = new NguyenManhHung_2110900052_Product(maSP, tenSP, soLuong, donGia, anh);
					return product;
				}
				return null;
			}
		
		//Thêm mới sản phẩm
		public static void insertProduct (Connection conn, NguyenManhHung_2110900052_Product product) throws SQLException {
			String sql = "Insert into NguyenManhHung_2110900052_Product (MaSP_2110900052, TenSP_2110900052, SoLuong_2110900052, DonGia_2110900052, Anh_2110900052) values (?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, product.getMaSP_2110900052());
			pstm.setString(2, product.getTenSP_2110900052());
			pstm.setInt(3, product.getSoLuong_2110900052());
			pstm.setFloat(4, product.getDonGia_2110900052());
			pstm.setString(5, product.getAnh_2110900052());
			pstm.executeUpdate();
		}
		
		//Cập nhật sản phẩm
		public static void updateProduct (Connection conn, NguyenManhHung_2110900052_Product product) throws SQLException {
			String sql = "Update NguyenManhHung_2110900052_Product set TenSP_2110900052 =?, SoLuong_2110900052 =?, DonGia_2110900052 =?, Anh_2110900052 =? where MaSP_2110900052=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(5, product.getMaSP_2110900052());
			pstm.setString(1, product.getTenSP_2110900052());
			pstm.setInt(2, product.getSoLuong_2110900052());
			pstm.setFloat(3, product.getDonGia_2110900052());
			pstm.setString(4, product.getAnh_2110900052());
			pstm.executeUpdate(); 
		}
		
		//Xóa một sản phẩm
		public static void deleteProduct (Connection conn, String code) throws SQLException {
			String sql = "Delete From NguyenManhHung_2110900052_Product where MaSP_2110900052= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, code);
			pstm.executeUpdate();
		}
}
