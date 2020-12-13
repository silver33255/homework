package com.epam.rd.java.basic.practice6;

import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class OutputSubstitution {
    private final PrintStream STANDARD_OUTPUT_STREAM = System.out;
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreOutputStream() {
        System.setOut(STANDARD_OUTPUT_STREAM);
    }
}
