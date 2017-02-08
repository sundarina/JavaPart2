package Lesson1and2;

public class ColorCLine extends CLine implements ColorAble{
private int color;

public ColorCLine(CPoint start, CPoint end, int color) {
	super(start, end);
	this.color = color;
}

public int getColor() {
	return color;
}

public void setColor(int color) {
	this.color = color;
}

@Override
public String toString() {
	return "ColorCLine [color=" + color + ", getStart()=" + getStart() + ", getEnd()=" + getEnd() + "]";
}

}
