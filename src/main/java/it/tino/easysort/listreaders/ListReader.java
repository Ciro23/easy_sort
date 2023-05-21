package it.tino.easysort.listreaders;

import java.io.InputStream;
import java.util.List;

public interface ListReader {

    List<Double> readLines(InputStream inputStream);
}
