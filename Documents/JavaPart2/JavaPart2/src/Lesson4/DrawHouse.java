package Lesson4;

import Lesson1and2.Figure;
import Lesson1and2.CLine;
import Lesson1and2.MainFigures;
import Lesson1and2.ColorCLine;
import Lesson1and2.CPoint;
import Lesson1and2.Triangle;

import java.io.*;

public class DrawHouse {
	static FileReader in = null;
	static FileWriter out = null;
	static Figure[] a;
	public DrawHouse(Figure[] a) {
		this.a = a;
	}

	public static void main(String[] args) throws IOException {

		MainFigures c1 = new MainFigures();
		
		in = new FileReader("res" + File.separator + "in");
		out = new FileWriter("res" + File.separator + "Figures");
		for (int i = 0; i < a.length; i++) {
			// System.out.println(i + 1 + ": " + a[i].getClass());
			if (a[i].getClass().getName().equals("Lesson1and2.CLine")) {
				// LINE
				int x1 = ((CLine) a[i]).getStart().getX();
				int x2 = ((CLine) a[i]).getEnd().getY();
				int y1 = ((CLine) a[i]).getStart().getY();
				int y2 = ((CLine) a[i]).getEnd().getY();
				int verticalDistance = x2 - x1;
				int horizontalDistance = y2 - y1;
				verticalDistance = toPos(verticalDistance);
				horizontalDistance = toPos(horizontalDistance);
				//System.out.println(horizontalDistance);

				for (int j = 0; j < verticalDistance; j++) {
					out.write("*");
				}

				out.flush();
				out.write(13);

			} else if (a[i].getClass().getName().equals("Lesson1and2.ColorCLine")) {

				int x1 = ((ColorCLine) a[i]).getStart().getX();
				int x2 = ((ColorCLine) a[i]).getEnd().getX();
				int y1 = ((ColorCLine) a[i]).getStart().getY();
				int y2 = ((ColorCLine) a[i]).getEnd().getY();
				
				int verticalDistance = x2 - x1;
				verticalDistance = toPos(verticalDistance);

				for (int j = 0; j < verticalDistance; j++) {
					out.write("-");
				}
				out.flush();
				out.write(13);
			} else {
				drawTriangle(out, ((Triangle) a[i]), false);

			}
		}

		House h = new House(10, 5, 10);
		out.write("=====");
		out.write(13);
		drawTriangle(out, h.c, true);
		drawSquare(out, h.a, false);
		
//		Square s = new Square(new CPoint(0, 0), 8);
//		FileOutputStream j = new FileOutputStream("res" + File.separator + "Figures");
//		int f = s.getWidth() * 2 - 1;
//		j.write('_');
//		for (int i1 = 0; i1 < f; i1++) {
//			j.write('_');
//		}
//		j.write('_');
//		j.write(13);
//		for (int i = 0; i < s.getWidth() - 1; i++) {
//			j.write('|');
//			for (int i1 = 0; i1 < f; i1++) {
//				j.write(' ');
//			}
//			j.write('|');
//
//			j.write(13);
//
//		}
//		j.write('|');
//		for (int i1 = 0; i1 < f; i1++) {
//			j.write('_');
//		}
//		j.write('|');
//		j.flush();

	}

	public static int toPos(int b) {
		if (b <= 0) {
			if (b - b - b == 0) {
				return b + 4;
			} else {
				return b - b - b;
			}
		} else {
			return b;
		}
	}

	public static void drawSquare(FileWriter out, Square s, boolean b) throws IOException {
		int f = s.getWidth() * 2 - 1;
		for (int i = 0; i < s.getWidth() - 1; i++) {
			out.write("|");
			for (int i1 = 0; i1 < f; i1++) {
				out.write(" ");
			}
			out.write("|");
			out.write(13);

		}
		out.write("|");
		for (int i1 = 0; i1 < f; i1++) {
			out.write("_");
		}
		out.write("|");
		out.flush();
	}

	public static void drawTriangle(FileWriter out, Triangle c, boolean b) throws IOException {
		int yDistance = c.getApexC().getY() - c.getApexB().getY();
		int xDistance = c.getApexC().getX() - c.getApexA().getX();
		xDistance = toPos(xDistance);
		yDistance = toPos(yDistance);
		int tempDis = 1;

		int tempDis2 = xDistance;

		for (int j = 0; j < (xDistance); j++) {
			out.write(" ");

		}
		out.write("^");
		boolean b1 = true;
		boolean b2 = true;

		out.write(13);
		
		if (b) {
			int x = 1;
			int d = (xDistance * 2)-16;
			int distance = (xDistance * 2)-16;
			
			for (int j = 0; j < xDistance - 1; j++) {
				b1 = false;
				
				for (int j1 = 0; j1 < tempDis2 - 1; j1++) {
					out.write(" ");
				}

				out.write("/");
				//System.out.println(j +" "+(xDistance-2));
				if(j == xDistance-2) {
					b2 = true;
				}
				for (int j1 = 0; j1 < tempDis; j1++) {
					
					if (j > d ) {
						if((b2 && (j1 > x && j1 < tempDis-x-1)) || (j1 == x || j1 == tempDis-x-1)) {
							out.write("+");
							b1 = true;
							
						} else {
							out.write(" ");
						}
						
						
					} else {
						out.write(" ");
					}
					
				}
				if(b1) {
					x++;
					b2 = false;
				}
				
				out.write("\\");
				out.write(13);

				tempDis += 2;
				tempDis2--;
				
				
			}
			
		} else {
			for (int j = 0; j < xDistance - 1; j++) {

				for (int j1 = 0; j1 < tempDis2 - 1; j1++) {
					out.write(" ");
				}
				out.write("/");
				tempDis2--;
				for (int j1 = 0; j1 < tempDis; j1++) {
					out.write(" ");
				}
				out.write("\\");
				out.write(13);
				tempDis += 2;
			}
		}

		out.write("/");
		for (int j1 = 0; j1 < tempDis; j1++) {
			out.write("_");
		}
		out.write("\\");
		out.write(13);

		out.flush();

	}
}

class House {
	Triangle c;
	Square a;
	int height;
	int width;

	public House(int Height, int RoofHeight, int Width) {
		this.height = Height;
		this.width = Width;
		a = new Square(new CPoint(0, 0 - Height), Width);
		c = new Triangle(new CPoint(0, RoofHeight), new CPoint(Width / 2, 0), new CPoint(Width, RoofHeight));

	}

}

class Square {
	DrawHouse f = new DrawHouse(null);
	CPoint a;
	CPoint b;
	CPoint c;
	CPoint d;

	public int getWidth() {
		return f.toPos(c.getX() - a.getX());

	}

	public Square(CPoint startPos, int Size) {
		this.a = startPos;
		this.b = new CPoint(startPos.getX() + Size, startPos.getY());
		this.c = new CPoint(startPos.getX() + Size, startPos.getY() + Size);
		this.d = new CPoint(startPos.getX(), startPos.getY() + Size);
	}
}