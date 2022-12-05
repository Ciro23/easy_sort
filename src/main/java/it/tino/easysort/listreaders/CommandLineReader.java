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
    public List<String> readLines() {
        int i = 0;
        String selection;
        LinkedList<String> list = new LinkedList<>();

        do {
            out.println("Insert the element number " + ++i + ", or --stop to finish");
            selection = scanner.nextLine();

            if (!selection.equalsIgnoreCase("--stop")) {
                list.addLast(selection);
            }

        } while (scanner.hasNext() && !selection.equalsIgnoreCase("--stop"));

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
