package it.tino.easysort;

import it.tino.easysort.interfaces.ListReader;
import it.tino.easysort.interfaces.Menu;
import it.tino.easysort.interfaces.RealTimeListReader;
import it.tino.easysort.interfaces.SortingAlgorithm;

import java.io.*;
import java.util.*;

public class CommandLineMenu implements Menu {
    
    private final PrintStream out;
    private final ListReader listReader;
    private final RealTimeListReader realTimeListReader;
    private final SortingAlgorithm<String> bubbleSort;
    private final SortingAlgorithm<String> insertionSort;

    private final Map<String, SortingAlgorithm<String>> sortingAlgorithms = new HashMap<>();

    public CommandLineMenu(
            PrintStream out,
            SortingAlgorithm<String> bubbleSort,
            SortingAlgorithm<String> insertionSort,
            ListReader listReader,
            RealTimeListReader realTimeListReader
    ) {
        this.out = out;
        this.bubbleSort = bubbleSort;
        this.insertionSort = insertionSort;
        this.listReader = listReader;
        this.realTimeListReader = realTimeListReader;

        sortingAlgorithms.put("bubble", this.bubbleSort);
        sortingAlgorithms.put("insertion", this.insertionSort);
    }

    @Override
    public void handleUserRequest(String[] args) {
        List<String> list;

        if (args.length == 0) {
            list = realTimeListReader.readLines();
        } else {
            try {
                File file = new File(args[1]);
                list = listReader.readLines(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                list = Collections.emptyList();
            }
        }

        SortingAlgorithm<String> sortingAlgorithm = sortingAlgorithms.getOrDefault(args[0], bubbleSort);
        sortingAlgorithm.sort(list);

        displayResult(list, sortingAlgorithm.getName());
    }

    private void displayResult(List<String> list, String name) {
        out.println("Used " + name);
        int i = 0;
        for (String element : list) {
            out.println(++i + ". " + element);
        }
    }
}
