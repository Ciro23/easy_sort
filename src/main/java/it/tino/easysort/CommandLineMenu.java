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
    private final SortingAlgorithm<Double> defaultAlgorithm;

    private final Map<String, SortingAlgorithm<Double>> sortingAlgorithms = new HashMap<>();

    public CommandLineMenu(
            PrintStream out,
            SortingAlgorithm<Double> bubbleSort,
            SortingAlgorithm<Double> insertionSort,
            ListReader listReader,
            RealTimeListReader realTimeListReader
    ) {
        this.out = out;
        this.defaultAlgorithm = bubbleSort;
        this.listReader = listReader;
        this.realTimeListReader = realTimeListReader;

        sortingAlgorithms.put("bubble", bubbleSort);
        sortingAlgorithms.put("insertion", insertionSort);
    }

    @Override
    public void handleUserRequest(String[] args) {
        List<Double> list;
        String algorithmName;

        if (args.length == 0) {
            algorithmName = realTimeListReader.readSortingAlgorithm();
            list = realTimeListReader.readLines();
        } else {
            algorithmName = args[0];
            try {
                File file = new File(args[1]);
                list = listReader.readLines(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                list = Collections.emptyList();
            }
        }

        SortingAlgorithm<Double> sortingAlgorithm = sortingAlgorithms.getOrDefault(algorithmName, defaultAlgorithm);

        long start = System.currentTimeMillis();

        sortingAlgorithm.sort(list);

        long end = System.currentTimeMillis();
        long elapsed = end - start;

        displayResult(list, sortingAlgorithm.getName(), elapsed);
    }

    private void displayResult(List<Double> list, String name, long elapsed) {
        out.println("Used " + name + ", execution time: " + elapsed + "ms");
        int i = 0;
        for (Double element : list) {
            out.println(++i + ". " + element);
        }
    }
}
