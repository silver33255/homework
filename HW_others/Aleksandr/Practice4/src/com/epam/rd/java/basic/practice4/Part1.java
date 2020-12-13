package com.epam.rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	public static void main(String[] args) {
		String input;
		input = Demo.readFile("part1.txt");
		String regex = "\\b[a-zA-Z0-9à-ÿÀ-ß¸¿]+\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			String word = matcher.group();
			if (word.length() > 3)
				input = input.replace(word, word.substring(2));
		}
		Demo.println(input);
	}

}
