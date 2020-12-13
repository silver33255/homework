package com.epam.rd.java.basic.practice2;

public abstract class BasicTest {

    public static final java.io.PrintStream STANDARD_OUTPUT_STREAM = System.out;

    protected static final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();

    @org.junit.BeforeClass
    public static void setStream() {
        System.setOut(new java.io.PrintStream(outContent));
    }

    @org.junit.AfterClass
    public static void restoreStream() {
        System.setOut(STANDARD_OUTPUT_STREAM);
    }

    @org.junit.After
    public void clearStream() {
        outContent.reset();
    }

    protected String getStatement(Object[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (Object element : elements) {
            stringBuilder.append(element).append(", ");
        }

        int length = stringBuilder.length();
        stringBuilder.delete(length - 2, length).append("]");
        return stringBuilder.toString();
    }

}