package com.epam.rd.java.basic.practice1;

public class Part1Test extends BasicTest{

    @org.junit.Test
    public void test() {
        Part1.main(new String[] {});
        org.junit.Assert.assertEquals("Hello, World", outContent.toString());
    }

}
