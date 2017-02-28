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

	ArrayList<Product> products = new ArrayList();
	
	

	public void getIds() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id from products");
		int a = 0;
		while(rs.next()) {
			products.get(a).id = rs.getInt(a+1);
			System.out.println(products.get(a).id);
		}
	}

}
