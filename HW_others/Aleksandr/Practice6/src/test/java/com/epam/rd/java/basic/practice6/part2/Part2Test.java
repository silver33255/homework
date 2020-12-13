package com.epam.rd.java.basic.practice6.part2;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Part2Test {
    
	InputStream is = System.in;
	PrintStream old = System.out;
	
	public Part2Test() {
		
	}
	
	@Test
	public void testTime() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Part2.main(new String[0]);
		System.out.flush();
		System.setOut(old);
	    String actual = baos.toString();
	    assertNotNull(actual);
	}

}