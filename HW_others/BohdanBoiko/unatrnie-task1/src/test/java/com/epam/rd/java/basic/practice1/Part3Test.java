package com.epam.rd.java.basic.practice1;

public class Part3Test extends BasicTest {

    @org.junit.Test
    public void test1() {
        Part3.main(new String[] {"2", "4", "hss", "had"});
        org.junit.Assert.assertEquals("2 4 hss had", outContent.toString());
    }

    @org.junit.Test
    public void test2() {
        Part3.main(new String[] {"second", "4i3t", "done"});
        org.junit.Assert.assertEquals("second 4i3t done", outContent.toString());
    }
}
