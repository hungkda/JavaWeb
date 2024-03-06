package hung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import hung.dao.DepartmentDAOImlp;
import hung.entity.Department;

@WebServlet("/DepartmentCreate")
public class DepartmentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DepartmentCreate.jsp");
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
		String deptIdStr = (String) request.getParameter("deptId");
		String deptNo = (String) request.getParameter("deptNo");
		String deptName = (String) request.getParameter("deptName");
		String location = (String) request.getParameter("location");
		int deptId = 0;
		try {
			deptId = Integer.parseInt(deptIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		
		Department department = new Department(deptId, deptNo, deptName, location);
		// Kiểm tra code ít nhất 1 ký tự là 0-9]
		String regex = "\\d+";
		if (deptIdStr == null || !deptIdStr.matches(regex)) {
			errorString = "Mã Department phải là 1 số!";
		}

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("department", department);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DepartmentCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		try {
			boolean flag = new DepartmentDAOImlp().insertDepartment(department);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/DepartmentList");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DepartmentCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
