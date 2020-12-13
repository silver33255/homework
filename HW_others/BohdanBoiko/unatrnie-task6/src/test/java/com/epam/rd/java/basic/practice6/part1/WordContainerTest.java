package com.epam.rd.java.basic.practice6.part1;

import com.epam.rd.java.basic.practice6.InputOutputSubstitution;
import org.junit.Assert;
import org.junit.Test;

public class WordContainerTest extends InputOutputSubstitution {
    {
        testData = "A B C" + System.lineSeparator() +
                "B B C stop F C D" + System.lineSeparator() +
                "F G" + System.lineSeparator() +
                "stop";
    }

    @Test
    public void mainTest() {
        WordContainer.main(null);
        Assert.assertEquals("B : 3" + System.lineSeparator() +
                        "C : 2" + System.lineSeparator() +
                        "A : 1" + System.lineSeparator() +
                        "F : 1" + System.lineSeparator() +
                        "G : 1" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void startTest() {
        new WordContainer().start();
        Assert.assertEquals("B : 3" + System.lineSeparator() +
                        "C : 2" + System.lineSeparator() +
                        "A : 1" + System.lineSeparator() +
                        "F : 1" + System.lineSeparator() +
                        "G : 1" + System.lineSeparator(),
                outContent.toString());
    }
}
