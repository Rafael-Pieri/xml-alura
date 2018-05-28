package br.com.alura.reader.reader;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.transform.TransformerException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class TransformerXmlToHtmlTest {

    @Test
    public void transformXmlToHtml() throws TransformerException, IOException {
        TransformerXmlToHtml transformerXmlToHtml = new TransformerXmlToHtml();

        transformerXmlToHtml.transformXmlToHtml();

        StringWriter htmlGeneratedWriter = new StringWriter();
        IOUtils.copy(new FileInputStream(new File("src/main/resources/sales-html.html")), htmlGeneratedWriter,
            "ISO-8859-1");

        StringWriter htmlExpectedWriter = new StringWriter();
        IOUtils.copy(new FileInputStream(new File("src/test/resources/sales-html-test.html")), htmlExpectedWriter,
            "ISO-8859-1");

        assertEquals(htmlExpectedWriter.toString(), htmlGeneratedWriter.toString());
    }
}