package com.epam.rd.java.basic.practice6.part5;

import com.epam.rd.java.basic.practice6.OutputSubstitution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTest extends OutputSubstitution {
    private Tree<Integer> treeMock;

    @Before
    public void init() {
        treeMock = new Tree<>();
        treeMock.add(new Integer[] {3, 7, 1, 8, 6, 2, 5, 2, 43, 0, 4, 11});
    }

    @Test
    public void addTest() {
        treeMock = new Tree<>();
        boolean isAdded = treeMock.add(3);
        treeMock.print();
        if (isAdded) {
            Assert.assertEquals("3" + System.lineSeparator(), outContent.toString());
        } else {
            Assert.fail();
        }
    }

    @Test
    public void addArrayTest() {
        treeMock.print();
        Assert.assertEquals("    0" + System.lineSeparator() +
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

    @Test
    public void returnsFalse_removeTest() {
        boolean isRemoved = treeMock.remove(20);
        Assert.assertFalse(isRemoved);
    }

    @Test
    public void head_removeTest() {
        boolean isRemoved = treeMock.remove(3);
        treeMock.print();
        String expectedOutput = "    0" + System.lineSeparator() +
                "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "4" + System.lineSeparator() +
                "      5" + System.lineSeparator() +
                "    6" + System.lineSeparator() +
                "  7" + System.lineSeparator() +
                "    8" + System.lineSeparator() +
                "        11" + System.lineSeparator() +
                "      43" + System.lineSeparator();
        if(isRemoved) {
            Assert.assertEquals(expectedOutput, outContent.toString());
        } else {
            Assert.fail();
        }
    }

    @Test
    public void noRightNode_removeTest() {
        boolean isRemoved = treeMock.remove(5);
        treeMock.print();
        String expectedOutput = "    0" + System.lineSeparator() +
                "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "      4" + System.lineSeparator() +
                "    6" + System.lineSeparator() +
                "  7" + System.lineSeparator() +
                "    8" + System.lineSeparator() +
                "        11" + System.lineSeparator() +
                "      43" + System.lineSeparator();
        if(isRemoved) {
            Assert.assertEquals(expectedOutput, outContent.toString());
        } else {
            Assert.fail();
        }
    }

    @Test
    public void noLeftNode_removeTest() {
        boolean isRemoved = treeMock.remove(8);
        treeMock.print();
        String expectedOutput = "    0" + System.lineSeparator() +
                "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "        4" + System.lineSeparator() +
                "      5" + System.lineSeparator() +
                "    6" + System.lineSeparator() +
                "  7" + System.lineSeparator() +
                "      11" + System.lineSeparator() +
                "    43" + System.lineSeparator();
        if(isRemoved) {
            Assert.assertEquals(expectedOutput, outContent.toString());
        } else {
            Assert.fail();
        }
    }
}
