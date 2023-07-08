package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.BookDAOImpl;
import DAO.BookDAO;

import entity.Book;


/**
 * Servlet implementation class InsertBook
 */
@WebServlet("/InsertBook")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO BookDAO = new BookDAOImpl();
		Book stu = new Book();
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("fullName");
		String Code = request.getParameter("Code");
		String images = request.getParameter("images");
		Double price = Double.parseDouble(request.getParameter("price"));
		 stu.setname(name);
		 stu.setbook_code(Code);
		 stu.setimages(images);
		 stu.setprice(price);
		 if(BookDAO.InsertBook(stu)) {
		 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }else {
		 request.setAttribute("err", "Insert failed!");
		 request.getRequestDispatcher("InsertBook.jsp").forward(request
		, response);
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
