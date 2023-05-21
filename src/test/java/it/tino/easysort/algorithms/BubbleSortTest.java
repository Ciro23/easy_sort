package it.tino.easysort.algorithms;

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
