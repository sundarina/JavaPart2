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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.TransformerException;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

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

	int amount;

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
		lblQuantity.setBounds(10, 121, 60, 14);
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
		amount = a - 1;
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

		choice.setBounds(80, 12, 167, 30);
		contentPane.add(choice);

		JLabel lblSelection = new JLabel("Selection");
		lblSelection.setBounds(10, 23, 59, 14);
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
				choice.add(Integer.toString(++amount));
				store.products.add(new Products(amount, null, 0, 0));
			}
		});
		btnAdd.setBounds(10, 170, 89, 30);
		contentPane.add(btnAdd);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(10, 204, 89, 30);
		contentPane.add(btnClear);

		JButton btnUpdate = new JButton("Save");
		btnUpdate.setBounds(95, 170, 89, 30);
		contentPane.add(btnUpdate);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				try {
					SendToXml f = new SendToXml(store);
				} catch (ClassNotFoundException | TransformerException | SQLException
						| ParserConfigurationException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				for (int i = 0; i < choice.countItems(); i++) {
					store.products.get(choice.getSelectedIndex()).id = Integer.parseInt(textField.getText());
					store.products.get(choice.getSelectedIndex()).name = textField_1.getText();
					store.products.get(choice.getSelectedIndex()).rating = Float.parseFloat(textField_2.getText());
					store.products.get(choice.getSelectedIndex()).quantity = Integer.parseInt(textField_3.getText());
				}
				try {
					st.execute("drop table products");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				try {
					st.execute("create Table products(id int,name varchar(100),rate float,quantity integer)");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < store.products.size(); i++) {
					try {
						String s[] = { Integer.toString(store.products.get(i).id), store.products.get(i).name,
								Float.toString(store.products.get(i).rating),
								Integer.toString(store.products.get(i).quantity) };

						st.execute("insert into products(id,name,rate,quantity) values(" + s[0] + ",'" + s[1] + "',"
								+ s[2] + "," + s[3] + ")");

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

			private void SendToXml(ProductDAO store) {
				// TODO Auto-generated method stub

			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(95, 204, 89, 30);
		contentPane.add(btnDelete);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseReleased(MouseEvent e) {
				if (choice.countItems() != 1) {
					store.products.remove(choice.getSelectedIndex());
					choice.remove(choice.getSelectedItem());
					int b = choice.getSelectedIndex();
					textField.setText(Integer.toString(store.products.get(b).id));
					textField_1.setText(store.products.get(b).name);
					textField_2.setText(Float.toString(store.products.get(b).rating));
					textField_3.setText(Integer.toString(store.products.get(b).quantity));
				}
			}
		});
		try {
			textField.setText(Integer.toString(store.products.get(0).id));
			textField_1.setText(store.products.get(0).name);
			textField_2.setText(Float.toString(store.products.get(0).rating));
			textField_3.setText(Integer.toString(store.products.get(0).quantity));
		} catch (IndexOutOfBoundsException e) {
			store.products.add(new Products(0, null, 0, 0));
			textField.setText(Integer.toString(store.products.get(0).id));
			textField_1.setText(store.products.get(0).name);
			textField_2.setText(Float.toString(store.products.get(0).rating));
			textField_3.setText(Integer.toString(store.products.get(0).quantity));

		}
	}
}
