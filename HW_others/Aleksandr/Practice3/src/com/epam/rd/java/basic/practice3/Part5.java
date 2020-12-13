package com.epam.rd.java.basic.practice3;


public class Part5 {
	
	public static void main(String[] args) {
		//useless method
        throw new UnsupportedOperationException();
	}
	
	public static String decimal2Roman(int dec) {
		StringBuilder temp = new StringBuilder();
		while (dec >= 500) {
			temp.append("D");
			dec -= 500;
		}
		while (dec >= 100) {
			temp.append("C");
			dec -= 100;
		}
		while (dec >= 50) {
			temp.append("L");
			dec -= 50;
		}
		while (dec >= 10) {
			temp.append("X");
			dec -= 10;
		}
		while (dec >= 5) {
			temp.append("V");
			dec -= 5;
		}
		while (dec >= 1) {
			temp.append("I");
			dec -= 1;
		}
		String result = temp.toString();
		result = result.replace("IIII", "IV");
		result = result.replace("VIV", "IX");
		result = result.replace("LXXXX", "XC");
		return result;
	}
	
	public static int roman2Decimal(String roman) {
		roman = roman.replace("XC", "LXXXX");
		roman = roman.replace("IX", "VIV");
		roman = roman.replace("IV", "IIII");
		int result = 0;
		for (int i = 0; i < roman.length(); i++) {
			switch (roman.charAt(i)) {
			case 'D':
				result += 500;
				break;
			case 'C':
				result += 100;
				break;
			case 'L':
				result += 50;
				break;
			case 'X':
				result += 10;
				break;
			case 'V':
				result += 5;
				break;
			case 'I':
				result += 1;
				break;
			default:
				result += 0;
				break;
			}
		}
		return result;
	}
	
}