package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVwriter {
    public static void print(FileWriter output, Map<String, Integer> sortedMap, int totalWords) throws IOException {


        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            output.write(entry.getKey() + "," + entry.getValue() + "," + Math.ceil((double) entry.getValue() / totalWords * 100 * 100) / 100 + "%\n");
        }
        output.close();
    }
}