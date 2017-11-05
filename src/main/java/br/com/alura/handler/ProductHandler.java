package br.com.alura.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.model.Product;

public class ProductHandler extends DefaultHandler {

	private List<Product> products = new ArrayList<>();

	private Product product;

	private StringBuilder content = new StringBuilder();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equals("product")) {
			product = new Product();
		}

		content = new StringBuilder();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content.append(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equals("product")) {
			products.add(product);
		} else if (qName.equals("name")) {
			product.setName(content.toString());
		} else if (qName.equals("price")) {
			product.setPrice(Double.parseDouble(content.toString()));
		}
	}

	public List<Product> getProducts() {
		return products;
	}

}
