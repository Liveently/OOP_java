package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapSorter {
    public static Map<String, Integer> byValue (Map<String, Integer> unsortedMap) {
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(unsortedMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}