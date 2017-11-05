package br.com.alura.reader.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import br.com.alura.model.Product;
import br.com.alura.reader.XmlReaderDom;

public class XmlReaderDomTest {
	
	@Test
	public void getSaleCurrency() throws ParserConfigurationException, SAXException, IOException {
		XmlReaderDom xmlReaderDom = new XmlReaderDom();
		
		assertEquals("real", xmlReaderDom.getCurrency());
	}
	
	@Test
	public void getSaleProducts() throws ParserConfigurationException, SAXException, IOException {
		XmlReaderDom xmlReaderDom = new XmlReaderDom();
		
		List<Product> products = xmlReaderDom.getProducts();
		
		assertThat(products, hasItems(new Product("Xml book", 29.00),
					            	  new Product("Java book", 19.00),
					            	  new Product("Spring book", 23.00)));  
	}

}
