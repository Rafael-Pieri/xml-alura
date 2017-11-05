package br.com.alura.reader.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import br.com.alura.model.Product;
import br.com.alura.reader.XmlReaderSax;

public class XmlReaderSaxTest {
	
	@Test
	public void getSaleProducts() throws ParserConfigurationException, SAXException, IOException {
		XmlReaderSax xmlReaderSax = new XmlReaderSax();
		
		List<Product> products = xmlReaderSax.getProducts();
		
		assertThat(products, hasItems(new Product("Xml book", 29.00),
					            	  new Product("Java book", 19.00),
					            	  new Product("Spring book", 23.00)));  
	}

}
