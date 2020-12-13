package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        String part3 = Demo.Utils
                .getInputFromFile("part3.txt")
                .replaceAll("\\s", "  ");
        String nextLine;
        String regex;
        Matcher matcher;
        Scanner scanner = new Scanner(Syst\u0065m.in);

        while (scanner.hasNext() && !"stop".equals(nextLine = scanner.nextLine())) {
            if ("char".equals(nextLine)) {
                regex = "(\\s|^)\\p{L}(\\s|$)";
            } else if ("String".equals(nextLine)) {
                regex = "(\\s|^)\\p{L}{2,}(\\s|$)";
            } else if ("int".equals(nextLine)) {
                regex = "(\\s|^)\\d+(\\s|$)";
            } else if ("double".equals(nextLine)) {
                regex = "(\\s|^)\\d*\\.\\d+(\\s|$)";
            } else {
                Demo.println("Incorrect input");
                continue;
            }

            StringBuilder stringBuilder = new StringBuilder();
            matcher = Pattern.compile(regex).matcher(part3);
            while (matcher.find()) {
                stringBuilder.append(matcher.group().trim()).append(" ");
            }

            Demo.println(stringBuilder.toString());
        }
        scanner.close();
    }
}
