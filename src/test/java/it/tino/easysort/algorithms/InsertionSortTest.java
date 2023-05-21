package it.tino.easysort.algorithms;

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
