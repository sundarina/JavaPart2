package Lesson4;

import Lesson1and2.Figure;
import Lesson1and2.Line;
import Lesson1and2.aFigure;
import Lesson1and2.cLine;
import Lesson1and2.point;
import Lesson1and2.ColoredTriangle;

import java.io.*;

public class DrawHouse {
	static FileReader in = null;
	static FileWriter out = null;

	public static void main(String[] args) throws IOException {

		aFigure c = new aFigure();
		Figure[] a = c.getA();
		in = new FileReader("res" + File.separator + "in");
		out = new FileWriter("res" + File.separator + "Figures");
		for (int i = 0; i < a.length; i++) {
			// System.out.println(i + 1 + ": " + a[i].getClass());
			if (a[i].getClass().getName().equals("Lesson1and2.Line")) {
				// LINE
				int x1 = ((Line) a[i]).getA().getXpos();
				int x2 = ((Line) a[i]).getB().getXpos();
				int y1 = ((Line) a[i]).getA().getYpos();
				int y2 = ((Line) a[i]).getB().getYpos();
				int verticalDistance = x2 - x1;
				int horizontalDistance = y2 - y1;
				verticalDistance = toPos(verticalDistance);
				horizontalDistance = toPos(horizontalDistance);
				System.out.println(horizontalDistance);

				for (int j = 0; j < verticalDistance; j++) {
					out.write("*");
				}

				out.flush();
				out.write(13);

			} else if (a[i].getClass().getName().equals("Lesson1and2.cLine")) {

				int x1 = ((cLine) a[i]).getA().getXpos();
				int x2 = ((cLine) a[i]).getB().getXpos();
				int y1 = ((cLine) a[i]).getA().getYpos();
				int y2 = ((cLine) a[i]).getB().getYpos();
				int verticalDistance = x2 - x1;
				verticalDistance = toPos(verticalDistance);

				for (int j = 0; j < verticalDistance; j++) {
					out.write("-");
				}
				out.flush();
				out.write(13);
			} else {
				drawTriangle(out, ((ColoredTriangle) a[i]), false);

			}
		}

		House h = new House(10, 5, 10);
		out.write("=====");
		out.write(13);
		drawTriangle(out, h.c, true);
		drawSquare(out, h.a, false);
		
//		Square s = new Square(new point(0, 0), 8);
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

	public static void drawTriangle(FileWriter out, ColoredTriangle c, boolean b) throws IOException {
		int yDistance = c.getC().getYpos() - c.getB().getYpos();
		int xDistance = c.getC().getXpos() - c.getA().getXpos();
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
				System.out.println(j +" "+(xDistance-2));
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
	ColoredTriangle c;
	Square a;
	int height;
	int width;

	public House(int Height, int RoofHeight, int Width) {
		this.height = Height;
		this.width = Width;
		a = new Square(new point(0, 0 - Height), Width);
		c = new ColoredTriangle(new point(0, RoofHeight), new point(Width / 2, 0), new point(Width, RoofHeight), null);

	}

}

class Square {
	DrawHouse f = new DrawHouse();
	point a;
	point b;
	point c;
	point d;

	public int getWidth() {
		return f.toPos(c.getXpos() - a.getXpos());

	}

	public Square(point startPos, int Size) {
		this.a = startPos;
		this.b = new point(startPos.getXpos() + Size, startPos.getYpos());
		this.c = new point(startPos.getXpos() + Size, startPos.getYpos() + Size);
		this.d = new point(startPos.getXpos(), startPos.getYpos() + Size);
	}
}