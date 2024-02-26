package nguyenmanhhung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nguyenmanhhung.conn.NguyenManhHung_Connection;
import nguyenmanhhung.utils.NguyenManhHung_ProductUtils;

import java.io.IOException;
import java.sql.Connection;


@WebServlet("/NguyenManhHung_ProductDelete")
public class NguyenManhHung_ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguyenManhHung_ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		String errorString = null;
		String maSP = (String)request.getParameter("maSP");
		try {
			conn = NguyenManhHung_Connection.getMSSQLConnection();
			NguyenManhHung_ProductUtils.deleteProduct(conn, maSP);
		}catch(Exception e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/NguyenManhHung_ProductDelete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/NguyenManhHung_ProductList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
