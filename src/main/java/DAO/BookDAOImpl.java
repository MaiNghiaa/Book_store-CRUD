package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DBUtility;
import entity.Book;

public class BookDAOImpl implements BookDAO{
	
	@Override
	public boolean validateLogin(String username, String password) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBUtility.openConnection();
            pstmt = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            return rs.next(); // Trả về true nếu có bản ghi tồn tại, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public int getTotalRecord() {
		int total = 0;
		Connection con = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("SELECT COUNT(*) as total from book");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt("total");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}
	
	public List<Book> getBookByOffsetAndPageSize(int offset, int pageSize) {
		List<Book> result = new ArrayList<Book>();
		Connection con = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("select * from Book limit ?, ?");
			pstmt.setInt(1, offset * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book s = new Book();
				s.setid(rs.getInt("id"));
				s.setname(rs.getString("name"));
				s.setimages(rs.getString("images"));
				s.setprice(rs.getDouble("price"));
				s.setbook_code(rs.getString("book_code"));
				result.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@Override
	public boolean saveUser(String username, String password) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBUtility.openConnection();
            pstmt = con.prepareStatement("INSERT INTO user (username, password) VALUES (?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int rowsAffected = pstmt.executeUpdate();
            return (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng PreparedStatement và Connection
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	@Override
	 public Book getBookById(int id) {
	 Book s = null;
	 
	 Connection con;
	 PreparedStatement pstmt;
	 ResultSet rs;
	 con = DBUtility.openConnection();
	 try {
	 pstmt = con.prepareStatement("select * from book where id = ?");
	 pstmt.setInt(1, id);
	 
	 rs = pstmt.executeQuery();
	 
	 if(rs.next()) {
	 s = new Book();
	 	int id1 =rs.getInt("id");
		String name = rs.getString("name");
		String Code = rs.getString("book_code");
		String images = rs.getString("images");
		Double price = rs.getDouble("price");
	 s.setid(id1);
	 s.setname(name);
	 s.setbook_code(Code);
	 s.setimages(images);
	 s.setprice(price);
	 }
	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 
	 return s;
	 }
	@Override
	public List<Book> getAllBooks() {
	    List<Book> list = new ArrayList<Book>();
	    int count = 0; // Biến đếm số lượng bản ghi

	    Connection con;
	    PreparedStatement pstmt;
	    ResultSet rs;

	    con = DBUtility.openConnection();
	    try {
	        pstmt = con.prepareStatement("SELECT * FROM book");

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Book s = new Book();
	            s.setid(rs.getInt("id"));
	            s.setname(rs.getString("name"));
	            s.setbook_code(rs.getString("book_code"));
	            s.setimages(rs.getString("images"));
	            s.setprice(rs.getDouble("price"));
	            list.add(s);
	            count++; // Tăng biến đếm sau mỗi bản ghi được thêm vào danh sách
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Thêm một đối tượng Book chứa số lượng bản ghi vào danh sách
	    Book countBook = new Book();
	    countBook.setid(count);
	    list.add(countBook);

	    return list;
	}
	@Override
	public boolean InsertBook(Book s) {
		boolean bl = false;
		 
		 Connection con;
		 PreparedStatement pstmt;
		 ResultSet rs;
		 
		 con = DBUtility.openConnection();
		 try {
		 pstmt = con.prepareStatement("INSERT INTO `book` (`name`, `book_code`, `images`, `price`) values (?,?,?,?)");
		 pstmt.setString(1, s.getname());
		 pstmt.setString(2, s.getbook_code());
		 pstmt.setString(3, s.getimages());
		 pstmt.setDouble(4, s.getprice());
		 int i = pstmt.executeUpdate();
		 if(i>0) {
			 bl = true;
			 }
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 
			 return bl;
	}

	@Override
	 public boolean deleteBook(int id) {
	 boolean bl = false;
	 
	 Connection con;
	 PreparedStatement pstmt;
	 ResultSet rs;
	 
	 con = DBUtility.openConnection();
	 try {
	 pstmt = con.prepareStatement("delete from book where id=?");
	 
	 pstmt.setInt(1, id);
	 
	 int i = pstmt.executeUpdate();
	 if(i>0) {
	 bl = true;
	 }
	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 
	 return bl;
	}
	
	@Override
	public boolean UpdateBook(Book s) {
	    boolean bl = false;

	    Connection con;
	    PreparedStatement pstmt;
	    ResultSet rs;

	    con = DBUtility.openConnection();
	    try {
	        pstmt = con.prepareStatement("UPDATE `book` SET `name`=?, `book_code`=?, `images`=?, `price`=? WHERE `book`.`id` = ?");
	        pstmt.setString(1, s.getname());
	        pstmt.setString(2, s.getbook_code());
	        pstmt.setString(3, s.getimages());
	        pstmt.setDouble(4, s.getprice());
	        pstmt.setInt(5, s.getid());
	        int i = pstmt.executeUpdate();
	        if (i > 0) {
	            bl = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return bl;
	}
	}
