package it.tino.easysort.algorithms;

import it.tino.easysort.interfaces.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BubbleSortTest extends SortTest {

    private final SortingAlgorithm<Integer> bubbleSort;

    public BubbleSortTest() {
        bubbleSort = new BubbleSort<>();
    }

    @Override
    protected SortingAlgorithm<Integer> getSortingAlgorithm() {
        return bubbleSort;
    }
}
