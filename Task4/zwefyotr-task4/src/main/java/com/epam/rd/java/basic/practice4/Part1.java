package com.epam.rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1
{
    private static Pattern MORE_4_CHAR = Pattern.compile("[A-Za-z¿-ﬂ‡-ˇ≈Â®∏≤≥]{4,}");
    private static int INDEX_SHIFT = 2;

    public static void main( String[] args )
    {
        String inputText = Demo.getInput("part1.txt");
        System.out.println(Part1.deleteTwoCharsInLongWords(inputText) + System.lineSeparator());
    }
    
    private static String deleteTwoCharsInLongWords (String input) {
        StringBuilder outputString = new StringBuilder( input );
        Matcher matcher = MORE_4_CHAR.matcher( input );
        int index = 0;
        while ( matcher.find() )
        {
            outputString.delete( matcher.start() - index, matcher.start() + INDEX_SHIFT - index );
            index += INDEX_SHIFT;
        }
        return outputString.toString();
    }
}
