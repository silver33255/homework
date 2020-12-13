package com.epam.rd.java.basic.practice4;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Demo {

	private static final InputStream STD_IN = System.in;

	public static void main(String[] args) {

		println("=========================== PART1");

		Part1.main(new String[0]);

		println("=========================== PART2");

		Part2.main(new String[0]);

		println("=========================== PART3");

		// set the mock input

		System.setIn(new ByteArrayInputStream(

				"char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));

		Part3.main(new String[0]);

		// restore the standard input

		System.setIn(STD_IN);

		println("=========================== PART4");

		Part4.main(new String[0]);

		println("=========================== PART5");

		// set the mock input

		System.setIn(new ByteArrayInputStream("table ru^table en^apple ru^stop".replace("^", System.lineSeparator())
				.getBytes(StandardCharsets.UTF_8)));

		Part5.main(new String[0]);

		// restore the standard input

		System.setIn(STD_IN);

		println("=========================== PART6");

		// set the mock input

		System.setIn(new ByteArrayInputStream(
				"Latn^Cyrl^asdf^latn^cyrl^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));

		Part6.main(new String[0]);

		// restore the standard input

		System.setIn(STD_IN);

	}

	public static String readFile(String fileName) {
		try {
			StringBuilder sb = new StringBuilder();
			Scanner scanner = new Scanner(new File(fileName), "cp1251");
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine()).append(System.lineSeparator());
			}
			scanner.close();
			return sb.toString().trim();
		} catch (FileNotFoundException e) {
			e.printStackTrace();//NOSONAR
		}
		return null;
	}

	public static void print(String string) {
		System.out.print(string); // NOSONAR
	}

	public static void println(String string) {
		System.out.println(string); // NOSONAR
	}

}
