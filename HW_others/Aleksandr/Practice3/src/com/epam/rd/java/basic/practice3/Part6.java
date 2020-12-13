package com.epam.rd.java.basic.practice3;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

	public static void main(String[] args) throws FileNotFoundException {
//		//useless method
//        throw new UnsupportedOperationException();
		System.out.println(convert(Util.getInput("part6.txt")));
	}

	public static String convert(String input) {
		String regex = "(?s)(\\b\\p{L}+\\b)(?!.*\\b\\1\\b)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		String result = input;
		input = matcher.replaceAll("");
		input = input.replace("\r\n", " ");
		input = input.replace("  ", " ");
		regex = "(\\b\\p{L}+\\b)";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		while(matcher.find()) {
			result = result.replaceAll("\\b"+matcher.group(1)+"\\b", "_"+matcher.group(1));
		}
		result = result.replace("__", "_");
		result = result.replace("__", "_");
		return result;
	}
}
