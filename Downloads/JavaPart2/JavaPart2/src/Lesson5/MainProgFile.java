package Lesson5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

import Lesson1and2.CPoint;
class MyExeption extends Exception{
	public MyExeption() {
		// TODO Auto-generated constructor stub
	}

	public MyExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyExeption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyExeption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
public class MainProgFile implements Serializable {
	static void openfile1() {
		File file = new File("res" + File.separator + "inputFile.info");
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			return;
		} finally {
			try {
				if (fin != null)
					fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static void openfile2() {
		File file =null;
				//new File("res" + File.separator + "inputFile.info");
		JFileChooser jf= new JFileChooser();
		jf.showOpenDialog(null);
		file= jf.getSelectedFile();
		System.out.println(file);
		System.out.println("file ="+file.length());
		DataInputStream dataIn=null;
		try(FileInputStream fin = new FileInputStream(file);) {
			dataIn= new DataInputStream(fin);			 
			System.out.println("data ="+ dataIn.available());
			while (dataIn.available()>0)
			{
			System.out.println("data ="+ dataIn.available());
		    String stPoint=dataIn.readLine();
		    String [] attribPoint= stPoint.split(" ");
		    int x= Integer.parseInt(attribPoint[0]);
		    if(x>10000) throw new MyExeption();
		    int y= Integer.parseInt(attribPoint[1]);
		    CPoint point = new CPoint(x,y);
		   System.out.println(point); 
		   String allstr= point.getX()+" "+point.getY();
		   jf.showDialog(null,"Save");
		   File fileSave= jf.getSelectedFile();
		   DataOutputStream dataSave= new DataOutputStream(new FileOutputStream(fileSave));
		   dataSave.writeBytes(allstr);
		   dataSave.close();
		    }
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			return;
		
		} 
		catch (MyExeption e) {
			
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void openFile3() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objRead=
				new ObjectInputStream(
						new FileInputStream("res"+File.separator+"outObj.point"));
		CPoint p2 = (CPoint) objRead.readObject();
	}
	public static void writeFile3() throws FileNotFoundException, IOException {
		
		ObjectOutputStream objSave = 
				new ObjectOutputStream(new FileOutputStream("res"+File.separator+"outObj.point"));
		CPoint x = new CPoint(33,44);
		objSave.writeObject(null);
	}
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
				writeFile3();
				openFile3();
	}
}
