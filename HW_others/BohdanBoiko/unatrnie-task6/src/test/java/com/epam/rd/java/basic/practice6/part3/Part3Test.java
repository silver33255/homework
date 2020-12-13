package com.epam.rd.java.basic.practice6.part3;

import com.epam.rd.java.basic.practice6.OutputSubstitution;
import org.junit.Assert;
import org.junit.Test;

public class Part3Test extends OutputSubstitution {
    @Test
    public void mainTest() {
        Part3.main(null);
        Assert.assertEquals("true 0010" + System.lineSeparator() +
                "true 0011" + System.lineSeparator() +
                "true 1011" + System.lineSeparator() +
                "true 1111" + System.lineSeparator() +
                "false 1111" + System.lineSeparator() +
                "true 1011" + System.lineSeparator() +
                "false 1011" + System.lineSeparator(),
                outContent.toString());
    }
}
