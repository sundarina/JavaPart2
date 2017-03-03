package Lesson1and2;

import java.io.Serializable;

public class CPoint implements Figure,Serializable{
  private int x;   
  private int y;
  public CPoint(int x, int y) {
	super();
	this.x=x;
	this.y=y;
	
  } 
  public CPoint(CPoint point) {
	super();
	this.x=point.getX();
	this.y=point.getY();	
  }
  public void setX(int x) {
	this.x = x;
  }
  public int getX() {
	return x;
  }  
  public void setY(int y) {
	this.y = y;
}
  public int getY() {
	return y;
}
  @Override
	public String toString() {
		
		return "CPoint : x="+x+", y="+y;
	}
@Override
public void display() {
	System.out.println(this);
	
}
  
}
