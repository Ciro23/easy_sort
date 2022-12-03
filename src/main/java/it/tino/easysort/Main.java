package it.tino.easysort;

import it.tino.easysort.algorithms.BubbleSort;
import it.tino.easysort.interfaces.ListReader;
import it.tino.easysort.interfaces.Menu;
import it.tino.easysort.interfaces.RealTimeListReader;
import it.tino.easysort.interfaces.SortingAlgorithm;

public class Main {

    public static void main(String[] args) {
        SortingAlgorithm<String> bubbleSort = new BubbleSort<>();
        SortingAlgorithm<String> insertionSort = new BubbleSort<>();
        ListReader textFileReader = new TextFileReader();
        RealTimeListReader commandLineReader = new CommandLineReader();

        Menu menu = new CommandLineMenu(
            bubbleSort,
            insertionSort,
            textFileReader,
            commandLineReader
        );
        menu.handleUserRequest(args);
    }
}