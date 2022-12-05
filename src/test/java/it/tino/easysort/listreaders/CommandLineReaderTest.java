package it.tino.easysort.listreaders;

import it.tino.easysort.interfaces.RealTimeListReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class CommandLineReaderTest {

    // so that no application output is shown in the console during tests
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final String simulatedUserInput = "first" + System.getProperty("line.separator") + "--stop";

    private final Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));

    private final RealTimeListReader listReader = new CommandLineReader(new PrintStream(out), scanner);

    @Test
    public void testCommandLineReading() {
        LinkedList<String> expected = new LinkedList<>(Arrays.asList(simulatedUserInput.split(System.getProperty("line.separator"))));
        // last input is the command to stop
        expected.removeLast();

        List<String> actual = listReader.readLines();

        Assertions.assertEquals(expected, actual);
    }
}
