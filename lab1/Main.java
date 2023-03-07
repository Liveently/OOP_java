package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        try {
            InputStreamReader input = new InputStreamReader(new FileInputStream("src/input.txt"));
            WordParser parser = new WordParser();
            Map<String, Integer> words = parser.parseFile(input);
            Map<String, Integer> sortedWords = MapSorter.byValue(words);
            FileWriter output = new FileWriter("src/output.csv", false);
            CSVwriter.print(output, sortedWords, parser.getWordsCounter());
        }
        catch (IOException err) {
            err.printStackTrace();
        }
    }
}