package it.tino.easysort.listreaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextFileReaderTest {

    private final ListReader listReader;

    public TextFileReaderTest() {
        // so that no application output is shown in the console during tests
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);

        this.listReader = new TextFileReader(printStream);
    }

    @Test
    public void testFileReading() {
        List<String> lines = Arrays.asList("1", "2", "3");

        String fileContent = String.join("\n", lines);
        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());

        List<Double> actual = listReader.readLines(inputStream);

        Assertions.assertEquals(Arrays.asList(1d, 2d, 3d), actual);
    }

    @Test
    public void testFileReading_OnlySpaces() {
        String fileContent = "   ";
        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());

        List<Double> actual = listReader.readLines(inputStream);

        Assertions.assertEquals(Collections.emptyList(), actual);
    }
}
