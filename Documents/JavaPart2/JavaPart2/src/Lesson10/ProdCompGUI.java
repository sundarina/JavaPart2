package Lesson10;
//t
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdCompGUI extends JFrame {

	private JPanel contentPane;
	static ProdComp Production;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ProdCompGUI frame = new ProdCompGUI();
		frame.setVisible(true);

	}

	ResultSet rs;
	Object[][] strCont;
	int a = 0;
	JTable[] Table = new JTable[3];
	JScrollPane scrollPane;
	JScrollPane scrollPane1;
	JScrollPane scrollPane2;
	
	public ProdCompGUI() throws SQLException, ClassNotFoundException {
		  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("<-");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(a == 1) {
					
					scrollPane1.setVisible(false);
					Table[0].setVisible(true);
					scrollPane.setVisible(true);
					a = 0;
				} else if(a == 2) {
					scrollPane2.setVisible(false);
					Table[1].setVisible(true);
					scrollPane1.setVisible(true);
					a = 1;
				} 
			}
		});
		button.setBounds(5, 5, 75, 29);
		contentPane.add(button);
		
		
		JButton button_1 = new JButton("->");
		button_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(a == 0) {
					
					scrollPane.setVisible(false);
					Table[1].setVisible(true);
					scrollPane1.setVisible(true);
					a = 1;
				} else if(a == 1) {
					scrollPane1.setVisible(false);
					Table[2].setVisible(true);
					scrollPane2.setVisible(true);
					a = 2;
				} 
					
					
				
			}
		});
		
		button_1.setBounds(70, 5, 75, 29);
		contentPane.add(button_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 46, 439, 206);
		contentPane.add(scrollPane);
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(5, 46, 439, 206);
		contentPane.add(scrollPane1);
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(5, 46, 439, 206);
		contentPane.add(scrollPane2);
		
		scrollPane1.setVisible(false);
		
		scrollPane2.setVisible(false);
		

		ProdComp Production = new ProdComp();
		
		
		
		for(int i = 0; i < Table.length;i++) {
			Table[i] = new JTable();
		}
		
		updateTable1(Table[1]);
		scrollPane1.setViewportView(Table[1]);
		updateTable2(Table[2]);
		scrollPane2.setViewportView(Table[2]);
		

		updateTable(Table[0]);
		scrollPane.setViewportView(Table[0]);

	}
	public void addA() {
		a++;
	}
	public void updateTable(JTable table) throws SQLException {

		ResultSet rs = Production.st.executeQuery("select * from movies");
		int a = 0;
		while (rs.next()) {
			a++;
		}
		strCont = new Object[a][rs.getMetaData().getColumnCount()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			for (int j = 1;; j++) {
				try {
					String temp = rs.getString(j);
					strCont[i][j - 1] = temp;

				} catch (SQLException e) {

					break;
				}
			}
		}
		Object[] b = { "ID", "Name", "ActorID", "DirectorID", "Date", "Country" };
		System.out.println(strCont[0][0]);
		table = new JTable(strCont, b);
		
		
		Table[1].setVisible(false);
		Table[2].setVisible(false);
		Table[0] = table;
		
		
		

	}

	public void updateTable1(JTable table) throws SQLException {

		ResultSet rs = Production.st.executeQuery("select * from actors");
		int a = 0;
		while (rs.next()) {
			a++;
		}
		strCont = new Object[a][rs.getMetaData().getColumnCount()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			for (int j = 1;; j++) {
				try {
					String temp = rs.getString(j);
					strCont[i][j - 1] = temp;

				} catch (SQLException e) {

					break;
				}
			}
		}
		Object[] b = { "ID", "Name" };
		System.out.println(strCont[0][0]);
		table = new JTable(strCont, b);
		Table[0].setVisible(false);
		Table[2].setVisible(false);
		Table[1] = table;
		Table[1].setVisible(true);
		

	}

	public void updateTable2(JTable table) throws SQLException {

		ResultSet rs = Production.st.executeQuery("select * from directors");
		int a = 0;
		while (rs.next()) {
			a++;
		}
		strCont = new Object[a][rs.getMetaData().getColumnCount()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			for (int j = 1;; j++) {
				try {
					String temp = rs.getString(j);
					strCont[i][j - 1] = temp;

				} catch (SQLException e) {

					break;
				}
			}
		}
		Object[] b = { "ID", "Name" };
		System.out.println(strCont[0][0]);
		table = new JTable(strCont, b);
		Table[0].setVisible(false);
		Table[1].setVisible(false);
		Table[2] = table;
		

	}

}

