package entity;

public class Book {
	private int id;
	private String name;
	private String book_code;
	private String images;
	private Double price;
	
	public Book() {
	super();
	}
	public Book(int id, String name,String book_code, String images,Double price) {
		 super();
		 this.id = id;
		 this.name = name;
		 this.book_code = book_code;
		 this.images = images;
		 this.price = price;
		 }
		 public int getid() {
		 return id;
		 }
		 public void setid(int id) {
		 this.id = id;
		 }
		 public String getname() {
		 return name;
		 }
		 public void setname(String name) {
		 this.name = name;
		 }
		 public String getbook_code() {
		 return book_code;
		 }
		 public void setbook_code(String book_code) {
		 this.book_code = book_code;
		 }
		 public String getimages() {
		 return images;
		 }
		 public void setimages(String images) {
		 this.images = images;
		 }
		 public Double getprice() {
		 return price;
		 }
		 public void setprice(Double price) {
		 this.price = price;
		 }
		}