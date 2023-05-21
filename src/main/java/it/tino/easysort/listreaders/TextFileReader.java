package it.tino.easysort.listreaders;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TextFileReader implements ListReader {

    private final PrintStream out;

    public TextFileReader(PrintStream out) {
        this.out = out;
    }

    /**
     * Reads an inputStream into a list of non-empty lines
     */
    @Override
    public List<Double> readLines(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        LinkedList<Double> list = new LinkedList<>();
        try {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine().trim();
                try {
                    Double value = Double.valueOf(line);
                    list.addLast(value);
                } catch (NumberFormatException e) {
                    out.println("[WARN] Could not read inconvertible value '" + line + "'");
                }
            }
        } catch (IOException e) {
            return Collections.emptyList();
        }

        return list;
    }
}
