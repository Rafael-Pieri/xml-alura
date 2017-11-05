package br.com.alura.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformerXmlToHtml {

	public void transformXmlToHtml() throws FileNotFoundException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();

		InputStream template = new FileInputStream("src/main/resources/sales-transformer-html.xsl");
		StreamSource stylesheet = new StreamSource(template);
		Transformer transformer = factory.newTransformer(stylesheet);

		InputStream sales = new FileInputStream("src/main/resources/sales.xml");
		StreamSource source = new StreamSource(sales);

		StreamResult result = new StreamResult("src/main/resources/sales-html.html");

		transformer.transform(source, result);
	}

}
