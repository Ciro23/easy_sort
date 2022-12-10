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

    private final String simulatedUserInput = "1" + System.getProperty("line.separator") + "--stop";

    private final Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));

    private final RealTimeListReader listReader = new CommandLineReader(new PrintStream(out), scanner);

    @Test
    public void testCommandLineReading() {
        LinkedList<Double> expected = convertUserInput(new LinkedList<>(Arrays.asList(simulatedUserInput.split(System.getProperty("line.separator")))));

        List<Double> actual = listReader.readLines();

        Assertions.assertEquals(expected, actual);
    }

    private LinkedList<Double> convertUserInput(LinkedList<String> userInput) {
        // last input is the command to stop
        userInput.removeLast();

        LinkedList<Double> converted = new LinkedList<>();
        for (String input : userInput) {
            converted.addLast(Double.valueOf(input));
        }

        return converted;
    }
}
