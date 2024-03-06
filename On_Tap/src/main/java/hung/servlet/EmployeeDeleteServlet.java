package hung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

import hung.dao.DepartmentDAOImlp;
import hung.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class EmployeeDeleteServlet
 */
@WebServlet("/EmployeeDelete")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorString = null;
		String empIdStr = (String) request.getParameter("empId");
		
		BigInteger empId = new BigInteger("0");
		try {
			empId = new BigInteger(empIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}

		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/EmployeeDelete.jsp");
			dispatcher.forward(request, response);
		}else {
			
			boolean flag = new EmployeeDAOImpl().deleteEmployee(empId);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/EmployeeList");
			}
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
