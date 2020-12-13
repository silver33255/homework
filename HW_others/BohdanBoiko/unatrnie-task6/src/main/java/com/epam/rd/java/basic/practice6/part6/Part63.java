package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.Collections;

public class Part63{
    private final String fileContent;

    public Part63(String fileContent) {
        this.fileContent = fileContent;
    }

    public void printDuplicates() {
        String[] words = fileContent.split("\\s+");
        Arrays.stream(words)
                .filter(w -> Collections.frequency(Arrays.asList(words), w) > 1)
                .distinct()
                .limit(3)
                .map(String::toUpperCase)
                .map(w -> new StringBuilder(w).reverse().toString())
                .forEach(System.out::println);
    }
}
