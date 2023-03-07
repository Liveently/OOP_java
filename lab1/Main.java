package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("no files");
            return;
        }

        try (InputStreamReader input = new InputStreamReader(new FileInputStream(args[0]));
             FileWriter output = new FileWriter(args[1], false);) {
            WordParser parser = new WordParser();
            Map<String, Integer> words = parser.parseFile(input);
            Map<String, Integer> sortedWords = MapSorter.byValue(words);
            CSVwriter.print(output, sortedWords, parser.getWordsCounter());
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}