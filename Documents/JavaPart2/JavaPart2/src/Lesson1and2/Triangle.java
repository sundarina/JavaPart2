package Lesson1and2;

import java.io.Serializable;

public class Triangle implements Figure,Serializable{
 private CPoint apexA, apexB, apexC;
 private CLine sideAB, sideBC, sideCA;
 public Triangle(CPoint A, CPoint B, CPoint C) {
	apexA=A;
	apexB=B;
	apexC=C;	
}
 public CLine getSideAB() {
	 if(sideAB==null) sideAB=new CLine(apexA,apexB);
	return sideAB;
}
public CPoint getApexA() {
	return apexA;
}
public void setApexA(CPoint apexA) {
	this.apexA = apexA;
	sideAB=null;
	sideCA=null;
}
public CPoint getApexB() {
	return apexB;
	
}
public void setApexB(CPoint apexB) {
	this.apexB = apexB;
	sideBC=null;
	sideAB=null;	
}
public CPoint getApexC() {
	return apexC;
}
public void setApexC(CPoint apexC) {
	this.apexC = apexC;
	sideBC=null;
	sideCA=null;
}
public CLine getSideBC() {
	 if(sideBC==null) sideBC=new CLine(apexB,apexC);
	return sideBC;
}
public CLine getSideCA() {
	if(sideCA==null) sideCA=new CLine(apexC,apexA);
	return sideCA;
}
public double lengthAB(){ return this.getSideAB().length();}
@Override
public String toString() {
	return "Triangle [apexA=" + apexA + ", apexB=" + apexB + ", apexC=" + apexC + "]";
}
@Override
public void display() {
	System.out.println(this);
	
}
public long SerialVersionUID = 128;

 
}
