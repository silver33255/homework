package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args){
    	String input = Demo.readFile("part6.txt");
    	String latinRegex = "\\b([a-zA-Z]+)\\b";
    	String cyrillicRegex = "\\b([à-ÿÀ-ß¸º³¿]+)\\b";
    	Pattern latinPattern = Pattern.compile(latinRegex);
    	Matcher latinMatcher = latinPattern.matcher(input);
    	Pattern cyrillicPattern = Pattern.compile(cyrillicRegex);
    	Matcher cyrillicMatcher = cyrillicPattern.matcher(input);
    	StringBuilder latin = new StringBuilder();
    	StringBuilder cyrillic = new StringBuilder();
    	Thread tr1 = new Thread(()->{
    		while(latinMatcher.find()) {
    			latin.append(latinMatcher.group(1)+" ");
    		}
    	});
    	Thread tr2 = new Thread(()->{
    		while(cyrillicMatcher.find()) {
    			cyrillic.append(cyrillicMatcher.group(1)+" ");
    		}
    	});
    	
    	tr1.start();
    	tr2.start();
    	
    	boolean flag = tr1.getState().ordinal()!=5||tr2.getState().ordinal()!=5;
    	while(flag) {
    		flag = tr1.getState().ordinal()!=5||tr2.getState().ordinal()!=5;
    	}
    	
    	Scanner sc = new Scanner(System.in);
    	String console = sc.nextLine();
    	while(!console.equalsIgnoreCase("stop")) {
    		switch(console.toLowerCase()) {
    		case "cyrl":
    			Demo.println("Cyrl: "+cyrillic.toString().trim()+" ");
    			break;
    		case "latn":
    			Demo.println("Latn: "+latin.toString().trim()+" ");
    			break;
    		default:
    			Demo.println(console+": Incorrect input");
    			break;
    		}
    		console = sc.nextLine();
    	}
    	sc.close();
    }

}
