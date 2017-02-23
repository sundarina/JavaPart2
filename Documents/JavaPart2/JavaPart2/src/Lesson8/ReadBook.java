package Lesson8;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadBook extends DefaultHandler {
	private StringBuffer stringBuffer;

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DefaultHandler handler = new ReadBook();
		SAXParserFactory sxf = SAXParserFactory.newInstance();
		SAXParser sx = sxf.newSAXParser();

		sx.parse(new File("res" + File.separator + "booksIn.xml"), handler);
	}

	

	public void startElement(String namespaceURI, String localName, String qName, Attributes attrs)
			throws SAXException {

		
		System.out.println(qName);
		

		
		}
	

	}

	
	

	


