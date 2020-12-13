package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part3Test {
    String input = "When I was younger, so much younger than today" + "\n" +
            "I never needed anybody's help in any way" + "\n" +
            "But now these days are gone, I'm not so self-assured" + "\n" + 
            "Now I find I've changed my mind" + "\n" + 
            "I've opened up the doors";
    
    @Test
    public void excpected_InvertFirstCharacter_IfWordHave_ThreeOrMoreChars(){
        String expected = "when I Was Younger, so Much Younger Than Today" + "\n" +
                "I Never Needed Anybody's Help in Any Way" + "\n" +
                "but Now These Days Are Gone, I'm Not so Self-Assured" + "\n" + 
                "now I Find I've Changed my Mind" + "\n" + 
                "I've Opened up The Doors";
        String result = Part3.convert(input);
        assertEquals(expected, result);
        
        
    }

}