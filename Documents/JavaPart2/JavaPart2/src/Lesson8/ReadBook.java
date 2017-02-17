package Lesson8;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadBook extends DefaultHandler {
	private StringBuffer stringBuffer;
	ArrayList books = new ArrayList<Book>();
	int b = 0;

	public static void main(String[] args) {

		DefaultHandler defaultHandler = new ReadBook();

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {

			SAXParser Sax_Parser = saxParserFactory.newSAXParser();

			Sax_Parser.parse(new File("res" + File.separator + "booksIn.xml"), defaultHandler);
			

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void startDocument() throws SAXException {

	}

	public void endDocument() throws SAXException {

	}

	public void startElement(String namespaceURI, String localName, String qName, Attributes attrs)
			throws SAXException {

		if ("".equals(localName)) {
			localName = qName;

		}
		if(qName.equals("BookName")) {
			b = 1;
		} else if(qName.equals("BookPrice")) {
			b = 2;
		} else if(qName.equals("BookAuthor")) {
			b = 3;
		} else if  (qName.equals("Book")) {
			books.add(new Book("","",0));
			b = 4;
			((Book)books.get(books.size()-1)).setQuantity(Integer.parseInt(attrs.getValue(0)));
		} else {
			b = 4;
		}

		if (attrs != null) {

			for (int i = 0; i < attrs.getLength(); i++) {

				String aName = attrs.getLocalName(i);

				String Author = attrs.getValue(i);
				
				if ("".equals(aName)) {
					aName = attrs.getQName(i);
					
				}

			}
		}

	}

	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		 displayBufferText();
		if ("".equals(localName))
			localName = qName;

	}

	public void characters(char buf[], int offset, int len) throws SAXException {
		String s = new String(buf, offset, len);

		s = s.replaceAll("  ", "");
		s = s.replaceAll("\n", "");
		s = s.replaceAll("	", "");
		if (!(s.isEmpty())) {

			Book f = new Book("", "", 0);
			switch (b) {
			case 1: ((Book)books.get(books.size()-1)).setName(s);
				break;
			case 2: ((Book)books.get(books.size()-1)).setPrice(Integer.parseInt(s));
				break;
			case 3: ((Book)books.get(books.size()-1)).setAuthor(s); System.out.println(books.get(books.size()-1));
				break;
			case 4:
				break;
			}

		}

		if (stringBuffer == null) {

		} else {

		}
	}

	private void displayBufferText() {
		if (stringBuffer != null) {

			stringBuffer = null;
		}
	}
}

class Book {
	private String Name;
	private String Author;
	private int Price;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	

	public void setQuantity(int string) {
		this.quantity = string;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Book(String name, String author, int price) {
		super();
		this.Name = name;
		this.Author = author;
		this.Price = price;
	}

	@Override
	public String toString() {
		return "Name = " + Name + " | Author = " + Author + " | Price = " + Price + " | Quantity = "+quantity;

	}
}
