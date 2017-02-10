package Lesson5;
import java.io.*;
import Lesson1and2.Figure;
import Lesson1and2.CLine;
import Lesson1and2.MainFigures;
import Lesson1and2.ColorCLine;
import Lesson1and2.CPoint;
import Lesson1and2.Triangle;
import Lesson4.DrawHouse;
public class figureClassOut {
	static ObjectOutputStream out;
	static ObjectInputStream in;
	static MainFigures g;
	static Figure[] a;
	static Figure[] b;
	static DrawHouse h;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		out = new ObjectOutputStream(new FileOutputStream("res"+File.separator+"textIn"));
		in = new ObjectInputStream(new FileInputStream("res"+File.separator+"textIn"));
		g = new MainFigures();
		a = g.masCPoint;
		
		out.writeObject(a);
		out.flush();
		out.close();
		
		b = (Figure[]) in.readObject();
		h = new DrawHouse(b);
		h.main(args);
		
	}

}
