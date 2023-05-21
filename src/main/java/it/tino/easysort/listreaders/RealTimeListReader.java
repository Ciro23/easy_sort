package it.tino.easysort.listreaders;

import java.util.List;

public interface RealTimeListReader {

    List<Double> readLines();

    String readSortingAlgorithm();
}
