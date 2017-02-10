package Lesson6;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lesson6.Accessory;

public class boquetOutput extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		Accessory f = null;
		
		
		
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

	
	public boquetOutput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
