package it.tino.easysort.algorithms;

import it.tino.easysort.interfaces.SortingAlgorithm;

import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    @Override
    public void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(current) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }
}
