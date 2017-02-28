package Lesson01and02;

import java.io.*;

public class MainIOInt {

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			
			out = new FileOutputStream("source.txt");// ������� ���� ������
			for (int i = 0; i < 100; i++) {
				out.write(i);
			}
			out.flush();
			out.close(); // ������� ���� ������
			in = new FileInputStream("source.txt"); // ������� ���� �����
			int c;
			int bytesAvailable = in.available();
			System.out.println(bytesAvailable + " bytes");
			while ((c = in.read()) != -1) { // ������ � ������ �����
				System.out.println(c);
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
