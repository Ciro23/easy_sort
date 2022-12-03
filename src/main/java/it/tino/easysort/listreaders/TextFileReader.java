package it.tino.easysort.listreaders;

import it.tino.easysort.interfaces.ListReader;

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
    public List<String> readLines(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        LinkedList<String> list = new LinkedList<>();
        try {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine().trim();

                if (!line.isEmpty()) {
                    list.addLast(line);
                }
            }
        } catch (IOException e) {
            return Collections.emptyList();
        }

        return list;
    }
}
