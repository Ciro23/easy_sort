package it.tino.easysort.listreaders;

import it.tino.easysort.interfaces.RealTimeListReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CommandLineReaderTest {

    // so that no application output is shown in the console during tests
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final String simulatedUserInput = "first" + System.getProperty("line.separator") + "second";

    private final Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));

    private final RealTimeListReader listReader = new CommandLineReader(new PrintStream(out), scanner);

    @Test
    public void testCommandLineReading() {
        List<String> expected = Arrays.asList(simulatedUserInput.split(System.getProperty("line.separator")));

        List<String> actual = listReader.readLines();

        Assertions.assertEquals(expected, actual);
    }
}
