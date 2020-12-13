package com.epam.rd.java.basic.practice1;

public class Part2Test extends BasicTest {

    @org.junit.Test
    public void test() {
        Part2.main(new String[] {"17", "18", "25", "34"});
        org.junit.Assert.assertEquals("94", outContent.toString());
    }

}
