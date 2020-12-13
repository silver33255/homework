package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.*;

public class Part5Test {

    @Test
    public void testDecimal2Roman_excpected_recive_II_WhenInput2() {
        String expected = "II";
        assertEquals(expected, Part5.decimal2Roman(2));
    }
    
    @Test
    public void testDecimal2Roman_excpected_recive_XI_WhenInput11() {
        String expected = "XI";
        assertEquals(expected, Part5.decimal2Roman(11));
    }
    
    @Test
    public void testDecimal2Roman_excpected_recive_MII_WhenInput1002() {
        String expected = "MII";
        assertEquals(expected, Part5.decimal2Roman(1002));
    }
    
    @Test
    public void testRoman2Decimal_excpected_recive_2_WhenInputII() {
        int expected = 2;
        assertEquals(expected, Part5.roman2Decimal("II"));
    }
    
    @Test
    public void testRoman2Decimal_excpected_recive_11_WhenInputXI() {
        int expected = 11;
        assertEquals(expected, Part5.roman2Decimal("XI"));
    }
    
    @Test
    public void testRoman2Decimal_excpected_recive_1002_WhenInputMII() {
        int expected = 1002;
        assertEquals(expected, Part5.roman2Decimal("MII"));
    }

}