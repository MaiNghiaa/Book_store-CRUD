package DAO;

import java.util.List;
import java.util.Map;

import entity.Book;

public interface BookDAO {
	public List<Book> getAllBooks();
	 public boolean InsertBook(Book s);
	 public boolean deleteBook(int id);
	 public boolean UpdateBook(Book s);
	 public Book getBookById(int id);
	 public boolean saveUser(String username, String password);
	 public boolean validateLogin(String username, String password);
	 public int getTotalRecord();
	 public List<Book> getBookByOffsetAndPageSize(int offset, int pageSize);
}
