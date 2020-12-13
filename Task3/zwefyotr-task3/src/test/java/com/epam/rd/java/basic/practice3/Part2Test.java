package com.epam.rd.java.basic.practice3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Part2Test {
    String input = "When I was younger, so much younger than today" + "\n" +
                   "I never needed anybody's help in any way" + "\n" +
                   "But now these days are gone, I'm not so self-assured" + "\n" + 
                   "Now I find I've changed my mind" + "\n" + 
                   "I've opened up the doors";
    
    
    @Test
    public void recive_Words_WithMinMax_Lengh(){
        String excpected = "min: I s m " + "\n"
                          + "max: younger anybody assured changed ";
        String result = (Part2.convert(input));
        assertEquals(excpected, result);
    }

}