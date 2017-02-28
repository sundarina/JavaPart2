package Lesson10;
import java.sql.*;
public class ProdComp {
	static Statement st;
	
	public ProdComp() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodComp","root","root");
		st = con.createStatement();
	}
	public static void printResultSet(ResultSet res) throws SQLException {
		
		for(int i = 1; res.next();)  {
			for(int j = 1; ;j++) {
				
				try {
					System.out.print(res.getString(j)+"	");
					
				} catch(SQLException e) {
					break;
				}
			}
			System.out.println();
	}
}

}
