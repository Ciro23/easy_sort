package it.tino.easysort.interfaces;

import java.util.List;

public interface SortingAlgorithm<T extends Comparable<T>> {

    void sort(List<T> list);

    String getName();
}
