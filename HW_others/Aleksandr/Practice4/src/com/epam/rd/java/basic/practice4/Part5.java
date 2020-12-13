package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String input = sc.nextLine();
    	String key = input.split(" ")[0];
    	String tag =input.split(" ")[1];
    	while(!input.contains("stop")) {
    		ResourceBundle bundle = ResourceBundle.getBundle("resources", Locale.forLanguageTag(tag));
    		Demo.println(bundle.getObject(key).toString());
    		input = sc.nextLine();
        	key = input.split(" ")[0];
        	tag =input.split(" ")[1];
    	}
    	sc.close();
    }

}
