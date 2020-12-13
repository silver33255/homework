package com.epam.rd.java.basic.practice1;

public class Part3 {

	@SuppressWarnings(value = { "all" })
	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		if (args.length == 0) {
			return;
		}
		for (String str : args) {
			result.append(str + " ");
		}
		if (result.length() == 0) {
			return;
		}
		result.deleteCharAt(result.length() - 1);
		Demo.print(result.toString());
	}

}
