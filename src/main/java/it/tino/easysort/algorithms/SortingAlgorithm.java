package it.tino.easysort.algorithms;

import java.util.List;

public interface SortingAlgorithm<T extends Comparable<T>> {

    void sort(List<T> list);

    String getName();
}
