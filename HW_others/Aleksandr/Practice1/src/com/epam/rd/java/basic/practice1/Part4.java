package com.epam.rd.java.basic.practice1;

public class Part4 {

	@SuppressWarnings(value = { "all" })
	public static void main(String[] args) {
		if (args.length != 2) {
			return;
		}
		int number1 = 0;
		int number2 = 0;
		number1 = Integer.parseInt(args[0]);
		number2 = Integer.parseInt(args[1]);
		int divider = 0;
		for (divider = Integer.MAX_VALUE; divider > 0; divider--) {
			if (number1 % divider == 0 && number2 % divider == 0) {
				break;
			}
		}
		Demo.print(Integer.toString(divider));
	}
}
