package Lesson09;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	static ResultSet rs;
	static Statement st;
	static ArrayList g = new ArrayList();
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Database b = new Database("map","root",""); 
		
		
		
		

	}
	public static void addItem(String Name,int Population) throws SQLException {
		rs = st.executeQuery("select * from countries");
		rs.last();
		st.execute("INSERT INTO countries(id, name,population) values("+Integer.toString(rs.getInt(1)+1)+",'"+Name+"',"+Integer.toString(Population)+")");
	}

	public Database(String dataBaseName,String user,String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName,user,password);
		st = con.createStatement();
		rs = st.executeQuery("select * from countries");
		printResultSet(rs);
		 
		 
	}
	public static void printResultSet(ResultSet res) throws SQLException {
		g.removeAll(g);
		for(int i = 1; res.next();)  {
			for(int j = 1; ;j++) {
				
				try {
					System.out.print(res.getString(j)+"	");
					g.add(res.getString(j));
				} catch(SQLException e) {
					break;
				}
			}
			System.out.println();
	}
}
	}
