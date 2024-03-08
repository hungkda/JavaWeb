package hung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import hung.dao.CategoryDAOImpl;
import hung.entity.Category;

/**
 * Servlet implementation class CategoryEditServlet
 */
@WebServlet("/CategoryEdit")
public class CategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryEdit.jsp");
		String categoryIdStr = (String) request.getParameter("categoryId");
		if(categoryIdStr == null || categoryIdStr == "") {
			errorString="Bạn chưa chọn danh mục cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Category category = null;
		errorString = null;
		
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		try {
			category = new CategoryDAOImpl().getCategoryById(categoryId);
			if(category==null) {
				errorString="Không tìm thấy danh mục nào có mã" + categoryIdStr;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || category == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("category", category);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
		String categoryIdStr = (String) request.getParameter("categoryId");
		String categoryName = (String) request.getParameter("categoryName");
		
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		
		Category category = new Category(categoryId, categoryName);
// Kiểm tra code ít nhất 1 ký tự là zA-Z_0-9]
		String regex = "\\w+";
		if (categoryIdStr == null || !categoryIdStr.matches(regex)) {
			errorString = "Mã Category invalid!";
		}
		
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", category);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			boolean flag = new CategoryDAOImpl().updateCategory(category);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/CategoryList");
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", category);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}