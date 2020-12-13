package com.epam.rd.java.basic.practice6;

import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public abstract class InputOutputSubstitution extends OutputSubstitution {
    private final InputStream STANDARD_INPUT_STREAM = System.in;
    protected String testData = "test data";

    @Before
    public void setInputStream() {
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
    }

    @After
    public void restoreInputStream() {
        System.setIn(STANDARD_INPUT_STREAM);
    }

}