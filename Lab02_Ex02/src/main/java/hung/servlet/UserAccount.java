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


public class UserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;
       
    
    public UserAccount() {
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
		out.println("<h1> Đăng nhập </h1>");
		out.println("<form action='SearchAccount' method='post'>");

		out.println("<p> Tài khoản: ");
		out.println("<input type=text name='user'/>");
		out.println("<p> Mật khẩu: ");
		out.println("<input type=text name='pass'/>");
		out.println("<p> <input type='submit' value='Search' />");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
