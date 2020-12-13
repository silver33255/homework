package com.epam.rd.java.basic.practice1;

public abstract class BasicTest {

    public static final java.io.PrintStream STANDARD_OUTPUT_STREAM = System.out;

    protected final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();

    @org.junit.Before
    public void setStreams() {
        System.setOut(new java.io.PrintStream(outContent));
    }

    @org.junit.After
    public void restoreStreams() {
        System.setOut(STANDARD_OUTPUT_STREAM);
    }

}
