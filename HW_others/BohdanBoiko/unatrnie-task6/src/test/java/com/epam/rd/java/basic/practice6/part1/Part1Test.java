package com.epam.rd.java.basic.practice6.part1;

import com.epam.rd.java.basic.practice6.OutputSubstitution;
import org.junit.Assert;
import org.junit.Test;

public class Part1Test extends OutputSubstitution {
    @Test
    public void mainTest() {
        Part1.main(null);
        Assert.assertEquals("B : 3" + System.lineSeparator() +
                "C : 2" + System.lineSeparator() +
                "A : 1" + System.lineSeparator() +
                "F : 1" + System.lineSeparator() +
                "G : 1" + System.lineSeparator(),
                outContent.toString());
    }
}
