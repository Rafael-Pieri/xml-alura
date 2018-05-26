package br.com.alura.reader.test;

import static org.junit.Assert.assertEquals;

import br.com.alura.model.Product;
import br.com.alura.model.Sale;
import br.com.alura.reader.XmlReaderJaxb;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import javax.xml.bind.JAXBException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class XmlReaderJaxbTest {

    @Test
    public void getSaleAndItProductsConvertingObjectToXml() throws JAXBException, IOException {
        XmlReaderJaxb xmlReaderJaxb = new XmlReaderJaxb();

        String sale = xmlReaderJaxb.convertObjectToXml();

        StringWriter writer = new StringWriter();
        IOUtils.copy(new FileInputStream(new File("src/test/resources/sales-test.xml")), writer, "ISO-8859-1");

        assertEquals(writer.toString(), sale);
    }

    @Test
    public void getSaleAndItProductsConvertingXmlToObject() throws JAXBException {
        XmlReaderJaxb xmlReaderJaxb = new XmlReaderJaxb();

        Sale convertedSale = xmlReaderJaxb.convertXmlToObject();

        Sale expectedSale = new Sale("Debit", Arrays.asList(new Product("Xml book", 29.00),
            new Product("Java book", 19.00),
            new Product("Spring book", 23.00)));

        assertEquals(expectedSale, convertedSale);
    }
}