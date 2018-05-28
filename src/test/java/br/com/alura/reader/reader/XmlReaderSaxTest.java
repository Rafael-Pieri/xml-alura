package br.com.alura.reader.reader;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

import br.com.alura.reader.model.Product;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlReaderSaxTest {

    @Test
    public void getSaleProducts() throws SAXException, IOException {
        XmlReaderSax xmlReaderSax = new XmlReaderSax();

        List<Product> products = xmlReaderSax.getProducts();

        assertThat(products, hasItems(new Product("Xml book", 29.00),
            new Product("Java book", 19.00),
            new Product("Spring book", 23.00)));
    }
}