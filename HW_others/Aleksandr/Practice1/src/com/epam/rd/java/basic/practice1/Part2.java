package com.epam.rd.java.basic.practice1;

public class Part2 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		int sum = 0;
		if (args.length == 0) {
			return;
		}
		for (String str : args) {
			sum += Integer.parseInt(str);
		}
		System.out.print(Integer.toString(sum));
	}

}
