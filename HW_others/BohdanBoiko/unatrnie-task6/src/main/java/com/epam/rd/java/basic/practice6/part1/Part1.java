package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part1 {
	private static final InputStream STD_IN = System.in;

	public static void main(String[] args) {
		String testString = "A B C" + System.lineSeparator() +
				"B B C stop F C D" + System.lineSeparator() +
				"F G" + System.lineSeparator() +
				"stop";
		System.setIn(new ByteArrayInputStream(testString.getBytes()));

		new WordContainer().start();

		System.setIn(STD_IN);
	}

}
