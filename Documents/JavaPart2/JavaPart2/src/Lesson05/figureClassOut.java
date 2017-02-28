package Lesson05;
import java.io.*;

import Lesson01and02.CLine;
import Lesson01and02.CPoint;
import Lesson01and02.ColorCLine;
import Lesson01and02.Figure;
import Lesson01and02.MainFigures;
import Lesson01and02.Triangle;
import Lesson04.DrawHouse;
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
