package interfaces;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface Sort<T extends Comparable<T>> {

    void sort(List<T> list);
}
