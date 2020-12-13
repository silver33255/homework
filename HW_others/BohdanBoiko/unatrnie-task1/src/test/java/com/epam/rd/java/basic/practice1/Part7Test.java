package com.epam.rd.java.basic.practice1;

public class Part7Test extends BasicTest {

    @org.junit.Test
    public void mainMethodTest() {
        Part7.main(new String[] {});
        org.junit.Assert.assertEquals("A ==> 1 ==> A\n" +
                "B ==> 2 ==> B\n" +
                "Z ==> 26 ==> Z\n" +
                "AA ==> 27 ==> AA\n" +
                "AZ ==> 52 ==> AZ\n" +
                "BA ==> 53 ==> BA\n" +
                "ZZ ==> 702 ==> ZZ\n" +
                "AAA ==> 703 ==> AAA\n",
                outContent.toString());
    }

    @org.junit.Test
    public void str2intTest() {
        Demo.print(String.valueOf(Part7.str2int("BC")));
        org.junit.Assert.assertEquals("55", outContent.toString());
    }

    @org.junit.Test
    public void int2strTest() {
        Demo.print(Part7.int2str(705));
        org.junit.Assert.assertEquals("AAC", outContent.toString());
    }

    @org.junit.Test
    public void rightColumnTest() {
        Demo.print(Part7.rightColumn("ZDD"));
        org.junit.Assert.assertEquals("ZDE", outContent.toString());
    }
}
