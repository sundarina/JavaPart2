package Lesson11;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Lesson07.ProgramOfWorldMapCon;
import Lesson07.WorldMap;

public class SendToXml {

	public SendToXml(ProductDAO a)
			throws TransformerException, ClassNotFoundException, SQLException, ParserConfigurationException {
		
		// Declaring DocumentBuilders
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		db = dbf.newDocumentBuilder();

		// Declaring out document
		Document doc = db.newDocument();

		// Create the root element
		Element root = doc.createElement("Store");
		doc.appendChild(root);
		int j = 0;

		// Adding countries to the root element
		for (int i = 0; i < a.products.size(); i++) {
			Element product = doc.createElement("Product");

			product.setAttribute("Id", Integer.toString(a.products.get(i).id));
			product.setAttribute("Name", a.products.get(i).name);
			product.setAttribute("Rate", Float.toString(a.products.get(i).rating));
			product.setAttribute("Quantity", Integer.toString(a.products.get(i).quantity));

			root.appendChild(product);

		}

		// Sending documentBuilder to the XML file
		Source domSource = new DOMSource(doc);
		Result fileResult = new StreamResult(new File("res" + File.separator + "products.xml"));
		TransformerFactory trFac = TransformerFactory.newInstance();
		Transformer tr = trFac.newTransformer();
		tr.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");
		tr.transform(domSource, fileResult);
		System.out.println('h');
	}

}
