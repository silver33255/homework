package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3
{

    public static void main( String[] args )
    {
        String input = Util.getInput( "part3.txt" );
        Demo.print( "PART3" );
        Demo.print( ' ' );
        Demo.print( "Convert result: " + System.lineSeparator() + convert( input ) );
        Demo.print( System.lineSeparator() );
    }

    public static String convert( String input )
    {
        Pattern pattern = Pattern.compile( "\\b\\w{3,}\\b" );
        Matcher matcher = pattern.matcher( input );

        while ( matcher.find() )
        {
            String originalString = input.substring( matcher.start(), matcher.end() );
            String invertedString;
            char firstChar = originalString.charAt( 0 );

            if ( Character.isLowerCase( firstChar ) )
            {
                invertedString = originalString.replace( firstChar, Character.toUpperCase( firstChar ) );
            }
            else
            {
                invertedString = originalString.replace( firstChar, Character.toLowerCase( firstChar ) );
            }
            input = input.replaceFirst( originalString, invertedString );
        }

        return input;
    }
}
