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

    private final String simulatedUserInput;
    private final RealTimeListReader listReader;

    public CommandLineReaderTest() {
        simulatedUserInput = "1" + System.getProperty("line.separator") + "--stop";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        // so that no application output is shown in the console during tests
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        listReader = new CommandLineReader(new PrintStream(out), scanner);
    }

    @Test
    public void testCommandLineReading() {
        String lineSeparator = System.getProperty("line.separator");
        List<String> lines = Arrays.asList(simulatedUserInput.split(lineSeparator));

        LinkedList<Double> expected = convertUserInput(new LinkedList<>(lines));
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
