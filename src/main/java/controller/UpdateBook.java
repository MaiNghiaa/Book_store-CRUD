package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import DAO.BookDAOImpl;

import java.util.List;
import entity.Book;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("fullName");
		String Code = request.getParameter("Code");
		String images = request.getParameter("images");
		Double price = Double.parseDouble(request.getParameter("price"));
		Book stu = new Book();
		stu.setid(id);
		stu.setname(name);
		 stu.setbook_code(Code);
		 stu.setimages(images);
		 stu.setprice(price);
		 boolean bl = new BookDAOImpl().UpdateBook(stu);
		 if(bl) {
			 request.setAttribute("success", "Sua thanh cong!");
			 }else {
			 request.setAttribute("err", "Co loi Co loi!");
			 request.setAttribute("s", stu); 
			 request.getRequestDispatcher("UpdateBook.jsp").forward(request
			, response);

			 }
			 
			 List<Book> allBooks = new BookDAOImpl().getAllBooks();
			 request.setAttribute("list", allBooks);
			 
			 request.getRequestDispatcher("ListBook.jsp").forward(request, response);
			 }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
