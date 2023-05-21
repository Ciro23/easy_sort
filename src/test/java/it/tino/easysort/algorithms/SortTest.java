package it.tino.easysort.algorithms;

import it.tino.easysort.interfaces.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public abstract class SortTest {

    protected abstract SortingAlgorithm<Integer> getSortingAlgorithm();

    @Test
    public void testBubbleSort() {
        List<Integer> list = Arrays.asList(10, 2, 3, 1, 9, 5);

        SortingAlgorithm<Integer> sortingAlgorithm = getSortingAlgorithm();
        sortingAlgorithm.sort(list);

        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 9, 10);
        Assertions.assertEquals(expected, list);
    }
}
