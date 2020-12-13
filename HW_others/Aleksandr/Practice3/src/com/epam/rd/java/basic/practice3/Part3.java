package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
    	//useless method
        throw new UnsupportedOperationException();
    }

    public static String convert(String input) {
    	String regex = "(?s)\\b((\\w){3,999})\\b";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(input);
    	StringBuilder result = new StringBuilder(input);
    	while(matcher.find()) {
    		if((int)result.charAt(matcher.start())<=97) {
    			result.setCharAt(matcher.start(), (char)(32+(int)result.charAt(matcher.start())));
    		}else {
    			result.setCharAt(matcher.start(), (char)((int)result.charAt(matcher.start())-32));
    		}
    	}
        return result.toString();
    }

}