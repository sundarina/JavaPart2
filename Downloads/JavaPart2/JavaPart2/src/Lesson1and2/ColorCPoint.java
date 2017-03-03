package Lesson1and2;

public class ColorCPoint extends CPoint implements ColorAble{
private int color;

	public ColorCPoint(int x, int y, int color) {
		super(x, y);
		this.color=color;
	}
	public ColorCPoint(CPoint point, int color) {
		super(point);		
		this.color=color;
	}
 public void setColor(int color) {
	this.color = color;
}
 public int getColor() {
	return color;
}
 @Override
	public String toString() {
		
		return "ColorCpoint "
		+ "x= "	+this.getX()+
		", y= "+getY()+
		" color ="+color;
	}
}
