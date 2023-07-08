package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import DAO.BookDAOImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO BookDAO = new BookDAOImpl();
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Kiểm tra thông tin đăng nhập trong cơ sở dữ liệu
	        if (BookDAO.validateLogin(username, password)) {
	        	HttpSession session = request.getSession();
	            session.setAttribute("username", username);
	            response.sendRedirect("index.jsp"); // Chuyển hướng đến trang index
	        } else {
	            response.sendRedirect("Login.jsp?error=true"); // Chuyển hướng về trang đăng nhập với thông báo lỗi
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
