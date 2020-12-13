package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final Pattern CYRILLIC = Pattern.compile("[À-ßà-ÿ²³¯¿¨¸ªº]+");
    private static final Pattern LATIN = Pattern.compile("[A-Za-z]+");

    public static void main(String[] args) {
        String textFromFile = Demo.getInput("part6.txt");
        Scanner scan = new Scanner(System.in);
        String word;
        while(!(word = scan.nextLine()).equalsIgnoreCase("stop")) {
            System.out.println(reciveLettersByAlphabet(textFromFile, word));
        }
        scan.close();
    }
    
    private static String reciveLettersByAlphabet (String text, String Alphabet) {
        StringBuilder ouputText = new StringBuilder();
        Matcher match = null;
        if (Alphabet.equalsIgnoreCase("cyrl")) {
            match = CYRILLIC.matcher(text);
        } else if (Alphabet.equalsIgnoreCase("latn")) {
            match = LATIN.matcher(text);
        }
        if (match == null) {
            return "Incorrect input";
        }
        while (match.find()) {
            ouputText.append(match.group() + " ");
        } 
        return ouputText.toString();
    } 
}
