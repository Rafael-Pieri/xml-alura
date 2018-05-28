package br.com.alura.reader.reader;

import br.com.alura.reader.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReaderDomWithXPath {

    public List<Product> getProducts() throws ParserConfigurationException, SAXException, IOException,
        XPathExpressionException {
        List<Product> productList = new ArrayList<>();
        Document document = getSalesXmlDocument();
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "/sales/products/product";
        XPathExpression xPathExpression = xPath.compile(expression);

        NodeList products = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < products.getLength(); i++) {
            Element product = (Element) products.item(i);
            String name = product.getElementsByTagName("name").item(0).getTextContent();
            Double price = Double.parseDouble(product.getElementsByTagName("price").item(0).getTextContent());
            productList.add(new Product(name, price));
        }

        return productList;
    }

    public List<Product> getProducts(String name) throws ParserConfigurationException, SAXException, IOException,
        XPathExpressionException {
        List<Product> productList = new ArrayList<>();
        Document document = getSalesXmlDocument();
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "/sales/products/product[contains(name, " + name + ")]";
        XPathExpression xPathExpression = xPath.compile(expression);

        NodeList products = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < products.getLength(); i++) {
            Element product = (Element) products.item(i);
            String nameBook = product.getElementsByTagName("name").item(0).getTextContent();
            Double price = Double.parseDouble(product.getElementsByTagName("price").item(0).getTextContent());
            productList.add(new Product(nameBook, price));
        }

        return productList;
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