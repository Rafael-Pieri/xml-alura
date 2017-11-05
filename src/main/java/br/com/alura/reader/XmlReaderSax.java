package br.com.alura.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProductHandler;
import br.com.alura.model.Product;

public class XmlReaderSax {
	
	public List<Product> getProducts() throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ProductHandler productHandler = new ProductHandler();	
		reader.setContentHandler(productHandler);
		InputStream inputStrem = new FileInputStream("src/main/resources/sales.xml");
		InputSource inputSource = new InputSource(inputStrem);
		reader.parse(inputSource);
		
		return productHandler.getProducts();
	}

}
