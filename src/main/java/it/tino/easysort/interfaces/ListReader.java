package it.tino.easysort.interfaces;

import java.io.InputStream;
import java.util.List;

public interface ListReader {

    List<String> readLines(InputStream inputStream);
}
