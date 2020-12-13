package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        Demo.print("PART2");
        Demo.print(' ');
        Demo.print("Convert result: " + System.lineSeparator() + convert(input));
        Demo.print(System.lineSeparator());
    }

    public static String convert(String input) {
        return "Min: " + getMinWords(input) + System.lineSeparator() +
                "Max: " + getMaxWords(input);
    }

    public static String getMinWords(String input) {
        StringBuilder minWords = new StringBuilder();
        StringBuilder regex = new StringBuilder("\\b\\w");
        Pattern pattern;
        Matcher matcher;

        while (minWords.toString().isEmpty()) {
            pattern = Pattern.compile(regex + "\\b");
            matcher = pattern.matcher(input);
            while (matcher.find()) {
                String temp = input.substring(matcher.start(), matcher.end());
                if (minWords.toString().contains(temp)) {
                    continue;
                }
                minWords.append(temp);
                minWords.append(", ");
            }
            regex.append("\\w");
        }

        if (minWords.length() == 0) {
            return "";
        }
        return minWords.delete(minWords.length() - 2, minWords.length()).toString();
    }

    public static String getMaxWords(String input) {
        StringBuilder maxWords = new StringBuilder();
        int maxLength = 0;
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        pattern = Pattern.compile("\\b\\w{" + maxLength + "}\\b");
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            String word = matcher.group();
            if (maxWords.toString().contains(word)) {
                continue;
            }
            maxWords.append(word).append(", ");
        }
        return maxWords.delete(maxWords.length() - 2, maxWords.length()).toString();
    }
}
