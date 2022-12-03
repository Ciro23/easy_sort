package it.tino.easysort;

import it.tino.easysort.interfaces.ListReader;
import it.tino.easysort.interfaces.Menu;
import it.tino.easysort.interfaces.SortingAlgorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class CommandLineMenu implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final ListReader listReader;
    private final SortingAlgorithm<String> bubbleSort;
    private final SortingAlgorithm<String> insertionSort;

    private final Map<String, SortingAlgorithm<String>> sortingAlgorithms = new HashMap<>();

    public CommandLineMenu(
        SortingAlgorithm<String> bubbleSort,
        SortingAlgorithm<String> insertionSort,
        ListReader listReader
    ) {
        this.bubbleSort = bubbleSort;
        this.insertionSort = insertionSort;
        this.listReader = listReader;

        sortingAlgorithms.put("bubble", bubbleSort);
        sortingAlgorithms.put("insertion", insertionSort);
    }

    @Override
    public void handleUserRequest(String[] args) {
        List<String> list;

        try {
            File file = new File(args[1]);
            list = listReader.readLines(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            list = Collections.emptyList();
        }

        SortingAlgorithm<String> sortingAlgorithm = sortingAlgorithms.getOrDefault(args[0], bubbleSort);
        sortingAlgorithm.sort(list);

        displayResult(list, sortingAlgorithm.getName());
    }

    private void displayResult(List<String> list, String name) {
        System.out.println("Used " + name);
        int i = 0;
        for (String element : list) {
            System.out.println(++i + ". " + element);
        }
    }
}
