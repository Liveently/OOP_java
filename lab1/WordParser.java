package org.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class WordParser {
    private int wordsCounter;

    WordParser() {
        wordsCounter = 0;
    }

    public Map<String, Integer> parseFile (InputStreamReader input) throws IOException {
        Map<String, Integer> words = new HashMap<String, Integer>();
        StringBuilder newWord = new StringBuilder();
        int notNewLetter = input.read();
        char newLetter;

        while (notNewLetter != -1) {
            newLetter = (char)notNewLetter;
            if (Character.isLetterOrDigit(newLetter)) {
                newWord.append(newLetter);
            }
            else if (!newWord.isEmpty()) {
                words.merge(newWord.toString(), 1, Integer::sum);
                newWord.setLength(0);
                wordsCounter++;
            }
            notNewLetter = input.read();
        }

        if (newWord.length() > 0) {
            words.merge(newWord.toString(), 1, Integer::sum);
            newWord.setLength(0);
            wordsCounter++;
        }

        return words;
    }

    int getWordsCounter() {
        return wordsCounter;
    }
}