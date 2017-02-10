package Lesson6;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Lesson6.Accessory;
import java.awt.List;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class boquetOutput extends JFrame {
	JPanel panel = new JPanel();
	boolean b2 = false;
	private JPanel contentPane;
	private final Choice choice = new Choice();
	private final JList list = new JList();
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JList list_1 = new JList();
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JButton button_2 = new JButton("Add");
	JTextField Add1 = new JTextField("Enter Price\n\n");
	JToggleButton tglbtnIsThisFlower;
	private JTextField txtEnterName;
	Boquet[] b;
	JButton btnDone = new JButton("Done");
	JButton btnDone2 = new JButton("Done");
	JButton btnRemove = new JButton("Remove\n");
	JButton button_1 = new JButton("Remove\n");

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boquetOutput frame = new boquetOutput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boquetOutput() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("res" + File.separator + "Boquet"));
		b = (Boquet[]) in.readObject();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel, BorderLayout.CENTER);

		String[] temp1 = new String[b[0].flowerList.length];
		for (int i = 0; i < b[0].flowerList.length; i++) {
			temp1[i] = b[0].flowerList[i].name;
		}
		list.setListData(temp1);
		String[] temp2 = new String[b[0].accessoryList.length];

		for (int i = 0; i < b[0].accessoryList.length; i++) {
			temp2[i] = b[0].accessoryList[i].name;

		}
		list_1.setListData(temp2);

		for (int i = 0; i < b.length; i++) {
			choice.add(b[i].name);
		}
		panel.setLayout(null);
		choice.setBounds(10, 57, 122, 27);
		panel.add(choice);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				refreshList();
				refreshList2();
			}

		});

		choice.setBackground(new Color(211, 211, 211));
		choice.setForeground(Color.BLACK);
		choice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		scrollPane.setBounds(139, 6, 52, 128);

		panel.add(scrollPane);
		scrollPane.setViewportView(list);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedIndex() != -1) {
					String flowerPrice = Integer
							.toString(b[choice.getSelectedIndex()].flowerList[list.getSelectedIndex()].Price);
					lblNewLabel.setText(b[choice.getSelectedIndex()].flowerList[list.getSelectedIndex()].name
							+ " Price = " + flowerPrice);
				}
			}

		});

		list.setSelectedIndex(0);
		lblNewLabel_1.setBounds(267, 41, 152, 16);

		panel.add(lblNewLabel_1);
		lblNewLabel.setBounds(267, 84, 152, 16);
		panel.add(lblNewLabel);
		scrollPane_1.setBounds(207, 6, 52, 128);
		tglbtnIsThisFlower = new JToggleButton("This item is not in stock");
		panel.add(scrollPane_1);
		scrollPane_1.setViewportView(list_1);
		list_1.setSelectedIndex(0);

		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				b[choice.getSelectedIndex()].removeFlower(list.getSelectedIndex());
				refreshList();

			}
		});

		btnRemove.setBounds(101, 157, 94, 27);
		panel.add(btnRemove);

		JButton button = new JButton("Add");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Add1.setVisible(true);
				tglbtnIsThisFlower.setVisible(true);
				txtEnterName.setVisible(true);
				btnDone2.setVisible(true);
			}
		});
		button.setBounds(203, 133, 94, 27);
		panel.add(button);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				b[choice.getSelectedIndex()].removeAccessory(list_1.getSelectedIndex());
				refreshList2();

			}
		});

		button_1.setBounds(203, 157, 94, 27);
		panel.add(button_1);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add1.setVisible(true);
				tglbtnIsThisFlower.setVisible(true);
				txtEnterName.setVisible(true);
				btnDone.setVisible(true);
			}
		});
		button_2.setBounds(101, 133, 94, 27);
		txtEnterName = new JTextField("Enter Name");
		txtEnterName.setVisible(false);
		panel.add(button_2);
		Add1.setSize(84, 31);
		Add1.setLocation(10, 221);
		panel.add(Add1);

		tglbtnIsThisFlower.setVisible(false);
		tglbtnIsThisFlower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!b2) {
					tglbtnIsThisFlower.setText("This item is in stock");
					b2 = true;
				} else {
					b2 = false;
					tglbtnIsThisFlower.setText("This item is not in stock");

				}

			}

		});

		Add1.setVisible(false);
		tglbtnIsThisFlower.setBounds(4, 196, 191, 29);
		panel.add(tglbtnIsThisFlower);

		txtEnterName.setBounds(90, 221, 101, 31);
		panel.add(txtEnterName);
		txtEnterName.setColumns(10);
		btnDone2.setBounds(192, 196, 117, 56);
		btnDone2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String[] h = Add1.getText().split(" ");
				b[choice.getSelectedIndex()].addAccessory(Integer.parseInt(h[0]), b2, txtEnterName.getText());
				refreshList2();
				Add1.setVisible(false);
				tglbtnIsThisFlower.setVisible(false);
				txtEnterName.setVisible(false);
				btnDone2.setVisible(false);
			}
		});

		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String[] h = Add1.getText().split(" ");
				b[choice.getSelectedIndex()].addFlower(Integer.parseInt(h[0]), b2, txtEnterName.getText());
				refreshList();
				Add1.setVisible(false);
				tglbtnIsThisFlower.setVisible(false);
				txtEnterName.setVisible(false);
				btnDone.setVisible(false);
			}
		});
		btnDone.setVisible(false);
		btnDone.setBounds(192, 196, 117, 56);
		panel.add(btnDone);
		panel.add(btnDone2);

		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_1.getSelectedIndex() != -1) {
					String flowerPrice = Integer
							.toString(b[choice.getSelectedIndex()].accessoryList[list_1.getSelectedIndex()].Price);
					lblNewLabel_1.setText(b[choice.getSelectedIndex()].accessoryList[list_1.getSelectedIndex()].name
							+ " Price = " + flowerPrice);
				}
			}

		});

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		if (list_1.getSelectedIndex() != -1) {
			String flowerPrice = Integer
					.toString(b[choice.getSelectedIndex()].accessoryList[list_1.getSelectedIndex()].Price);
			lblNewLabel_1.setText(b[choice.getSelectedIndex()].accessoryList[list_1.getSelectedIndex()].name
					+ " Price = " + flowerPrice);
		}
		btnDone2.setVisible(false);
	}

	public void refreshList() {
		String[] temp = new String[b[choice.getSelectedIndex()].flowerList.length];
		for (int i = 0; i < b[choice.getSelectedIndex()].flowerList.length; i++) {

			temp[i] = b[choice.getSelectedIndex()].flowerList[i].name;

		}
		list.setListData(temp);
		list.setSelectedIndex(0);
	}

	public void refreshList2() {
		Accessory[] a = b[choice.getSelectedIndex()].accessoryList;
		String[] temp3 = new String[a.length];

		for (int i = 0; i < a.length; i++) {
			
			temp3[i] = a[i].name;

		}
		list_1.setListData(temp3);
		list_1.setSelectedIndex(0);
	}
}
