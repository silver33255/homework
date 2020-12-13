package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String input = Util.getInputForPart6("part6.txt");
        Demo.print("PART6");
        Demo.print(' ');
        Demo.print("Convert result: " + System.lineSeparator() + convert(input));
        Demo.print(System.lineSeparator());
    }

    public static String convert(String input) {
        Pattern pattern;
        Matcher matcher;
        for (String word : input.split("\\s+")) {
            pattern = Pattern.compile("\\b" + word + "\\b");
            matcher = pattern.matcher(input);
            int i = 0;
            while (matcher.find()) {
                i++;
            }
            if (i > 1) {
                input = input.replaceAll("\\b" + word + "\\b", '_' + word);
            }
        }
        return input;

    }
}
