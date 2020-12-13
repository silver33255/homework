package com.epam.rd.java.basic.practice1;

public class Part5 {

	@SuppressWarnings(value = { "all" })
	public static void main(String[] args) {
		if (args.length == 0) {
			return;
		}
		char[] digits = args[0].toCharArray();
		int sum = 0;
		for (char digit : digits) {
			sum += Character.getNumericValue(digit);
		}
		Demo.print(Integer.toString(sum));
	}

}
