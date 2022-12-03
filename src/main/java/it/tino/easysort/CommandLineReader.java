package it.tino.easysort;

import it.tino.easysort.interfaces.RealTimeListReader;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CommandLineReader implements RealTimeListReader {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> readLines() {
        int i = 0;
        String selection = "while_gotta_start";
        LinkedList<String> list = new LinkedList<>();

        while (!selection.isEmpty()) {
            System.out.println("Insert the element number " + ++i + ", or press ENTER to finish");
            selection = scanner.next();

            if (!selection.isEmpty()) {
                list.addLast(selection);
            }
        }
        return list;
    }
}
