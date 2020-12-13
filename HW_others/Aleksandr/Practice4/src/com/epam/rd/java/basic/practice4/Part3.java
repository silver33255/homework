package com.epam.rd.java.basic.practice4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	public static void main(String[] args) {

		String stringRegex = "\\b([a-zA-Zà-ÿÀ-ß¸¿]{2,100})\\s\\b";
		String charRegex = "\\b([a-zA-Zà-ÿÀ-ß¸¿]{1})\\s\\b";
		String intRegex = "\\s[+-]?(\\d+)\\s";
		String doubleRegex = "[+-]?([0-9]*[.][0-9]+)";

		Pattern stringPattern = Pattern.compile(stringRegex);
		Pattern charPattern = Pattern.compile(charRegex);
		Pattern intPattern = Pattern.compile(intRegex);
		Pattern doublePattern = Pattern.compile(doubleRegex);

		String input;
		input = Demo.readFile("part3.txt");
		Matcher stringMatcher = stringPattern.matcher(input);
		Matcher charMatcher = charPattern.matcher(input);
		Matcher intMatcher = intPattern.matcher(input);
		Matcher doubleMatcher = doublePattern.matcher(input);

		List<String> strings = new ArrayList<>();
		List<String> chars = new ArrayList<>();
		List<String> ints = new ArrayList<>();
		List<String> doubles = new ArrayList<>();

		Thread tr1 = new Thread(() -> {
			while (stringMatcher.find()) {
				strings.add(stringMatcher.group(1));
			}
		});
		Thread tr2 = new Thread(() -> {
			while (charMatcher.find()) {
				chars.add(charMatcher.group(1));
			}
		});
		Thread tr3 = new Thread(() -> {
			while (intMatcher.find()) {
				ints.add(intMatcher.group(1));
			}
		});
		Thread tr4 = new Thread(() -> {
			while (doubleMatcher.find()) {
				doubles.add(doubleMatcher.group(1));
			}
		});
		tr1.start();
		tr2.start();
		tr3.start();
		tr4.start();
		boolean flag = tr1.getState().ordinal() != 5 || tr2.getState().ordinal() != 5 || tr3.getState().ordinal() != 5
				|| tr4.getState().ordinal() != 5;
		while (flag) {
			flag = tr1.getState().ordinal() != 5 || tr2.getState().ordinal() != 5 || tr3.getState().ordinal() != 5
					|| tr4.getState().ordinal() != 5;
		}

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (!str.equalsIgnoreCase("stop")) {
			switch (str.toLowerCase()) {
			case "char":
				Demo.println(chars.toString().replace("[", "").replace("]", "").replace(",", "").concat(" "));
				break;
			case "int":
				Demo.println(ints.toString().replace("[", "").replace("]", "").replace(",", "").concat(" "));
				break;
			case "double":
				Demo.println(doubles.toString().replace("[", "").replace("]", "").replace(",", "").concat(" "));
				break;
			case "string":
				Demo.println(strings.toString().replace("[", "").replace("]", "").replace(",", "").concat(" "));
				break;
			default:
				Demo.println("Incorrect input");
			}
			str = sc.nextLine();
		}
		sc.close();
	}

}
