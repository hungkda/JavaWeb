package hung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import hung.dao.DepartmentDAOImlp;
import hung.dao.EmployeeDAOImpl;
import hung.entity.Department;
import hung.entity.Employee;

/**
 * Servlet implementation class EmployeeEditServlet
 */
 @WebServlet("/EmployeeEdit")
public class EmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/EmployeeEdit.jsp");
		String empIdStr = (String) request.getParameter("empId");
		if(empIdStr == null || empIdStr == "") {
			errorString="Bạn chưa chọn nhân viên cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		
		// khai báo
		Employee employee = null;
		errorString = null;
		List<Department> listD = new DepartmentDAOImlp().getAllDepartment();
		List<Employee> listE = new EmployeeDAOImpl().getAllEmployee();
		
		BigInteger empId = new BigInteger("0");
		try {
			empId = new BigInteger(empIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		try {
			employee = new EmployeeDAOImpl().getEmployeeById(empId);
			if(employee==null) {
				errorString="Không tìm thấy phòng ban nào có mã" + empIdStr;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || employee == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("e", employee);
		request.setAttribute("departmentList", listD);
		request.setAttribute("employeeList", listE);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String empIdStr = (String) request.getParameter("empId");
		String empName = (String) request.getParameter("empName");
		String empNo = (String) request.getParameter("empNo");
		String departmentStr = (String) request.getParameter("department");
		String job = (String) request.getParameter("job");
		String salaryStr = (String) request.getParameter("salary");
		String employeeStr = (String) request.getParameter("employee");

		BigInteger empId = new BigInteger("0");
		int department = 0;
		float salary = 0;
		BigInteger employee = new BigInteger("0");
		try {
			department = Integer.parseInt(departmentStr);
			salary = Float.parseFloat(salaryStr);
			empId = new BigInteger(empIdStr);
			employee = new BigInteger(employeeStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		
		Department dept = new DepartmentDAOImlp().getDepartmentById(department);
		Employee emp = new EmployeeDAOImpl().getEmployeeById(employee);
		Calendar cal = Calendar.getInstance();
		Employee newEmployee = new Employee(empId, dept, emp, empName, empNo, cal.getTime(), job, salary);
		// Kiểm tra code ít nhất 1 ký tự là 0-9]
		String regex = "\\d+";
		if (empIdStr == null || !empIdStr.matches(regex)) {
			errorString = "Mã nhân viên phải là số invalid!";
		}

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("employee", newEmployee);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/EmployeeEdit.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		try {
			boolean flag = new EmployeeDAOImpl().updateEmployee(newEmployee);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/EmployeeList");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/EmployeeEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
