package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {
	private static final String FILEPATH = "part6.txt";
	private static final String SHORT_INPUT = "-i";
	private static final String SHORT_TASK = "-t";

	public static void main(String[] args) {
		printPartTitle(1);
		Part1.main(null);
		printPartTitle(2);
		Part2.main(null);
		printPartTitle(3);
		Part3.main(null);
		printPartTitle(4);
		Part4.main(null);
		printPartTitle(5);
		Part5.main(null);
		printPartTitle(61);
		Part6.main(new String[] {SHORT_INPUT, FILEPATH, SHORT_TASK,"frequency"});
		printPartTitle(62);
		Part6.main(new String[] {SHORT_INPUT, FILEPATH, SHORT_TASK, "length"});
		printPartTitle(63);
		Part6.main(new String[] {SHORT_INPUT, FILEPATH, SHORT_TASK,"duplicates"});
	}

	private static void printPartTitle(int number) {
		System.out.println();
		System.out.println("========= PART " + number + " =========");
	}
}
