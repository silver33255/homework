package com.epam.rd.java.basic.practice4;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        String part1 = Demo.Utils.getInputFromFile("part1.txt");
        Pattern pattern = Pattern.compile("\\p{L}{4,}");
        Matcher matcher = pattern.matcher(part1);

        while (matcher.find()) {
            String target = matcher.group();
            part1 = part1.replace(target, target.substring(2));
        }
        Arrays.stream(part1.split(System.lineSeparator())).forEach(Demo::println);
    }
}
