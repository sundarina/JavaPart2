package Lesson7;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class TownExporter {

	public static void main(String[] args) {
		worldMap myMap = new worldMap();
		myMap.loadFromFile("res"+File.separator+"map.xml");

	}

}

class worldMap {
	private ArrayList<Country> countries;
	private ArrayList<City> cities;

	public worldMap() {
		super();
		countries = new ArrayList();
		cities = new ArrayList();
	}

	public void loadFromFile(String fileName) {
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document doc = null;
		dbf = DocumentBuilderFactory.newInstance();
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(new File(fileName));

		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}
		Element root = doc.getDocumentElement();
		if (root.getTagName().equals("map")) {
			
			// Получаем коллекцию стран
			NodeList listCountries = root.getElementsByTagName("country");
			
			// Проходим по странам
			for (int i = 0; i < listCountries.getLength(); i++) {
				
				// Получаем текущую срану
				Element country = (Element) listCountries.item(i);
				int countryCode = Integer.parseInt(country.getAttribute("id"));
				String countryName = country.getAttribute("name");
			    Country curCountry=new Country(countryCode,countryName);
				countries.add(curCountry);
				
				// Получаем коллекцию городов для страны
				NodeList listCities = country.getElementsByTagName("city");
				
				// Проходим по городам
				for (int j = 0; j < listCities.getLength(); j++) {
					
					// Получаем текущий город
					Element city = (Element) listCities.item(j);
					String cityName = city.getAttribute("name");
					int cityCode=Integer.parseInt(city.getAttribute("Code"));
					System.out.println(" " + cityName);
					
					
					
				}
			}
		}

	}

}



class Country {
	String name;
	int id;
	int count;

	public Country(int countryCode, String countryName) {
		this.name = countryName;
		this.id = countryCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class City {
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
