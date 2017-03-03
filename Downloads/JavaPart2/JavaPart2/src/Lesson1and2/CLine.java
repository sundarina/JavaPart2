package Lesson1and2;

public class CLine implements Figure{
private CPoint start;
private CPoint end;
public CLine(CPoint start, CPoint end) {
		this.start=start;
		this.end=end;
}
public CLine(int x1, int y1, int x2, int y2) {
		this.start=new CPoint(x1,y1);
		this.end=new CPoint(x2,y2);
}
public CPoint getStart() {
	return start;
}
public void setStart(CPoint start) {
	this.start = start;
}
public CPoint getEnd() {
	return end;
}
public void setEnd(CPoint end) {
	this.end = end;
}
@Override
public String toString() {
	return "CLine [start=" + start + ", end=" + end + "]";
}
public double length(){
	return Math.sqrt(Math.pow(start.getX()-end.getX(), 2)
					+Math.pow(start.getY()-end.getY(), 2));
}
@Override
public void display() {
	System.out.println(this);
}
}
