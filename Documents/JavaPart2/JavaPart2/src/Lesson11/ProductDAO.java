package Lesson11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

public class ProductDAO {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");
		Statement st = con.createStatement();
		try {
			st.executeUpdate("create Table products(id int,name varchar(100),rate float,quantity integer)");
		} catch (MySQLSyntaxErrorException e) {

		}

		return con;

	}

	static ArrayList<Products> products = new ArrayList();

	public ProductDAO() throws ClassNotFoundException, SQLException {
		update();
	}

	public static void getIds() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id from products");
		int a = 0;
		while (rs.next()) {
			try {
				products.get(a).id = rs.getInt(a + 1);
			} catch (IndexOutOfBoundsException e) {
				products.add(new Products(0, null, 0, 0));
				products.get(a).id = rs.getInt(a + 1);
			}
			//System.out.println(products.get(a).id);
			a++;
		}
	}

	public static void getNames() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select name from products");
		int a = 0;
		while (rs.next()) {
			try {
				products.get(a).name = rs.getString(a + 1);
			} catch (IndexOutOfBoundsException e) {
				products.add(new Products(0, null, 0, 0));
				products.get(a).name = rs.getString(a + 1);
			}
			//System.out.println(products.get(a).name);
			a++;
		}
	}
	
	public static void getRates() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select rate from products");
		int a = 0;
		while (rs.next()) {
			try {
				products.get(a).rating = rs.getFloat(a + 1);
			} catch (IndexOutOfBoundsException e) {
				products.add(new Products(0, null, 0, 0));
				products.get(a).rating = rs.getFloat(a + 1);
			}
			//System.out.println(products.get(a).rating);
			a++;
		}
	}
	public static void getQuantity() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select quantity from products");
		int a = 0;
		while (rs.next()) {
			try {
				products.get(a).quantity= rs.getInt(a + 1);
			} catch (IndexOutOfBoundsException e) {
				products.add(new Products(0, null, 0, 0));
				products.get(a).quantity= rs.getInt(a + 1);
			}
			//System.out.println(products.get(a).quantity);
			a++;
		}
	}
	public static void update() throws ClassNotFoundException, SQLException {
		ProductDAO.getIds();
		ProductDAO.getNames();
		ProductDAO.getRates();
		ProductDAO.getQuantity();
	}


}
