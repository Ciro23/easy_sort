package it.tino.easysort.listreaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TextFileReader implements ListReader {

    /**
     * Reads an inputStream into a list of non-empty lines
     */
    @Override
    public List<Double> readLines(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        LinkedList<Double> list = new LinkedList<>();
        try {
            while (bufferedReader.ready()) {
                try {
                    Double line = Double.valueOf(bufferedReader.readLine().trim());
                    list.addLast(line);
                } catch (NumberFormatException ignore) {}
            }
        } catch (IOException e) {
            return Collections.emptyList();
        }

        return list;
    }
}
