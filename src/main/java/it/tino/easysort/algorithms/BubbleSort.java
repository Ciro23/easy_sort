package it.tino.easysort.algorithms;

import it.tino.easysort.interfaces.Sort;

import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(List<T> list) {
        boolean bool = true;
        while (bool) {
            bool = false;
            for (int i = 0; i < list.size() - 1; i++) {
                T current = list.get(i);
                T successor = list.get(i + 1);

                if (current.compareTo(successor) > 0) {
                    bool = true;
                    Collections.swap(list, i, i + 1);
                }
            }
        }
    }
}
