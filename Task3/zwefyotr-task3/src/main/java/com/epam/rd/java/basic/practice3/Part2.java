package com.epam.rd.java.basic.practice3;

import java.util.regex.Pattern;

public class Part2 {
    
    private static final String ANY_DELIMETR = "\\W+";
    

    public static void main(String[] args) {
        String inputString = Util.getInput("part2.txt");
        System.out.println(convert(inputString));
    }

    public static String convert(String input) {
        StringBuilder outputString = new StringBuilder();
        String[] words = input.split(ANY_DELIMETR);
        outputString.append("min: " + reciveWordsWithLenght(words, reciveMinLenghtWord(words)));
        outputString.append("\n");
        outputString.append("max: " + reciveWordsWithLenght(words, reciveMaxLenghtWord(words)));
        return outputString.toString();
        }
    
    private static int reciveMinLenghtWord(String[] words) {
       int minLenght = words[0].length();
       for (String word : words) {
           if (word.length() < minLenght) {
               minLenght = word.length();
           }
       }
       return minLenght;
    }
    
    private static int reciveMaxLenghtWord(String[] words) {
        int maxLenght = words[0].length();
        for (String word : words) {
            if (word.length() > maxLenght) {
                maxLenght = word.length();
            }
        }
        return maxLenght;
    }
    
    private static String reciveWordsWithLenght(String[] words, int lenght) {
        StringBuilder outputString = new StringBuilder();
        for (String word : words) {
            if (word.length() == lenght && !isUnique(word, outputString.toString())) {
                outputString.append(word + " ");
            }
        }
        return outputString.toString();
    }
    
    private static boolean isUnique (String word, String input) {
        return input.contains(word);
    }
}
