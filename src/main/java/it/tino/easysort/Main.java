package it.tino.easysort;

import it.tino.easysort.algorithms.BubbleSort;
import it.tino.easysort.algorithms.InsertionSort;
import it.tino.easysort.listreaders.ListReader;
import it.tino.easysort.menu.Menu;
import it.tino.easysort.listreaders.RealTimeListReader;
import it.tino.easysort.algorithms.SortingAlgorithm;
import it.tino.easysort.listreaders.CommandLineReader;
import it.tino.easysort.listreaders.TextFileReader;
import it.tino.easysort.menu.CommandLineMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SortingAlgorithm<Double> bubbleSort = new BubbleSort<>();
        SortingAlgorithm<Double> insertionSort = new InsertionSort<>();
        ListReader textFileReader = new TextFileReader(System.out);
        RealTimeListReader commandLineReader = new CommandLineReader(System.out, new Scanner(System.in));

        Menu menu = new CommandLineMenu(
            System.out,
            bubbleSort,
            insertionSort,
            textFileReader,
            commandLineReader
        );
        menu.handleUserRequest(args);
    }
}