package com.epam.rd.java.basic.practice4;

import java.util.Scanner;

public class Part6 {

    public static void main(String[] args) {
        String[] words = Demo.Utils.getInputFromFile("part6.txt").split("[\\s\\t\\.\\?!,=+\\-_\\(\\)]");
        Scanner scanner = new Scanner(Syst\u0065m.in);
        String nextLine;
        StringBuilder output;

        while (scanner.hasNext() && !"stop".equals(nextLine = scanner.nextLine())) {
            Character.UnicodeBlock unicodeBlock;
            output = new StringBuilder(nextLine).append(": ");
            if ("latn".equalsIgnoreCase(nextLine)) {
                unicodeBlock = Character.UnicodeBlock.BASIC_LATIN;
            } else if ("cyrl".equalsIgnoreCase(nextLine)) {
                unicodeBlock = Character.UnicodeBlock.CYRILLIC;
            } else {
                unicodeBlock = Character.UnicodeBlock.ARROWS;
            }
            appendFilteredWords(unicodeBlock, words, output);
            Demo.println(output.toString());
        }
        scanner.close();
    }

    private static void appendFilteredWords(Character.UnicodeBlock unicodeBlock, String[] words, StringBuilder output) {
        if (Character.UnicodeBlock.ARROWS.equals(unicodeBlock)) {
            output.append("Incorrect input");
            return;
        }
        for (String word : words) {
            if (word.length() > 0 && Character.UnicodeBlock.of(word.charAt(0)).equals(unicodeBlock)) {
                output.append(word).append(' ');
            }
        }
    }

}
