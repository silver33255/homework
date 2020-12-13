package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

	public static void main(String[] args) {
		//useless method
        throw new UnsupportedOperationException();
	}

	public static String convert(String input) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (String str : input.split("\\W+")) {
			if (str.length() < min) {
				min = str.length();
			}
			if (str.length() > max) {
				max = str.length();
				System.out.println(str + " | " + str.length());
			}
		}
		StringBuilder result = new StringBuilder();
		String minRegex = "(?s)(\\b\\w{" + min + "}\\b)(?!.*\\b\\1\\b)";
		String maxRegex = "(?s)(\\b\\w{" + max + "}\\b)(?!.*\\b\\1\\b)";
		Pattern maxPattern = Pattern.compile(maxRegex);
		Matcher maxMatcher = maxPattern.matcher(input);
		result.append("Max: ");
		while (maxMatcher.find()) {
			result.append(maxMatcher.group(1) + ", ");
		}

		result.deleteCharAt(result.length() - 1);
		result.deleteCharAt(result.length() - 1);
		Pattern minPattern = Pattern.compile(minRegex);
		Matcher minMatcher = minPattern.matcher(input);
		StringBuilder temp = new StringBuilder();

		int lastIndex = Integer.MAX_VALUE;
		while (minMatcher.find()) {
			if (input.indexOf(minMatcher.group(1)) < lastIndex) {
				lastIndex = input.indexOf(minMatcher.group(1));
				temp.insert(0, minMatcher.group(1) + ", ");
			} else {
				lastIndex = input.indexOf(minMatcher.group(1));
				temp.append(minMatcher.group(1) + ", ");
			}
		}
		temp.insert(0, "Min: ");
		temp.deleteCharAt(temp.length() - 1);
		temp.deleteCharAt(temp.length() - 1);
		temp.append("\n");
		result.insert(0, temp.toString());
		return result.toString();
	}
}
