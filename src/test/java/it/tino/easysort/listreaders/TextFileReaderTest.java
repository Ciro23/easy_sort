package it.tino.easysort.listreaders;

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

        List<String> lines = Arrays.asList("1", "2", "3");

        String fileContent = String.join("\n", lines);
        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());

        List<Double> actual = listReader.readLines(inputStream);

        Assertions.assertEquals(Arrays.asList(1d, 2d, 3d), actual);
    }

    @Test
    public void testFileReading_OnlySpaces() {
        ListReader listReader = new TextFileReader();

        String fileContent = "   ";
        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());

        List<Double> actual = listReader.readLines(inputStream);

        Assertions.assertEquals(Collections.emptyList(), actual);
    }
}
