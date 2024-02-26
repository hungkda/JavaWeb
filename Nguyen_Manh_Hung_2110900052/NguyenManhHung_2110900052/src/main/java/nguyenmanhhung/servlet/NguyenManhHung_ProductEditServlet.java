package nguyenmanhhung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nguyenmanhhung.beans.NguyenManhHung_2110900052_Product;
import nguyenmanhhung.conn.NguyenManhHung_Connection;
import nguyenmanhhung.utils.NguyenManhHung_ProductUtils;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/NguyenManhHung_ProductEdit")
public class NguyenManhHung_ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguyenManhHung_ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/NguyenManhHung_ProductEdit.jsp");
		String maSP = (String) request.getParameter("maSP");
		if(maSP == null || maSP == "") {
			errorString="Bạn chưa chọn sản phẩm cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		NguyenManhHung_2110900052_Product product = null;
		errorString = null;
		try {
			conn = NguyenManhHung_Connection.getMSSQLConnection();
			product = NguyenManhHung_ProductUtils.findProduct(conn, maSP);
			if(product==null) {
				errorString="Không tìm thấy sản phẩm có mã" + maSP;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || product == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
		String maSP = (String) request.getParameter("maSP_2110900052");
		String tenSP = (String) request.getParameter("tenSP_2110900052");
		String soLuongStr = (String) request.getParameter("soLuong_2110900052");
		String donGiaStr = (String) request.getParameter("donGia_2110900052");
		String anh = (String) request.getParameter("anh_2110900052");
		
		int soLuong = 0;
		float donGia = 0;
		
		try {
			soLuong = Integer.parseInt(soLuongStr);
			donGia = Float.parseFloat(donGiaStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		NguyenManhHung_2110900052_Product product = new NguyenManhHung_2110900052_Product(maSP, tenSP, soLuong, donGia, anh);
		
		
		if (errorString != null) {
request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/NguyenManhHung_ProductEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = NguyenManhHung_Connection.getMSSQLConnection();
			NguyenManhHung_ProductUtils.updateProduct(conn, product);
			response.sendRedirect(request.getContextPath() + "/NguyenManhHung_ProductList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/NguyenManhHung_ProductEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
