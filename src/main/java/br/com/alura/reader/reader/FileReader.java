package br.com.alura.reader.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileReader {

    private String sourceFilePath;
    private String destinationFilePath;

    public FileReader(String sourceFilePath, String destinationFilePath) {
        this.sourceFilePath = sourceFilePath;
        this.destinationFilePath = destinationFilePath;
    }

    public FileReader read() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream
            (sourceFilePath)))) {

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(destinationFilePath)))) {

                String line = bufferedReader.readLine();

                while (line != null) {
                    bufferedWriter.write(line);
                    line = bufferedReader.readLine();

                    if (line != null) {
                        bufferedWriter.newLine();
                    }
                }

                return this;
            }
        }
    }

    public Integer getNumberOfLines() throws FileNotFoundException {
        Integer lineCounter = 0;

        Scanner scanner = new Scanner(new FileInputStream(destinationFilePath));

        while (scanner.hasNextLine()) {
            lineCounter++;
            scanner.nextLine();
        }

        scanner.close();

        return lineCounter;
    }
}