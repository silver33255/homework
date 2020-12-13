package com.epam.rd.java.basic.practice6.part5;

import com.epam.rd.java.basic.practice6.OutputSubstitution;
import org.junit.Assert;
import org.junit.Test;

public class Part5Test extends OutputSubstitution {
    @Test
    public void mainTest() {
        Part5.main(null);
        Assert.assertEquals("========= add(3, 7, 1, 8, 6, 2, 5, 2, 43, 0, 4, 11):" + System.lineSeparator() +
                        "    0" + System.lineSeparator() +
                        "  1" + System.lineSeparator() +
                        "    2" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "        4" + System.lineSeparator() +
                        "      5" + System.lineSeparator() +
                        "    6" + System.lineSeparator() +
                        "  7" + System.lineSeparator() +
                        "    8" + System.lineSeparator() +
                        "        11" + System.lineSeparator() +
                        "      43" + System.lineSeparator(),
                outContent.toString());
    }
}
