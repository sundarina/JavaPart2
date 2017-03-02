package Lesson12;

public class Vagon {
 int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Vagon(int id) {
	super();
	this.id = id;
}

@Override
public String toString() {
	return id==0?"Pass":"Cargo";
}
 
	
}
