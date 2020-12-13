package com.epam.rd.java.basic.practice1;

public class Part6Test extends BasicTest {

    @org.junit.Test
    public void onZeroPassed() {
        Part6.main(new String[] {"0"});
        org.junit.Assert.assertEquals("", outContent.toString());
    }

    @org.junit.Test
    public void onNumberPassed() {
        Part6.main(new String[] {"10"});
        org.junit.Assert.assertEquals("2 3 5 7 11 13 17 19 23 29", outContent.toString());
    }
}
