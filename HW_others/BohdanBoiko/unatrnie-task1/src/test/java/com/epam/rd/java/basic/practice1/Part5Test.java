package com.epam.rd.java.basic.practice1;

public class Part5Test extends BasicTest {

    @org.junit.Test
    public void test1() {
        Part5.main(new String[] {"123456"});
        org.junit.Assert.assertEquals("21", outContent.toString());
    }

    @org.junit.Test
    public void test2() {
        Part5.main(new String[] {"1038"});
        org.junit.Assert.assertEquals("12", outContent.toString());
    }
}
