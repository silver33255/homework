package com.epam.rd.java.basic.practice6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {

	public static final String INPUT = "--input";
	public static final String TASK = "--task";
	public static final String FILE = "part6.txt";
	
	static Logger logger = Logger.getLogger(Demo.class.getName());
	
	public static void main(String[] args) {
		Part1.main(new String[0]);
		Part2.main(new String[0]);
		Part3.main(new String[0]);
		Part4.main(new String[0]);
		Part5.main(new String[0]);
		Part6.main(new String[] { INPUT, FILE, TASK, "frequency" });
		Part6.main(new String[] { INPUT, FILE, TASK, "length" });
		Part6.main(new String[] { INPUT, FILE, TASK, "duplicates" });
	}

	public static void println(Object str) {
		System.out.println(str);// NOSONAR
	}

	public static void print(Object str) {
		System.out.print(str);// NOSONAR
	}

	public static void printf(String str, Integer integer) {
		System.out.printf(str, integer);// NOSONAR
	}

	public static String getInput(String fileName) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fileName), "cp1251");

			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine()).append(System.lineSeparator());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			logger.severe(e.getMessage());
		}
		return sb.toString().trim();
	}
}
