package com.epam.rd.java.basic.practice6.part6;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Part6Test {
    
	InputStream is = System.in;
	PrintStream old = System.out;

    public Part6Test() {
    	
    }
    
    @Test
    public void shouldParseShortParamsFrequencyTest() {
    	
    	String expected = "whale ==> 3\r\n" + 
    			"cheetah ==> 4\r\n" + 
    			"bison ==> 3\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part6.main(new String[] { "-i", "part6.txt", "-t", "frequency" });
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    }
    
    @Test
    public void shouldParseShortParamsLengthTest() {
    	String expected = "chimpanzee ==> 10\r\n" + 
    			"mongoose ==> 8\r\n" + 
    			"tortoise ==> 8\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part6.main(new String[] { "-i", "part6.txt", "-t", "length" });
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    }
    
    @Test
    public void shouldParseShortParamsDuplicatesTest() {
    	String expected = "RAUGAJ\r\n" + 
    			"NOSIB\r\n" + 
    			"ELAHW\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part6.main(new String[] { "-i", "part6.txt", "-t", "duplicates" });
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    }
    
    @Test
    public void shouldParseLongParamsFrequencyTest() {
    	String expected = "whale ==> 3\r\n" + 
    			"cheetah ==> 4\r\n" + 
    			"bison ==> 3\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part6.main(new String[] { "--input", "part6.txt", "--task", "frequency" });
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    	
    }
    
    @Test
    public void shouldParseLongParamsLengthTest() {
    	String expected = "chimpanzee ==> 10\r\n" + 
    			"mongoose ==> 8\r\n" + 
    			"tortoise ==> 8\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part6.main(new String[] { "--input", "part6.txt", "--task", "length" });
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    }
    
    @Test
    public void shouldParseLongParamsDuplicatesTest() {
    	String expected = "RAUGAJ\r\n" + 
    			"NOSIB\r\n" + 
    			"ELAHW\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part6.main(new String[] { "--input", "part6.txt", "--task", "duplicates" });
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    }
    
}
