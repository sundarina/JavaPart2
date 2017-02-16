package Lesson7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProgramOfWorldMapCon {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		WorldMap myMap = new WorldMap();
		myMap.loadFromFile("res" + File.separator + "map.xml");
		ProgramOfWorldMapCon a = new ProgramOfWorldMapCon();

		// Declaring DocumentBuilders
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		db = dbf.newDocumentBuilder();

		// Declaring out document
		Document doc = db.newDocument();

		// Create the root element
		Element root = doc.createElement("Map");
		doc.appendChild(root);
		int j = 0;
		

		// Adding countries to the root element
		for (int i = 0; i < myMap.getCountries().size(); i++) {
			Element country1 = doc.createElement(myMap.getCountries().get(i).getName());
			country1.setAttribute("Id", Integer.toString(myMap.getCountries().get(i).getId()));
			root.appendChild(country1);

			// Adding cities to each country
			for (int f = 0 ;f < myMap.getCountries().get(i).getNumOfCities(); f++) {
				
				Element city1 = doc.createElement(myMap.getCities().get(j).getName());

				String temp = Boolean.toString(myMap.getCities().get(j).isCap());
				city1.setAttribute("isCapital", temp);

				temp = Integer.toString(myMap.getCities().get(j).getCount());
				city1.setAttribute("Population", temp);

				temp = Integer.toString(myMap.getCities().get(j).getCode());
				city1.setAttribute("id", temp);

				country1.appendChild(city1);
				j++;
			}

		}

		// Sending documentBuilder to the XML file
		Source domSource = new DOMSource(doc);
		Result fileResult = new StreamResult(new File("res" + File.separator + "CountryIn.xml"));
		TransformerFactory trFac = TransformerFactory.newInstance();
		Transformer tr = trFac.newTransformer();
		tr.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");
		tr.transform(domSource, fileResult);

	}

}
