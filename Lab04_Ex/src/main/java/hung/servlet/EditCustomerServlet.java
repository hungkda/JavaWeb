package hung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import hung.beans.Customer;
import hung.conn.ConnectionUtils;
import hung.utils.CustomerUtils;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/editCustomer")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editCustomer.jsp");
		int Id = Integer.parseInt(request.getParameter("Id"));
		if(Id == 0) {
			errorString="Bạn chưa chọn customer cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		Customer customer = null;
		errorString = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			customer = CustomerUtils.findCustomer(conn, Id);
			if(customer==null) {
				errorString="Không tìm thấy customer có mã" + Id;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || customer == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("customer", customer);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
		String cusIDStr = (String) request.getParameter("cusID");
		String cusUser = (String) request.getParameter("cusUser");
		String cusPass = (String) request.getParameter("cusPass");
		String cusName = (String) request.getParameter("cusName");
		String cusPhone = (String) request.getParameter("cusPhone");
		String cusAdd = (String) request.getParameter("cusAdd");
		String cusEmail = (String) request.getParameter("cusEmail");
		String cusFacebook = (String) request.getParameter("cusFacebook");
		String cusSkyper = (String) request.getParameter("cusSkyper");
		String cusStatusStr = (String) request.getParameter("cusStatus");
		
		int cusID = 0;
		try {
			cusID = Integer.parseInt(cusIDStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		
		int cusStatus = 0;
		try {
			cusStatus = Integer.parseInt(cusStatusStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		Customer customer = new Customer(cusID, cusUser, cusPass, cusName, cusPhone, cusAdd, cusEmail, cusFacebook, cusSkyper, cusStatus);
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("customer", customer);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editCustomer.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			CustomerUtils.updateCustomer(conn, customer);
			response.sendRedirect(request.getContextPath() + "/listCustomer");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("customer", customer);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editCustomer.jsp");
			dispatcher.forward(request, response);
		}
	}

}
