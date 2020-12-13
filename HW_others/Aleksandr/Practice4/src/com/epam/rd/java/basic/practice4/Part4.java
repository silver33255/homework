package com.epam.rd.java.basic.practice4;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String>{

	
	
    public static void main(String[] args){
    	StringBuilder result = new StringBuilder();
    	for(String str : new Part4()) {
    		result.append(str.concat(System.lineSeparator()));
    	}
    	Demo.print(result.toString());
    }
    
    
    public Iterator<String> iterator(){
    	try {
			return new IterImpl();
		} catch (FileNotFoundException e) {
			return null;
		}
    }
    
    static class IterImpl implements Iterator<String>{
    	private String[] strings;
    	private int index=-1;
    	
    	public IterImpl() throws FileNotFoundException {
    		String input = Demo.readFile("part4.txt");
    		input = input.replace(System.lineSeparator(), " ");
    		String regex = "([A-ZÀ-ß¨¯²][a-zà-ÿ¸³¿ ,]+[.]\\s?)";
    		Pattern pattern = Pattern.compile(regex);
    		Matcher matcher = pattern.matcher(input);
    		strings = new String[10];
    		int i=0;
    		while(matcher.find()) {
    			strings[i] = matcher.group(1).trim();
    			i++;
    		}
    	}
    	
    	
    	@Override
    	public boolean hasNext() {
    		return index<strings.length-1 && strings[index+1]!=null;
    	}

    	@Override
    	public String next() {
    		if(index>=strings.length-1 && strings[index+1]==null) {
    			throw new NoSuchElementException();
    		}
    		index++;
    		return strings[index];
    		
    	}
    	
    	@Override
    	public void remove() {
    		throw new UnsupportedOperationException("Operation is not supported");
    	}

    }
    

    
}
