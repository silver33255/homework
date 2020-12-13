package com.epam.rd.java.basic.practice6.part3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class ParkingTest {

	InputStream is = System.in;
	PrintStream old = System.out;
	
	public ParkingTest() {

	}

	@Test
    public void testDefaultCase() {
    	Parking parking = new Parking(4);
    	assertTrue(parking.arrive(2));// 0010, true 
    	assertTrue(parking.arrive(3));  // 0011, true 
    	assertTrue(parking.arrive(2));  // 1011, true 
    	assertTrue(parking.arrive(2));  // 1111, true
    	assertFalse(parking.arrive(2));  // 1111, false
    	assertTrue(parking.depart(1));  // 1011, true
    	assertFalse(parking.depart(1));  // 1011, false
    }
	
	@Test
    public void testDefaultCaseWithPlaces() {
		Parking parking = new Parking(4);
		String expected = "0010\r\n" + 
				"0011\r\n" + 
				"1011\r\n" + 
				"1111\r\n" + 
				"1111\r\n" + 
				"1011\r\n" + 
				"1011\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setIn(new ByteArrayInputStream("A A A B B B C C C stop".replace("^", System.lineSeparator())
				.getBytes(StandardCharsets.UTF_8)));

		System.setOut(ps);

		assertTrue(parking.arrive(2));// 0010, true 
		parking.print();
    	assertTrue(parking.arrive(3));  // 0011, true 
    	parking.print();
    	assertTrue(parking.arrive(2));  // 1011, true
    	parking.print();
    	assertTrue(parking.arrive(2));  // 1111, true
    	parking.print();
    	assertFalse(parking.arrive(2));  // 1111, false
    	parking.print();
    	assertTrue(parking.depart(1));  // 1011, true
    	parking.print();
    	assertFalse(parking.depart(1));  // 1011, false
    	parking.print();
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    	
    }
	
	
	
	@Test
	public void testOutputOnMockInputDifferentCount() {
		String expected = "true0010\r\n" + 
				"true0011\r\n" + 
				"true1011\r\n" + 
				"true1111\r\n" + 
				"false1111\r\n" + 
				"true1011\r\n" + 
				"false1011\r\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		Part3.main(new String[0]);
		
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
	}

}


