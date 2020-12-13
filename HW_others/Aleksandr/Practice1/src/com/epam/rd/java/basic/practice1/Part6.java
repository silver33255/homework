package com.epam.rd.java.basic.practice1;

public class Part6 {

	@SuppressWarnings(value = { "all" })
	public static void main(String[] args) {
		if (args.length == 0) {
			return;
		}
		int n = 0;
		n = Integer.parseInt(args[0]);
		int[] result = new int[n];
		int index = 0;
		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			int counter = 0;
			for (int num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter++;
				}
			}
			if (counter == 2) {
				result[index] = i;
				index++;
			}
			if (index == n) {
				break;
			}
		}
		StringBuilder str = new StringBuilder();
		for (int num : result) {
			str.append(num + " ");
		}
		if (str.length() == 0) {
			return;
		}
		str.deleteCharAt(str.length() - 1);
		Demo.print(str.toString());
	}

}
