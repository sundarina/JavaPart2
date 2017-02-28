package Lesson11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mainProgram {

	public static void main() throws ClassNotFoundException, SQLException {
		Connection con = ProductDAO.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from products");

	}

}
