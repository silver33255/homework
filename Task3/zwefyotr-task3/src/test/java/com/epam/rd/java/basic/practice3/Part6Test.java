package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

public class Part6Test {

@Test
public void testConvert_Expected_Receive_InputText_With_ReplaceSpaces_ToDownSlash() {
    String inputText = "This is a test" + "\n" +
                         "And this is also a test" + "\n" +
                         "And these are also tests" + "\n" +
                         "test" + "\n" +
                         "Это тест" + "\n" +
                         "Это также тест" + "\n" +
                         "И это также тесты";
    
    String expectedText = "This _is _a _test" + "\n" +
            "_And this _is _also _a _test" + "\n" +
            "_And these are _also tests" + "\n" +
            "_test" + "\n" +
            "_Это _тест" + "\n" +
            "_Это _также _тест" + "\n" +
            "И это _также тесты";
    
    assertEquals(expectedText, Part6.convert(inputText));
    }
}