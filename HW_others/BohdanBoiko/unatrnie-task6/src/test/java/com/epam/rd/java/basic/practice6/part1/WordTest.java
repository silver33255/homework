package com.epam.rd.java.basic.practice6.part1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordTest {
    private Word wordMock;
    private Word wordMock2;

    @Before
    public void init() {
        wordMock = new Word("test");
        wordMock2 = new Word("test");
    }

    @Test
    public void increaseFrequencyTest() {
        wordMock.increaseFrequency();
        Assert.assertEquals("test : 2", wordMock.toString());
    }

    @Test
    public void true_hashCodeTest() {
        Assert.assertEquals(wordMock.hashCode(), wordMock2.hashCode());
    }

    @Test
    public void false_hashCodeTest() {
        wordMock.increaseFrequency();
        Assert.assertNotEquals(wordMock.hashCode(), wordMock2.hashCode());
    }

    @Test
    public void true_equalsTest() {
        Assert.assertEquals(wordMock, wordMock2);
    }

    @Test
    public void trueIncreaseFrequencies_equalsTest() {
        wordMock.increaseFrequency();
        wordMock2.increaseFrequency();
        Assert.assertEquals(wordMock, wordMock2);
    }

    @Test
    public void false_equalsTest() {
        wordMock.increaseFrequency();
        Assert.assertNotEquals(wordMock, wordMock2);
    }

    @Test
    public void falseFirstNull_equalsTest() {
        Assert.assertNotEquals(null, wordMock);
    }

    @Test
    public void falseSecondNull_equalsTest() {
        Assert.assertNotEquals(wordMock, null);
    }
}
