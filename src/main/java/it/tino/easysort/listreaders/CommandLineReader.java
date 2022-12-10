package it.tino.easysort.listreaders;

import it.tino.easysort.interfaces.RealTimeListReader;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CommandLineReader implements RealTimeListReader {

    private final PrintStream out;
    private final Scanner scanner;

    public CommandLineReader(PrintStream out, Scanner scanner) {
        this.out = out;
        this.scanner = scanner;
    }

    @Override
    public List<Double> readLines() {
        int i = 0;
        Double selection;
        LinkedList<Double> list = new LinkedList<>();

        while (true) {
            out.println("Insert the element number " + ++i + ", or --stop to finish");
            String lineEntered = scanner.nextLine();

            if (lineEntered.equalsIgnoreCase("--stop")) {
                break;
            } else {
                try {
                    list.addLast(Double.valueOf(lineEntered));
                } catch (NumberFormatException ignore) {}
            }
        };

        return list;
    }

    @Override
    public String readSortingAlgorithm() {
        out.println("Choose the sorting algorithm");
        out.println("(Bubble) sort");
        out.println("(Insertion) sort");

        return scanner.nextLine();
    }
}
