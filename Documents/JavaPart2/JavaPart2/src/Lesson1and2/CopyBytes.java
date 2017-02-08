package Lesson1and2;

import java.io.*;

public class CopyBytes {
	public static void main(String[] args) throws IOException {
	//	FileInputStream in = null;
	//	FileOutputStream out = null;
		FileReader in=null;
		FileWriter out=null;
		try {
		//	in = new FileInputStream("res"+File.separator+"source.txt"); // ������� ���� �����
		//	out = new FileOutputStream("res"+File.separator+"target.txt");// ������� ���� ������
			in= new FileReader("res"+File.separator+"source.txt");
			out= new FileWriter("res"+File.separator+"target.txt");
			int c;
		//	int bytesAvailable = in.available();
		//	in.ready();
		//	System.out.println(bytesAvailable + " bytes");
			while ((c = in.read()) != -1) { // ������ � ������ �����
				out.write(c); // ������ � ���� ������
			}
			for (byte i = 0; i < 10; i++) {
				out.write(Integer.toString(i));
			}
		} finally { // ��������� ������ � ������ finally
			if (in != null) {
				in.close(); // ������� ���� �����
			}
			if (out != null) {
				out.close(); // ������� ���� ������
			}
		}
	}
}
