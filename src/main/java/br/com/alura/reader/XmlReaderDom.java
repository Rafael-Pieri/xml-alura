package br.com.alura.reader;

import br.com.alura.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReaderDom {

    public List<Product> getProducts() throws ParserConfigurationException, SAXException, IOException {
        List<Product> productList = new ArrayList<>();
        Document document = getSalesXmlDocument();
        NodeList products = document.getElementsByTagName("product");

        for (int i = 0; i < products.getLength(); i++) {
            Element product = (Element) products.item(i);
            String name = product.getElementsByTagName("name").item(0).getTextContent();
            Double price = Double.parseDouble(product.getElementsByTagName("price").item(0).getTextContent());
            productList.add(new Product(name, price));
        }

        return productList;
    }

    public String getCurrency() throws ParserConfigurationException, SAXException, IOException {
        Document document = getSalesXmlDocument();
        Element sales = document.getDocumentElement();

        return sales.getAttribute("currency");
    }

    private Document getSalesXmlDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
            "http://www.w3.org/2001/XMLSchema");

        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse("src/main/resources/sales.xml");
    }
}