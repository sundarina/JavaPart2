package Lesson11;


import java.sql.*;



public class Products {

	int id;
	String name;
	float rating;
	int quantity;

	public Products(int id, String name, float rating, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.quantity = quantity;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}


