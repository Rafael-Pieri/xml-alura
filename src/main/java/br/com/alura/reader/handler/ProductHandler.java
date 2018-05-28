package br.com.alura.reader.handler;

import br.com.alura.reader.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ProductHandler extends DefaultHandler {

    private List<Product> products = new ArrayList<>();

    private Product product;

    private StringBuilder content = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("product")) {
            product = new Product();
        }

        content = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("product".equals(qName)) {
            products.add(product);
        } else if ("name".equals(qName)) {
            product.setName(content.toString());
        } else if ("price".equals(qName)) {
            product.setPrice(Double.parseDouble(content.toString()));
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}