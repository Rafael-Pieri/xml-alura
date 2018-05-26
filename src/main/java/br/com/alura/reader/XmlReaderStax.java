package br.com.alura.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Product;

public class XmlReaderStax {

	public List<Product> getProducts() throws XMLStreamException, FactoryConfigurationError, FileNotFoundException {
		XMLEventReader events = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream("src/main/resources/sales.xml"));

		List<Product> products = new ArrayList<>();

		while (events.hasNext()) {
			XMLEvent event = events.nextEvent();

			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("product")) {
				Product product = getProduct(events);
				products.add(product);
			}
		}

		return products;
	}

	private Product getProduct(XMLEventReader events) throws XMLStreamException {
		Product product = new Product();

		while (events.hasNext()) {
			XMLEvent event = events.nextEvent();

			if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("product")) {
				break;
			}

			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("name")) {
				event = events.nextEvent();
				String name = event.asCharacters().getData();
				product.setName(name);
			}

			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("price")) {
				event = events.nextEvent();
				Double price = Double.parseDouble(event.asCharacters().getData());
				product.setPrice(price);
			}
		}

		return product;
	}
}