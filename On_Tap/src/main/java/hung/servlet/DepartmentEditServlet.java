package hung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import hung.dao.DepartmentDAOImpl;
import hung.entity.Department;


/**
 * Servlet implementation class productEditServlet
 */
@WebServlet("/DepartmentEdit")
public class DepartmentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentEditServlet() {
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DepartmentEdit.jsp");
		String deptIdStr = (String) request.getParameter("deptId");
		if(deptIdStr == null || deptIdStr == "") {
			errorString="Bạn chưa chọn phòng cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Department department = null;
		errorString = null;
		
		int deptId = 0;
		try {
			deptId = Integer.parseInt(deptIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		try {
			department = new DepartmentDAOImpl().getDepartmentById(deptId);
			if(department==null) {
				errorString="Không tìm thấy phòng ban nào có mã" + deptIdStr;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || department == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("department", department);
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
		// Kiểm tra code ít nhất 1 ký tự là zA-Z_0-9]
		String regex = "\\w+";
		if (deptIdStr == null || !deptIdStr.matches(regex)) {
			errorString = "Mã Department invalid!";
		}
		
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("department", department);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DepartmentEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			boolean flag = new DepartmentDAOImpl().updateDepartment(department);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/DepartmentList");
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("department", department);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DepartmentEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
