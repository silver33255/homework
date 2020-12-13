package com.epam.rd.java.basic.practice5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Demo {

	static Logger logger = Logger.getLogger(Demo.class.getName());
	
	public static void main(final String[] args) {
		Part1.main(null);
		Part2.main(null);
		Part3.main(null);
		Part4.main(null);
		Part5.main(null);
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
	
	public static void println(Object str) {
		System.out.println(str);//NOSONAR
	}
	
	public static void print(Object str) {
		System.out.print(str);//NOSONAR
	}

}
