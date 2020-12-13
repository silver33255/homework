package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;

public class Part62 {
    private final String fileContent;

    public Part62(String fileContent) {
        this.fileContent = fileContent;
    }

    public void printLengths() {
        String[] words = fileContent.split("\\s+");
        Arrays.stream(words)
                .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
                .limit(3)
                .forEach(w -> System.out.println(w + " ==> " + w.length()));
    }
}

