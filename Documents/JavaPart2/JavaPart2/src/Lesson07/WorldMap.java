package Lesson07;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class WorldMap {
	private ArrayList<Country> countries;
	public ArrayList<Country> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	private ArrayList<City> cities;

	public WorldMap() {
		countries = new ArrayList<Country>();
		cities = new ArrayList<City>();
	}

	public void loadFromFile(String fileName) {
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document doc = null;		
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			doc = db.parse(new File(fileName));
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Element root = doc.getDocumentElement();
		if (root.getTagName().equals("map")) {
			
			NodeList listCountries = root.getElementsByTagName("country");
		
			for (int i = 0; i < listCountries.getLength(); i++) {
				//Reading the country from xml file
				Element country = (Element) listCountries.item(i);
				
				NodeList listCities=country.getElementsByTagName("city");
				int f = listCities.getLength();
				int countryCode = Integer.parseInt(country.getAttribute("id"));
				String countryName = country.getAttribute("name");
				Country curCountry = new Country(countryCode, countryName,f);
				countries.add(curCountry);
				
				
				for (int j = 0; j < listCities.getLength(); j++) {
					
					//Reading the city from xml file
					Element city= (Element)listCities.item(j);
					
					int cityCode= Integer.parseInt(city.getAttribute("id"));
					String cityName = city.getAttribute("name");
					boolean isCap = Boolean.valueOf(city.getAttribute("isCap"));
					int cityPop = Integer.valueOf(city.getAttribute("count"));
					
					
					City curCity= new City(cityCode, cityName, isCap, cityPop, curCountry);
					cities.add(curCity);
				}
			}
			
		}
	}
}
