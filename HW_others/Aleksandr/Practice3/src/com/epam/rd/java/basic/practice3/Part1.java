package com.epam.rd.java.basic.practice3;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {

	public static final String REGEX = "(\\p{L}+);(\\p{L}+)\\s(\\p{L}+);(\\p{L}+)[._]?@(\\p{L}+.\\p{L}+)";
	public static final Pattern pattern = Pattern.compile(REGEX);
	
	public static void main(String[] args) {
		//useless method
        throw new UnsupportedOperationException();
	}

	public static String convert1(String input) {
		StringBuilder result = new StringBuilder();
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			result.append(matcher.group(1));
			result.append(": ");
			result.append(matcher.group(4));
			result.append("@");
			result.append(matcher.group(5));
			result.append("\n");
		}
		return result.toString();
	}

	public static String convert2(String input) {
		StringBuilder result = new StringBuilder();
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			result.append(matcher.group(3));
			result.append(" ");
			result.append(matcher.group(2));
			result.append(" (email: ");
			result.append(matcher.group(4));
			result.append("@");
			result.append(matcher.group(5));
			result.append(")\n");
		}
		return result.toString();
	}

	public static String convert3(String input) {
		StringBuilder result = new StringBuilder("");
		Pattern emailPattern = Pattern.compile("(?s)[@](\\b\\p{L}+.\\p{L}+\\b)(?!.*\\1\\b)");
		Matcher emailMatcher = emailPattern.matcher(input);
		while(emailMatcher.find()) {
			Pattern pattern = Pattern.compile("(\\p{L}+);(\\p{L}+)\\s(\\p{L}+);(\\p{L}+)[._]?@("+emailMatcher.group(1)+")");
			Matcher matcher = pattern.matcher(input);
			StringBuilder email = new StringBuilder();
			email.append(emailMatcher.group(1) + " ==> ");
			while(matcher.find()) {
				email.append(matcher.group(1).toLowerCase()+", ");
			}
			email.deleteCharAt(email.length()-1);
			email.deleteCharAt(email.length()-1);
			email.append("\n");
			result.insert(0, email.toString());
		}
		return result.toString();
	}

	public static String convert4(String input) {
		StringBuilder result = new StringBuilder();
		result.append("Login;Name;Email;Password\n");
		Matcher matcher = pattern.matcher(input);
		Random rand = new Random();
		while (matcher.find()) {
			result.append(matcher.group(1));
			result.append(";");
			result.append(matcher.group(2));
			result.append(" ");
			result.append(matcher.group(3));
			result.append(";");
			result.append(matcher.group(4));
			result.append("@");
			result.append(matcher.group(5));
			result.append(";");
			result.append(rand.nextInt(10)+""+rand.nextInt(10)+""+rand.nextInt(10)+""+rand.nextInt(10));
			result.append("\n");
		}
		return result.toString();
	}
}
