package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.stream.Collectors;

public class Part61{
    private final String fileContent;

    public Part61(String fileContent) {
        this.fileContent = fileContent;
    }

    public void printFrequencies() {
        String[] words = fileContent.split("\\s+");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Integer[] frequencies = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getValue)
                .toArray(Integer[]::new);

        Map<String, Integer> resultMap = new HashMap<>();
        for (Integer frequency : frequencies) {
            resultMap.put(getAndDeleteFirstKeyByValue(map, frequency), frequency);
        }

        printResultFromMap(resultMap);
    }

    private static void printResultFromMap(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(e -> System.out.println(e.getKey() + " ==> " + e.getValue()));
    }

    private static <T, E> T getAndDeleteFirstKeyByValue(Map<T, E> map, E value) {
        T key = map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(0);
        map.remove(key);
        return key;
    }
}
