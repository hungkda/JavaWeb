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
 * Servlet implementation class CreateCustomerServlet
 */
@WebServlet("/createCustomer")
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createCustomer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String cusUser = (String) request.getParameter("cusUser");
		String cusPass = (String) request.getParameter("cusPass");
		String cusName = (String) request.getParameter("cusName");
		String cusPhone = (String) request.getParameter("cusPhone");
		String cusAdd = (String) request.getParameter("cusAdd");
		String cusEmail = (String) request.getParameter("cusEmail");
		String cusFacebook = (String) request.getParameter("cusFacebook");
		String cusSkyper = (String) request.getParameter("cusSkyper");
		String cusStatusStr = (String) request.getParameter("cusStatus");
		
		
		
		int cusStatus = 0;
		try {
			cusStatus = Integer.parseInt(cusStatusStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		Customer customer = new Customer(0, cusUser, cusPass, cusName, cusPhone, cusAdd, cusEmail, cusFacebook, cusSkyper, cusStatus);
		String regex = "\\w+";
		

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("customer", customer);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createCustomer.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			CustomerUtils.insertCustomer(conn, customer);
			response.sendRedirect(request.getContextPath() + "/listCustomer");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createCustomer.jsp");
			dispatcher.forward(request, response);
		}
	}

}
