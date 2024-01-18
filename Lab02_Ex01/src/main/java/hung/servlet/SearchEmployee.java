package hung.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;
       
    
    public SearchEmployee() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter(); 

		out.println("<html><head><meta charset='UTF-8'><title>InputForm</title></head>");

		out.println("<body style='text-align:center'>");
		out.println("<h1> DEMO tra cứu bằng Servlet </h1>");
		out.println("<form action='SearchEmployee' method='post'>");

		out.println("<p> Input name: ");
		out.println("<input type=text name='emp_name'/>");
		
		out.println("<p> Input EMP_NO: ");
		out.println("<input type=text name='emp_no'/>");
		
		out.println("<p> Input salary: ");
		out.println("<input type=number name='salary'/>");
		
		out.println("<p> <input type='submit' value='Search' />");

		out.println("</form>");
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String sql = "Select * from Employee ";
			Connection conn = ConnectionUtils.getMSSQLConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<h2> Danh sách </h2>");
			out.println("<table border=1 align='center' style='width:50%'>");
			out.println("<tr><th>Id</th><th>Name</th><th>EMP_NO</th><th>Hire Date</th><th>Salary</th><th>DEPT_ID</th><tr>");
	
			if (rs != null) {
			while (rs.next()) { 
	
				out.println("<tr>");
				out.println("<td>" + rs.getString("EMP_ID") + "</td>");
		
				out.println("<td>" + rs.getString("EMP_NAME") + "</td>");
		
				out.println("<td>" + rs.getString("EMP_NO") + "</td>");
				
				out.println("<td>" + rs.getString("HIRE_DATE") + "</td>");
				
				out.println("<td>" + rs.getString("salary") + "</td>");
				
				out.println("<td>" + rs.getString("DEPT_ID") + "</td>");
		
				out.println("</tr>");
			}
		}
		rs.close();
		out.println("</table>");
		} catch (Exception ex) {
			out.println("<h1>" + ex.getMessage() + " </h1>");
			out.println("<p>" + ex.toString() + " </p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter(); 
		//lấy dữ liệu khi submit form từ UserAccount
		String emp_name = request.getParameter("emp_name");
		String emp_no = request.getParameter("emp_no");
		String salary = request.getParameter("salary");
		int check = 0;
		out.println("<html><head> <meta charset='UTF-8'><title>InputForm</title> </head>");
		out.println("<body style='text-align:center'>");
		out.println("<h1> KẾT QUẢ TÌM KIẾM </h1>");
		out.println("<form action='SearchEmployee' method='post'>");

		out.println("<p> Input name: ");
		out.println("<input type=text name='emp_name'/>");
		
		out.println("<p> Input EMP_NO: ");
		out.println("<input type=text name='emp_no'/>");
		
		out.println("<p> Input salary: ");
		out.println("<input type=number name='salary'/>");
		
		out.println("<p> <input type='submit' value='Search' />");

		out.println("</form>");

		try {
			String sql = "Select * from Employee";
			if (emp_name!=null && emp_name.length() !=0) {
				sql +=" WHERE EMP_NAME like '%" + emp_name + "%'";
				check ++;
			}
			
			if (emp_no!=null && emp_no.length() !=0 && check > 0){
				sql +=" AND EMP_NO like '%" + emp_no + "%'";
				check ++;
			}else if(emp_no!=null && emp_no.length() !=0) {
				sql +=" WHERE EMP_NO like '%" + emp_no + "%'";
				check ++;
			}
			
			if (salary!=null && salary.length() !=0 && check > 0){
				sql +=" AND Salary = '" + salary + "'";
				check ++;
			}else if(salary!=null && salary.length() !=0) {
				sql +=" WHERE Salary = '" + salary + "'";
				check ++;
			}
			Connection conn = ConnectionUtils.getMSSQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<h2> Danh sách</h2>");
			out.println("<table border=1 align='center' style='width:100%'>");
		
			out.println("<tr><th>Id</th><th>Name</th><th>EMP_NO</th><th>Hire Date</th><th>Salary</th><th>DEPT_ID</th><tr>");
			if (rs != null) {
			while (rs.next()) {
				//Đọc dữ liệu và hiển
				out.println("<tr>");
				out.println("<td>" + rs.getString("EMP_ID") + "</td>");
		
				out.println("<td>" + rs.getString("EMP_NAME") + "</td>");
		
				out.println("<td>" + rs.getString("EMP_NO") + "</td>");
				
				out.println("<td>" + rs.getString("HIRE_DATE") + "</td>");
				
				out.println("<td>" + rs.getString("salary") + "</td>");
				
				out.println("<td>" + rs.getString("DEPT_ID") + "</td>");
		
				out.println("</tr>");
				}
			}
			rs.close();
			out.println("</table>");
		}catch (Exception ex) {
			out.println("<h1>" + ex.getMessage() + "</h1>");
			out.println("<p>" + ex.toString() + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}