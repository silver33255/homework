package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    private static final Pattern WORD = Pattern.compile("[A-zÀ-ÿ]{3,}");
    private static int FIRST_LETTER = 0;

    public static void main(String[] args) {
        String pathToFile = "part3.txt";
        System.out.println(Part3.convert(Util.getInput(pathToFile)));

    }

    public static String convert(String input) {
        StringBuilder outputText = new StringBuilder(input);
        Matcher match = WORD.matcher(outputText);
        while (match.find()) {
            if (Character.isUpperCase(match.group().charAt(FIRST_LETTER))) {
                outputText.setCharAt(match.start(), Character.toLowerCase(match.group().charAt(FIRST_LETTER)));
            } else {
                outputText.setCharAt(match.start(), Character.toUpperCase(match.group().charAt(FIRST_LETTER)));
            }
            ;
        }
        return outputText.toString();
    }
}
