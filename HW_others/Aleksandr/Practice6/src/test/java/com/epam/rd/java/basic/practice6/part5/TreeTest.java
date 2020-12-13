package com.epam.rd.java.basic.practice6.part5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class TreeTest {
    
	InputStream is = System.in;
	PrintStream old = System.out;
	
    public TreeTest() {
    	
    }
    
    @Test
    public void shouldAddSixUniqueNumbers() {
    	Tree<Integer> tree = new Tree<>();
    	assertTrue(tree.add(1));
    	assertTrue(tree.add(2));
    	assertTrue(tree.add(3));
    	assertTrue(tree.add(4));
    	assertTrue(tree.add(5));
    	assertTrue(tree.add(6));
    }
    
    @Test
    public void shouldNotAddSixEqualNumbers() {
    	Tree<Integer> tree = new Tree<>();
    	assertTrue(tree.add(1));
    	assertFalse(tree.add(1));
    	assertFalse(tree.add(1));
    	assertFalse(tree.add(1));
    	assertFalse(tree.add(1));
    	assertFalse(tree.add(1));
    }
    
    @Test
    public void shouldAddAndRemove() {
    	Tree<Integer> tree = new Tree<>();
    	assertTrue(tree.add(1));
    	assertTrue(tree.remove(1));
    }
    
    @Test
    public void shouldAddAndRemoveAll() {
    	Tree<Integer> tree = new Tree<>();
    	assertTrue(tree.add(1));
    	assertTrue(tree.add(2));
    	assertTrue(tree.add(3));
    	assertTrue(tree.add(4));
    	assertTrue(tree.add(5));
    	assertTrue(tree.add(6));
    	assertTrue(tree.remove(1));
    	assertTrue(tree.remove(2));
    	assertTrue(tree.remove(3));
    	assertTrue(tree.remove(4));
    	assertTrue(tree.remove(5));
    	assertTrue(tree.remove(6));
    }
    
    @Test
    public void shouldNotRemoveIfEmpty() {
    	Tree<Integer> tree = new Tree<>();
    	assertFalse(tree.remove(1));
    }
    
    @Test
    public void shouldPrintBeforeAndAfterDeleting() {
    	String expected = "    0\r\n" + 
    			"  1\r\n" + 
    			"    2\r\n" + 
    			"3\r\n" + 
    			"    4\r\n" + 
    			"  5\r\n" + 
    			"    6\r\n" + 
    			"    0\r\n" + 
    			"  1\r\n" + 
    			"    2\r\n" + 
    			"3\r\n" + 
    			"    4\r\n" + 
    			"  6\r\n";
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setIn(new ByteArrayInputStream("A A A B B C C C C stop".replace("^", System.lineSeparator())
				.getBytes(StandardCharsets.UTF_8)));

		System.setOut(ps);
		Part5.main(new String[0]);
		System.out.flush();
		System.setOut(old);
		System.setIn(is);
	    String actual = baos.toString();
	    assertEquals(expected, actual);
    }
    
    
}
