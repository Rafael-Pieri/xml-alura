package br.com.alura.reader.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

import br.com.alura.model.Product;
import br.com.alura.reader.XmlReaderDomWithXPath;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlReaderDomWithXPathTest {

    @Test
    public void getAllSaleProducts() throws XPathExpressionException, ParserConfigurationException, SAXException,
		IOException {
        XmlReaderDomWithXPath xmlReaderDomWithXPath = new XmlReaderDomWithXPath();

        List<Product> products = xmlReaderDomWithXPath.getProducts();

        assertThat(products, hasItems(new Product("Xml book", 29.00),
            new Product("Java book", 19.00),
            new Product("Spring book", 23.00)));
    }

    @Test
    public void getSaleProductsWithInformedName() throws XPathExpressionException, ParserConfigurationException,
		SAXException, IOException {
        XmlReaderDomWithXPath xmlReaderDomWithXPath = new XmlReaderDomWithXPath();

        List<Product> products = xmlReaderDomWithXPath.getProducts("Java");

        assertThat(products, hasItems(new Product("Java book", 19.00)));
    }
}