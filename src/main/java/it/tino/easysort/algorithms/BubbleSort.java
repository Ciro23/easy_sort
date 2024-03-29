package it.tino.easysort.algorithms;

import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    @Override
    public void sort(List<T> list) {
        boolean shouldSort = true;
        while (shouldSort) {
            shouldSort = false;
            for (int i = 0; i < list.size() - 1; i++) {
                T current = list.get(i);
                T successor = list.get(i + 1);

                if (current.compareTo(successor) > 0) {
                    shouldSort = true;
                    Collections.swap(list, i, i + 1);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble sort";
    }
}
