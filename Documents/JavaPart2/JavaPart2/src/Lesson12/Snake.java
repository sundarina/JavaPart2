package Lesson12;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.List;

import Lesson11.Products;

public class Snake implements WindowListener, KeyListener {
	static Frame f;
	static Panel p;
	static int x;
	static int x1 = 0;
	static int x2 = 20;
	static int x3 = 0;
	static int h = 20;
	static int h1 = 200;
	TextField lbl1;
	static int[][] Arr = new int[3][2];
	List lis = new List(4);
	List lis2 = new List(4);
	boolean t = false;
	int l = 0;
	int l1 = 0;
	static int u = Arr.length - 1;
	TextField textF;
	boolean textEntered = false;
	Button btnDone;

	public static void main(String[] args) {
		Snake snake = new Snake();
		snake.launch();
	}

	public Snake() {

		f = new Frame("Snake");

		p = new Panel() {

			int v = (int) (Math.random() * 255);
			int v1 = (int) (Math.random() * 255);
			int v2 = (int) (Math.random() * 255);
			Color r = new Color(v, v1, v2);

			public void paint(Graphics g) {

				// Dont't Touch ------------------------------
				t = false;

				g.setColor(Color.black);

				g.fillRect(0, 0, f.getWidth(), f.getHeight());

				g.setColor(Color.red);

				g.fillRect(h, h1, 20, 20);

				int a = 0;

				int a1 = 0;

				for (int i = 0; i < 100; i++) {

					g.drawLine(0, a1, f.getWidth(), a1);
					g.drawLine(a1, 0, a1, f.getHeight());
					a1 = a1 + 20;

				}

				// Ok You Can Touch Now ------------------------

				Arr[0][0] = Arr[0][0] + x2;
				Arr[0][1] = Arr[0][1] + x3;
				checkForTouch();

				for (int i = Arr.length - 1; i > 0; i--) {

					Arr[i][0] = Arr[i - 1][0];
					Arr[i][1] = Arr[i - 1][1];
					checkIfTouch(i);
					checkBounds(i);

				}

				for (int i = 0; i < Arr.length - 1; i++) {

					g.setColor(r);
					g.fillRect(Arr[i][0], Arr[i][1], 20, 20);

				}
				u--;
				if (u < 1) {
					u = Arr.length - 1;
				}

				for (int i = 0; i < Arr.length; i++) {
					System.out.print("[" + Arr[i][0] + "," + Arr[i][1] + "]");
					System.out.print(",");
				}
				System.out.println();
				System.out.println(Arr[u][0] + "," + Arr[u][1]);

				Wait(50);

				if (textEntered) {
					p.repaint();
				}

			};
		};
	}

	static String name;

	public void launch() {
		f.add(p);
		f.addWindowListener(this);
		f.addKeyListener(this);
		f.setSize(800, 750);

		Frame g = new Frame("Hi");
		g.setBackground(Color.GRAY);
		g.setVisible(true);
		g.setLayout(new GridLayout(2, 2));
		g.add(lis);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con;
		Statement st = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scores", "root", "");
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = st.executeQuery("select MAX(maxScore) as HighestmaxScore from scores");
			rs = st.executeQuery("SELECT * from scores ORDER BY maxScore DESC");
			for (int i = 0; rs.next(); i++) {
				lis.add(rs.getString("name"));
				lis2.add(rs.getString("maxScore"));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		textF = new TextField("Enter Name");
		textF.setBounds(0, 50, 100, 20);
		btnDone = new Button("Done");
		btnDone.setBounds(50, 50, 100, 20);

		btnDone.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				name = textF.getText();
				f.setVisible(true);
				textEntered = true;
				g.dispose();
				p.repaint();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		g.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent e) {
				g.dispose();
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		g.setSize(400, 400);
		g.add(lis2);
		g.add(btnDone);
		g.add(textF);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		if (key == 'w') {
			System.out.println("up");
			if (x3 == 0) {
				x3 = -20;
				x2 = 0;
			}

		}
		if (key == 'a') {
			System.out.println("left");
			if (x2 == 0) {
				x2 = -20;
				x3 = 0;
			}

		}
		if (key == 's') {
			System.out.println("down");
			if (x3 == 0) {
				x3 = 20;
				x2 = 0;
			}

		}
		if (key == 'd') {
			System.out.println("right");
			if (x2 == 0) {
				x3 = 0;
				x2 = 20;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con;
		Statement st = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scores", "root", "");
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean ben = true;
		ResultSet rs = null;
		try {
			rs = st.executeQuery("select name from scores");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			while (rs.next()) {
				if (rs.getString(1).equals(name)) {
					ben = false;
				}
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (ben) {
			try {
				st.execute("insert into scores(name,maxScore) values('" + name + "',0)");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			rs = st.executeQuery("select maxScore from scores where name ='" + name + "'");
			rs.next();
			if (rs.getInt(1) < Arr.length - 3) {
				st.execute("UPDATE scores SET maxscore=" + (Arr.length - 3) + " WHERE name = '" + name + "'");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Arr.length - 3);
		f.dispose();

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void checkBounds(int i) {

		if (Arr[0][1] > p.getHeight()) {
			Arr[0][1] = 0;
		} else if (Arr[0][1] < 0) {
			int b = p.getHeight();
			for (;;) {
				if (b % 20 != 0) {
					b++;
				} else {
					break;
				}
				Arr[0][1] = b;
			}
		}

		if (Arr[0][0] > p.getWidth()) {
			Arr[0][0] = 0;
		} else if (Arr[0][0] < 0) {
			int b = p.getWidth();
			for (;;) {
				if (b % 20 != 0) {
					b++;
				} else {
					break;
				}
			}
			Arr[0][0] = b;
		}
	}

	public static void checkIfTouch(int i) {
		if (Arr[Arr.length - 1][1] == h1 && Arr[Arr.length - 1][0] == h) {

			int[][] temp = new int[Arr.length + 1][2];
			System.out.println(Arr.length);
			int a = (int) (Math.random() * p.getWidth() / 20);

			int a1 = (int) (Math.random() * p.getHeight() / 20);

			h = a * 20;

			h1 = a1 * 20;

			for (int o = 0; o < Arr.length; o++) {
				temp[o][0] = Arr[o][0];
				temp[o][1] = Arr[o][1];

			}

			Arr = temp;
			Arr[Arr.length - 1][0] = Arr[Arr.length - 2][0] + x2;
			Arr[Arr.length - 1][1] = Arr[Arr.length - 2][1] + x3;

		}
	}

	public static void checkForTouch() {
		for (int j = 1; j < Arr.length - 1; j++) {
			if (Arr[0][0] == Arr[j][0] && Arr[0][1] == Arr[j][1]) {
				resetGame();
			}
		}
	}

	public static void Wait(long g) {
		int count = 0;

		try {
			// EVERYTHING INSIDE WHILE LOOP KEEPS EXECUTING AGAIN AND AGAIN
			// LOOP EXECUTES ONCE, THEN SLEEPS FOR A SECOND
			while (true) {
				// RAMDOM COUNTER BEING PRINTED

				// PUTS CURRENT THREAD TO SLEEP FOR SPECIFIED MILLISECONDS
				// 1000 MILLISECONDS=1 SECOND
				Thread.sleep(g);
				break;
			}
		} catch (InterruptedException e) {
			// CATCHES IF THE MAIN THREAD IS INTERRUPTED
			e.printStackTrace();
		}
	}

	public static void resetGame() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con;
		Statement st = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scores", "root", "");
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean ben = true;
		ResultSet rs = null;
		try {
			rs = st.executeQuery("select name from scores");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			while (rs.next()) {
				if (rs.getString(1).equals(name)) {
					ben = false;
				}
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (ben) {
			try {
				st.execute("insert into scores(name,maxScore) values('" + name + "',0)");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			rs = st.executeQuery("select maxScore from scores where name ='Arseniy'");
			rs.next();
			if (rs.getInt(1) < Arr.length - 3) {
				st.execute("UPDATE scores SET maxscore=" + (Arr.length - 3) + " WHERE name = 'Arseniy'");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Arr.length - 3);
		x = 0;
		x1 = 0;
		x2 = 20;
		x3 = 0;
		h = 20;
		h1 = 200;

		Arr = new int[3][2];

		boolean t = false;
		int l = 0;
		int l1 = 0;
		u = Arr.length - 1;
	}
}
