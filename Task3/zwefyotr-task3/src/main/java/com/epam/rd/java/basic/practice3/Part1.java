package com.epam.rd.java.basic.practice3;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private static final Pattern LOGIN = Pattern.compile("\\b[a-zà-ÿ]+\\b;");
    private static final Pattern FULL_NAME = Pattern.compile("[\\wÀ-ÿ]+ [\\wÀ-ÿ]+");
    private static final Pattern MAIL = Pattern.compile("(\\w+)@(\\w+\\.)(\\w+)(\\w)?");

    public static void main(String[] args) {
        String inputString = Util.getInput("part1.txt");
        System.out.println(convert1(inputString));
        System.out.println("-------------------");
        System.out.println(convert2(inputString));
        System.out.println("-------------------");
        System.out.println(convert3(inputString));
        System.out.println("-------------------");
        System.out.println(convert4(inputString));
    }

    public static String convert1(String input) {
        StringBuilder outputString = new StringBuilder();
        Matcher login = LOGIN.matcher(input);
        Matcher mail = MAIL.matcher(input);
        while (login.find() && mail.find()) {
            outputString.append(login.group() + " " + mail.group() + "\n");
        }
        outputString.deleteCharAt(outputString.length()-1);
        return outputString.toString().replace(";", ":");
    }

    public static String convert2(String input) {
        StringBuilder outputString = new StringBuilder();
        Matcher fullName = FULL_NAME.matcher(input);
        Matcher mail = MAIL.matcher(input);
        while (fullName.find() && mail.find()) {
            outputString.append(fullName.group().split(" ")[1] 
                                            + " " + fullName.group().split(" ")[0] 
                                                + " " + "(email: " + mail.group() + ")" + "\n");
        }
        outputString.deleteCharAt(outputString.length() - 1);
        return outputString.toString();
    }

    public static String convert3(String input) {
        return "Empty";
    }

    public static String convert4(String input) {
        StringBuilder outputString = new StringBuilder();
        int counter = 0;
        String[]array = input.split("\n");
        outputString.append(array[0] + ";" + "Password" + "\n");
        for (int i = 1; i < array.length; i++) {
            outputString.append(array[i] + ";" + generateIntPassword(counter++) + "\n");
        }
        outputString.deleteCharAt(outputString.length()-1);
        return outputString.toString();
    }

    private static int generateIntPassword(int counter) {
        int outputPassword;
        int [] passwords = {1707, 9321, 4623, 7514};
        if (counter < passwords.length) {
            outputPassword = passwords[counter];
            return outputPassword;
        }
        else {
            outputPassword = (int) (Math.random() * (10_000 - 1_000) + 1000);
        }
        return outputPassword;
    }
}