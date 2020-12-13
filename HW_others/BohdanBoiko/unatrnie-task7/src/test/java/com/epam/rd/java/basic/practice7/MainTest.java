package com.epam.rd.java.basic.practice7;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static com.epam.rd.java.basic.practice7.constants.Paths.*;

public class MainTest {
    @After
    public void deleteFiles() {
        File file;

        file = new File(DOM_OUTPUT_FILE_NAME);
        file.deleteOnExit();

        file = new File(SAX_OUTPUT_FILE_NAME);
        file.deleteOnExit();

        file = new File(STAX_OUTPUT_FILE_NAME);
        file.deleteOnExit();
    }

    @Test
    public void testDom() {
        Demo.main(null);
        Assert.assertTrue("file " + DOM_OUTPUT_FILE_NAME + " should exist", isFileExists(DOM_OUTPUT_FILE_NAME));
    }

    @Test
    public void testSax() {
        Demo.main(null);
        Assert.assertTrue("file " + SAX_OUTPUT_FILE_NAME + " should exist", isFileExists(SAX_OUTPUT_FILE_NAME));
    }
    @Test
    public void testStax() {
        Demo.main(null);
        Assert.assertTrue("file " + STAX_OUTPUT_FILE_NAME + " should exist", isFileExists(STAX_OUTPUT_FILE_NAME));
    }

    private boolean isFileExists(String fileName) {
        return new File(fileName).exists();
    }
}
