package br.com.alura.reader.reader;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

import br.com.alura.reader.model.Product;
import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;

public class XmlReaderStaxTest {

    @Test
    public void getSaleProducts() throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
        XmlReaderStax xmlReaderStax = new XmlReaderStax();

        List<Product> products = xmlReaderStax.getProducts();

        assertThat(products, hasItems(new Product("Xml book", 29.00),
            new Product("Java book", 19.00),
            new Product("Spring book", 23.00)));
    }
}