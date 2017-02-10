package Lesson6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class BoquetDisplayer  {
	Boquet[] b = new Boquet[5];
	
	public BoquetDisplayer() throws FileNotFoundException, IOException {
			b[0] = new Boquet("Spring");
			b[1] = new Boquet("Summer");
			b[2] = new Boquet("Winter");
			b[3] = new Boquet("Fall");
			b[4] = new Boquet("Valentine");
			System.out.println("5 Boque's created. Everything is working correctly, i think(hope).");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("res"+File.separator+"Boquet"));
			out.writeObject(b);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BoquetDisplayer a = new BoquetDisplayer();
	}
}

class Boquet implements Serializable {
	String name = "Boquet";

	Flower[] flowerList = new Flower[(int) (Math.random() * 25)];
	Accessory[] accessoryList = new Accessory[(int) (Math.random() * 4) + 1];

	public Accessory[] Accessories = new Accessory[2];
	public Flower[] Flowers = new Flower[2];

	public int ran(int max) {
		return (int) (Math.random() * max);
	}

	public void addFlower(int Price, boolean inStock, String name) {
		Flower[] temp = new Flower[flowerList.length + 1];
		{
			for (int i = 0; i < flowerList.length; i++) {
				temp[i] = flowerList[i];
			}
			flowerList = temp;
			flowerList[flowerList.length - 1] = new Flower(Price, inStock, name);
		}
	}

	public void removeFlower(int toRemove) {
		int current = 0;
		Flower[] temp = new Flower[flowerList.length - 1];
		for (int i = 0; i < flowerList.length; i++) {
			if (i != toRemove) {
				temp[current] = flowerList[i];
				current++;
			}

		}
		flowerList = temp;
	}

	public void addAccessory(int Price, boolean inStock, String name) {
		Accessory[] temp = new Accessory[flowerList.length + 1];
		{
			for (int i = 0; i < accessoryList.length; i++) {
				temp[i] = accessoryList[i];
			}
			accessoryList = temp;
			accessoryList[accessoryList.length - 1] = new Accessory(Price, inStock, name);
		}
	}

	public void removeAccessory(int toRemove) {
		int current = 0;
		Accessory[] temp = new Accessory[flowerList.length - 1];
		for (int i = 0; i < accessoryList.length; i++) {
			if (i != toRemove) {
				temp[current] = accessoryList[i];
				current++;
			}

		}
		accessoryList = temp;
	}

	//Constructor --
	public Boquet(String name) {
		this.name = name;

		Accessories[0] = new Accessory(ran(10), true, "Bow");
		Accessories[1] = new Accessory(ran(10), true, "Card");

		Flowers[0] = new Flower(ran(10), true, "Rose");
		Flowers[1] = new Flower(ran(10), true, "Lily");

		for (int i = 0; i < accessoryList.length; i++) {
			accessoryList[i] = Accessories[ran(2)];
		}

		for (int i = 0; i < flowerList.length; i++) {
			flowerList[i] = Flowers[ran(2)];
		}

	}

}

class Flower extends Accessory implements Serializable {
	//Constructor --
	public Flower(int Price, boolean inStock, String name) {
		super(Price, inStock, name);
	}
}

class Accessory implements Serializable {
	String name;
	int Price;
	boolean inStock;
	//Constructor --
	public Accessory(int Price, boolean inStock, String name) {
		this.Price = Price;
		this.inStock = inStock;
		this.name = name;
	}

}
