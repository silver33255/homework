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
                         "��� ����" + "\n" +
                         "��� ����� ����" + "\n" +
                         "� ��� ����� �����";
    
    String expectedText = "This _is _a _test" + "\n" +
            "_And this _is _also _a _test" + "\n" +
            "_And these are _also tests" + "\n" +
            "_test" + "\n" +
            "_��� _����" + "\n" +
            "_��� _����� _����" + "\n" +
            "� ��� _����� �����";
    
    assertEquals(expectedText, Part6.convert(inputText));
    }
}