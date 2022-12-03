package it.tino.easysort.algorithms;

import it.tino.easysort.TextFileReader;
import it.tino.easysort.interfaces.ListReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextFileReaderTest {

    @Test
    public void testFileReading() {
        ListReader listReader = new TextFileReader();

        List<String> expected = Arrays.asList("first_line", "second_line", "third_line");

        String fileContent = String.join("\n", expected);
        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());

        List<String> actual = listReader.readLines(inputStream);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFileReading_OnlySpaces() {
        ListReader listReader = new TextFileReader();

        String fileContent = "   ";
        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());

        List<String> actual = listReader.readLines(inputStream);

        Assertions.assertEquals(Collections.emptyList(), actual);
    }
}
