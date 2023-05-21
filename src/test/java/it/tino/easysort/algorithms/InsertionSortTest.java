package it.tino.easysort.algorithms;

import it.tino.easysort.interfaces.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InsertionSortTest extends SortTest {

    private final SortingAlgorithm<Integer> insertionSort;

    public InsertionSortTest() {
        insertionSort = new InsertionSort<>();
    }

    @Override
    protected SortingAlgorithm<Integer> getSortingAlgorithm() {
        return insertionSort;
    }
}
