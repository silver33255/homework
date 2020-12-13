package com.epam.rd.java.basic.practice6.part4;

import com.epam.rd.java.basic.practice6.OutputSubstitution;
import org.junit.Assert;
import org.junit.Test;

public class Part4Test extends OutputSubstitution {
    @Test
    public void mainTest() {
        Part4.main(null);
        Assert.assertEquals("3 4 5 6 7 8 9 10 " + System.lineSeparator() +
                        "10 9 8 7 6 5 4 3 " + System.lineSeparator(),
                outContent.toString());
    }
}
