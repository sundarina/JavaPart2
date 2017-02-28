package Lesson07;

public class Country {
private int id;
private String name;
private int numOfCities;

public Country(int id, String name,int numOfCities) {
	super();
	this.id = id;
	this.name = name;
	this.numOfCities = numOfCities;
}

public int getNumOfCities() {
	return numOfCities;
}

public void setNumOfCities(int numOfCities) {
	this.numOfCities = numOfCities;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}
}
