package com.epam.rd.java.basic.practice6.part1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class WordContainerTest {
	
	InputStream is = System.in;
	PrintStream old = System.out;
	
	
	public WordContainerTest() {
		
	}
	
	@Test
	public void testOutputOnMockInputDifferentCount() {
		String expected = "C : 4\r\n" + 
				"A : 3\r\n" + 
				"B : 2\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setIn(new ByteArrayInputStream("A A A B B C C C C stop".replace("^", System.lineSeparator())
				.getBytes(StandardCharsets.UTF_8)));

		System.setOut(ps);
		WordContainer.main(new String[0]);
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
	}
	
	
	@Test
	public void testOutputOnMockInputEqualCount() {
		String expected = "A : 3\r\n" + 
				"B : 3\r\n" + 
				"C : 3\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setIn(new ByteArrayInputStream("A A A B B B C C C stop".replace("^", System.lineSeparator())
				.getBytes(StandardCharsets.UTF_8)));

		System.setOut(ps);
		WordContainer.main(new String[0]);
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
	}
	
	@Test
	public void testOutputOnMockInputOneA() {
		String expected = "A : 1\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setIn(new ByteArrayInputStream("A stop A A B B B C C C stop".replace("^", System.lineSeparator())
				.getBytes(StandardCharsets.UTF_8)));

		System.setOut(ps);
		WordContainer.main(new String[0]);
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
	}
	
	
	@Test
	public void shouldOutputDefault() {
		String expected = "C : 4\r\n" + 
				"A : 3\r\n" + 
				"B : 2\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Part1.main(new String[0]);
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
	}
	
}
