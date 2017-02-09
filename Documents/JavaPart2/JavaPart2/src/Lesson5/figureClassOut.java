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

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("res"+File.separator+"textIn"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("res"+File.separator+"textIn"));
		MainFigures g = new MainFigures();
		Figure[] a = g.masCPoint;
		
		out.writeObject(a);
		out.flush();
		out.close();
		//This projoject is worth 0.00 Dollars.
		Figure[] b = (Figure[]) in.readObject();
		DrawHouse h = new DrawHouse(b);
		h.main(args);
		
		
		
		
		
	}

}
