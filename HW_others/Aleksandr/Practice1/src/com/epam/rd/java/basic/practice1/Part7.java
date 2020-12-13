package com.epam.rd.java.basic.practice1;

@SuppressWarnings(value = { "all" })
public class Part7 {

	public static final String ARROW = " ==> ";

	
	
	public static void main(String[] args) {
		Demo.print("A ==> " + str2int("A") + ARROW + int2str(str2int("A")) + "\n" + "B ==> " + str2int("B")
				+ ARROW + int2str(str2int("B")) + "\n" + "Z ==> " + str2int("Z") + ARROW + int2str(str2int("Z")) + "\n"
				+ "AA ==> " + str2int("AA") + ARROW + int2str(str2int("AA")) + "\n" + "AZ ==> " + str2int("AZ") + ARROW
				+ int2str(str2int("AZ")) + "\n" + "BA ==> " + str2int("BA") + ARROW + int2str(str2int("BA")) + "\n"
				+ "ZZ ==> " + str2int("ZZ") + ARROW + int2str(str2int("ZZ")) + "\n" + "AAA ==> " + str2int("AAA")
				+ ARROW + int2str(str2int("AAA")));
	}

	public static int str2int(String number) {
		int result = 0;
		int length = number.length();
		for (int i = 0; i < length; i++) {
			result += ((number.charAt(i) - 64)) * (Math.pow(26, (length - i - 1)));
		}
		return result;
	}
	
	public static String int2str(int number) {
		StringBuilder result = new StringBuilder();
		int length = 0;
		while(number>geometricSum(length, 26)) {
			length++;
		}
		for(int i=length-1; i>=0; i--) {
			int digit = 0;
			while(((number >= Math.pow(26, i) && number - Math.pow(26, i) > 0) || (number >= Math.pow(26, i) && i == 0)) && digit <= 26) {
				number-=Math.pow(26, i);
				digit++;
			}
			result.append((char)(digit+64));
		}
		return result.toString();
	}
	

	public static String rightColumn(String number) {
		return int2str(str2int(number) + 1);
	}

	private static int geometricSum(int maxPower, int number) {
		int sum = 0;
		for (int i = 1; i <= maxPower; i++) {
			sum += Math.pow(number, i);
		}
		return sum;
	}

}
