package com.epam.rd.java.basic.practice1;

public class DemoTest extends BasicTest {

    @org.junit.Test
    public void mainTest() {
        Demo.main(new String[] {});
        org.junit.Assert.assertEquals("Hello, World\n" +
                "100\n" +
                "Test of task #3\n" +
                "9\n" +
                "29\n" +
                "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71\n" +
                "A ==> 1 ==> A\n" +
                "B ==> 2 ==> B\n" +
                "Z ==> 26 ==> Z\n" +
                "AA ==> 27 ==> AA\n" +
                "AZ ==> 52 ==> AZ\n" +
                "BA ==> 53 ==> BA\n" +
                "ZZ ==> 702 ==> ZZ\n" +
                "AAA ==> 703 ==> AAA\n", outContent.toString());
    }

    @org.junit.Test
    public void printTest() {
        Demo.print("test string");
        org.junit.Assert.assertEquals("test string", outContent.toString());
    }

}
