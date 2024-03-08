package hung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import hung.dao.CategoryDAOImpl;
import hung.entity.Category;

/**
 * Servlet implementation class CategoryCreateServlet
 */
@WebServlet("/CategoryCreate")
public class CategoryCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null;
		List<Category> listD = null;
			
		listD = new CategoryDAOImpl().getAllCategory();
		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("categoryList", listD);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryCreate.jsp");
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
		String categoryName = (String) request.getParameter("categoryName");

		
		
		Category newCategory = new Category(categoryName);
		// Kiểm tra code ít nhất 1 ký tự là 0-9]
		

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", newCategory);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		try {
			boolean flag = new CategoryDAOImpl().insertCategory(newCategory);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/CategoryList");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}