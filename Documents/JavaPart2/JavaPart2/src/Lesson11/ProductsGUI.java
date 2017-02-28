package Lesson11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	ProductDAO store;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProductDAO store = new ProductDAO();
		for (int i = 0; i < store.products.size(); i++) {
			System.out.println(store.products.get(i).id);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductsGUI frame = new ProductsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductsGUI() throws ClassNotFoundException, SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 46, 46, 14);
		contentPane.add(lblId);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 71, 46, 14);
		contentPane.add(lblName);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(10, 96, 46, 14);
		contentPane.add(lblRate);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 121, 46, 14);
		contentPane.add(lblQuantity);

		Choice choice = new Choice();
		Connection con = store.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id from products");
		int a = 1;
		while (a <= store.products.size()) {
			choice.add(Integer.toString(a));
			a++;
		}
		a = choice.getSelectedIndex();
		
		
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int a = choice.getSelectedIndex();
		    	textField.setText(Integer.toString(store.products.get(a).id));
		    	textField_1.setText(store.products.get(a).name);
		    	textField_2.setText(Float.toString(store.products.get(a).rating));
		    	textField_3.setText(Integer.toString(store.products.get(a).quantity));
			}
		});
		
		choice.setBounds(62, 17, 167, 20);
		contentPane.add(choice);

		JLabel lblSelection = new JLabel("Selection");
		lblSelection.setBounds(10, 23, 46, 14);
		contentPane.add(lblSelection);

		textField = new JTextField();
		textField.setBounds(96, 43, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 68, 102, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 93, 102, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 118, 102, 20);
		contentPane.add(textField_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				choice.add(Integer.toString((Integer.parseInt(choice.get()))));
			}
		});
		btnAdd.setBounds(10, 170, 89, 23);
		contentPane.add(btnAdd);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(10, 204, 89, 23);
		contentPane.add(btnClear);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(109, 170, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(109, 204, 89, 23);
		contentPane.add(btnDelete);
		textField.setText(Integer.toString(store.products.get(a).id));
    	textField_1.setText(store.products.get(a).name);
    	textField_2.setText(Float.toString(store.products.get(a).rating));
    	textField_3.setText(Integer.toString(store.products.get(a).quantity));
	}
}
