package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    private static final Pattern CHARACTERS = Pattern.compile("\\b\\p{L}\\b");
    private static final Pattern STRING = Pattern.compile("(?<=|^)[a-zA-Z\\u0400-\\u04FF_]{2,}(?=|$)");
    private static final Pattern INTEGER = Pattern.compile("(^|\\s)([0-9]+)(?=$|\\s)");
    private static final Pattern DOUBLE = Pattern.compile("\\d+\\.\\d+");

    public static void main(String[] args) {
        String inputString = Demo.getInput("part3.txt");

        Scanner sc = new Scanner(System.in);
        String typeOutputData = null;
        while (!(typeOutputData = sc.nextLine()).equalsIgnoreCase("Stop")) {
            Matcher match = null;
            StringBuilder outputString = new StringBuilder();
            if (typeOutputData.equalsIgnoreCase("string")) {
                match = STRING.matcher(inputString);
            } else if (typeOutputData.equalsIgnoreCase("int")) {
                match = INTEGER.matcher(inputString);
            } else if (typeOutputData.equalsIgnoreCase("double")) {
                match = DOUBLE.matcher(inputString);
            } else if (typeOutputData.equalsIgnoreCase("char")) {
                match = CHARACTERS.matcher(inputString);
            }
            if (match == null) {
                outputString.append("Incorrect input");
            } else {
                while (match.find()) {
                    outputString.append(match.group().trim() + " ");
                }
            }
            System.out.println(outputString);
        }
        sc.close();
    }
}
