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

@WebServlet("/NguyenManhHung_ProductCreate")
public class NguyenManhHung_ProductCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguyenManhHung_ProductCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/NguyenManhHung_ProductCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
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
		// Kiểm tra maSP ít nhất 1 ký tự là zA-Z_0-9]
		String regex = "\\w+";
		if (maSP == null || !maSP.matches(regex)) {
			errorString = "Product maSP invalid!";
		}

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/NguyenManhHung_ProductCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		Connection conn = null;
		try {
			conn = NguyenManhHung_Connection.getMSSQLConnection();
			NguyenManhHung_ProductUtils.insertProduct (conn, product);
			response.sendRedirect(request.getContextPath() + "/NguyenManhHung_ProductList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/NguyenManhHung_ProductCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
