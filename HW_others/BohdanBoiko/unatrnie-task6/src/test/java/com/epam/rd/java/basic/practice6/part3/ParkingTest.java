package com.epam.rd.java.basic.practice6.part3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingTest {
    private Parking parkingMock;

    @Before
    public void init() {
        parkingMock = new Parking(4);
    }

    @Test
    // using try-catch block as I don`t have permission to add dependency
    // org.junit.jupiter.api
    public void illegalArgumentExceptionThrows_arrive() {
        try {
            parkingMock.arrive(10);
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
    public void illegalArgumentExceptionThrows_depart() {
        try {
            parkingMock.depart(10);
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
}