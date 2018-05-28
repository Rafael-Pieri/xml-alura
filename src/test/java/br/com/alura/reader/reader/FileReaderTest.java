package br.com.alura.reader.reader;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {

    @Test
    public void readFile() throws IOException {
        Integer numberOfLines = new FileReader("src/test/resources/sourceFileTest.txt",
            "src/test/resources/destinationFileTest.txt").read()
            .getNumberOfLines();

        Assert.assertEquals(Integer.valueOf(2), numberOfLines);
    }
}