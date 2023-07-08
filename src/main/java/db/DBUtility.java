package db;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtility {
		public static Connection openConnection() {
			Connection con = null;
			try {
				String user = "root";
				String pass = "";
				String dbName = "dbbook";
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName,
						user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		public static void main(String[] args) {
			 System.out.println(openConnection());
			 }
	}
