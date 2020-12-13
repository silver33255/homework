package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeTest {
    private Range rangeMock;

    @Before
    public void init() {
        rangeMock = new Range(4, 13);
    }

    @Test
    // using try-catch block as I don`t have permission to add dependency
    // org.junit.jupiter.api
    public void illegalArgumentExceptionThrows_constructor() {
        try {
            new Range(3, 1);
            System.out.println("!!!!!!");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            return;
        } catch (Exception ex) {
            Assert.fail("exception was thrown as expected but it was not IllegalArgumentException");
            return;
        }
        Assert.fail("no exception was thrown");
    }

    @Test
    // using try-catch block as I don`t have permission to add dependency
    // org.junit.jupiter.api
    public void noSuchElementExceptionThrows_iterator() {
        try {
            Iterator<Integer> iterator = rangeMock.iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            iterator.next();
            System.out.println("!!!!!!");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
            return;
        } catch (Exception ex) {
            Assert.fail("exception was thrown as expected but it was not NoSuchElementException");
            return;
        }
        Assert.fail("no exception was thrown");
    }

    @Test
    public void default_iteratorTest() {
        Iterator<Integer> iterator = rangeMock.iterator();
        int i = 4;
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value != i++) {
                Assert.fail(value + " != " + --i);
            }
        }
    }

    @Test
    public void reverse_iteratorTest() {
        Iterator<Integer> iterator = new Range(4, 13, true).iterator();
        int i = 13;
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value != i--) {
                Assert.fail(value + " != " + ++i);
            }
        }
    }
}
