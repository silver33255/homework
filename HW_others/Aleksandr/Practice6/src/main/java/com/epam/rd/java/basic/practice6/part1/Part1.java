package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {

	public static void main(String[] args) {
		InputStream is = System.in;
		System.setIn(new ByteArrayInputStream(
				getInput().replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
		WordContainer.main(new String[0]);
		System.setIn(is);
	}

	public static String getInput() {
		return "A A A B B C C C C stop"
				+ "".trim();
	}
	
	

}
