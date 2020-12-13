package com.epam.rd.java.basic.practice1;

public class Part4Test extends BasicTest{

    @org.junit.Test
    public void test1() {
        Part4.main(new String[] {"24", "36"});
        org.junit.Assert.assertEquals("12", outContent.toString());
    }

    @org.junit.Test
    public void test2() {
        Part4.main(new String[] {"45", "12"});
        org.junit.Assert.assertEquals("3", outContent.toString());
    }
}
