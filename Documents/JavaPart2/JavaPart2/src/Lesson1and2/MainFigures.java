package Lesson1and2;

class FigureFabric{
	
   public static Figure rand(){
	   return getFigure((int)((Math.random() * 3)));
   }
   public static int r() {
	   return (int)((Math.random()*10)+3);
   }
   public static Figure getFigure(int n){
	   switch(n){
	   case 0: return new CLine(new CPoint(r(),r()),new CPoint(r(),r()));
	   case 1: return new ColorCLine(new CPoint(r(),r()),new CPoint(r(),r()),3);
	   case 2: return new Triangle(new CPoint(r(),r()),new CPoint(r(),r()),new CPoint(r(),r()));
	   default: return new Triangle(new CPoint(r(),r()),new CPoint(r(),r()),new CPoint(r(),r()));
	   }
   }
}
public class MainFigures {
	FigureFabric c = new FigureFabric();
	
	public static Figure [] masCPoint = new Figure[40];
	public MainFigures() {
		for(int i = 0; i < masCPoint.length;i++) {
			masCPoint[i] = c.rand();
		}
	}
    public static void print(Figure fig){
    //	if(fig.getClass().getName().equals("prj01.CPoint")){
    //	if(fig instanceof CPoint){    		
    //		System.out.println("This point x= "+((CPoint)fig).getX());}
    	 fig.display();    	
    }
	public static void main(String[] args) {
		CPoint p1= new CPoint(0, 0);
		CPoint p2= new CPoint(1,1);
	//	System.out.println(p1.toString());
		ColorCPoint cp1= new ColorCPoint(1, 1, 333333);
		ColorCPoint cp2= new ColorCPoint(p1, 222222);
		ColorCPoint cp3= new ColorCPoint(new CPoint(1,2), 444444);
		CLine line1 = new CLine(1,1,2,2);
		CLine line2= new CLine(p1,p2);
		CLine line3 = new CLine(new CPoint(3,3),new CPoint(4,4));
		Triangle tri = new Triangle(p1, p2, new CPoint(3,3));
		tri.lengthAB();
		
		 for (int i = 0; i < masCPoint.length; i++) {
			masCPoint[i]=FigureFabric.rand();
		}
	//	masCPoint[0]= p1;
	//	masCPoint[1]=cp1;
	//	masCPoint[2]=line1;
	//	masCPoint[3]=tri;
		ColorAble [] masColor = new ColorAble[40];
		int countColor=0;
		for (Figure figure : masCPoint) {			
			//System.out.println(figure.toString()+"instance -> "+figure.getClass().getName());
			print(figure);
			if(figure instanceof ColorAble)
				masColor[countColor++]=(ColorAble)figure;
		}		
	//	masColor[countColor++]=new ColorCPoint(p1, 2);
	//	masColor[countColor++]= new ColorCLine(p1, p2, 3);
	
	}

}
