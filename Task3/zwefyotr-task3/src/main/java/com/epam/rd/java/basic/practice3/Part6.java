package com.epam.rd.java.basic.practice3;
import java.lang.StringBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    
    private static Pattern WORD_PATTERN = Pattern.compile( "(\\b[A-Za-zР-пр-џ]+\\b)" );

    public static void main(String[] args) {
        
    }

    public static String convert(String input) {
        Pattern pattern;
        Matcher mr;
        StringBuilder outputString = new StringBuilder(input);        
        Matcher currentWord = WORD_PATTERN.matcher( input );
        
        while (currentWord.find()) {
            pattern = Pattern.compile( "\\b" + currentWord.group() + "\\b" );
            mr = pattern.matcher( outputString );
            for ( int i = 1; mr.find(); i++ )
            {
                if ( i > 1 )
                {
                    outputString = new StringBuilder(mr.replaceAll( "_" + mr.group() ));
                }
            }
        }
        return outputString.toString();
    }
}
