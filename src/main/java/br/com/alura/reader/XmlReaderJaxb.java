package br.com.alura.reader;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Product;
import br.com.alura.model.Sale;

public class XmlReaderJaxb {

	private JAXBContext jaxbContext;

	public XmlReaderJaxb() throws JAXBException {
		jaxbContext = JAXBContext.newInstance(Sale.class);
	}

	public String convertObjectToXml() throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();

		Sale sales = new Sale();
		sales.setPaymentForm("Credit");

		List<Product> products = new ArrayList<>();
		products.add(new Product("Java book", 18.90));
		products.add(new Product("Spring book", 24.90));
		products.add(new Product("Ruby book", 39.90));
		sales.setProducts(products);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(sales, writer);

		return writer.toString();
	}

	public Sale convertXmlToObject() throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		return (Sale) unmarshaller.unmarshal(new File("src/main/resources/sales.xml"));
	}

}
