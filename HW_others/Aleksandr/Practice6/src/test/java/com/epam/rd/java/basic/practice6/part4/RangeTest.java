package com.epam.rd.java.basic.practice6.part4;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class RangeTest {

	
	InputStream is = System.in;
	PrintStream old = System.out;
	
	public RangeTest() {
		
	}
	
	
	@Test
	public void testDefaultCaseStraight() {
		Range range = new Range(3, 10);
		StringBuilder sb = new StringBuilder();
		for (Integer el : range) {
			sb.append(el+" ");
    	}
		assertEquals("3 4 5 6 7 8 9 10 ", sb.toString());
	}
	
	@Test
	public void testDefaultCaseReverse() {
		Range range = new Range(3, 10, true); 
		StringBuilder sb = new StringBuilder();
		for (Integer el : range) {
			sb.append(el+" ");
    	}
		assertEquals("10 9 8 7 6 5 4 3 ", sb.toString());
	}
	
	
	
	@Test
	public void testOutputOnMockInputDifferentCount() {
		String expected = "3 4 5 6 7 8 9 10 \r\n" + 
				"10 9 8 7 6 5 4 3 \r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part4.main(new String[0]);
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
	}

}
