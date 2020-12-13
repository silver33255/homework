package com.epam.rd.java.basic.practice6.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part1 {

	private static final Pattern STRING = Pattern
			.compile("(?<=|^)[a-zA-Z\\u0400-\\u04FF_]{2,}(?=|$)");

	public static void main(String[] args) {
		WordContainer wordContainer = new WordContainer();
		StringBuilder inputText = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String buffer = new String();
		while(!(buffer = sc.nextLine()).contains("Stop")) {
			inputText.append(buffer + "\n");
		};
		sc.close();
		Matcher match = STRING.matcher(inputText.toString());
		List<String> words = new ArrayList<>();
		while (match.find()) {
			words.add(match.group());
		}
		
		words.stream()
		.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
		.entrySet().stream().forEach(x -> wordContainer
				.add(new Word(x.getKey(), x.getValue().intValue())));
		System.out.println(wordContainer);
	}
}
