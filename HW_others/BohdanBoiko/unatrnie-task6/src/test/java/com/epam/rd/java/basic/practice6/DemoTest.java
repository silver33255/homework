package com.epam.rd.java.basic.practice6;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest extends OutputSubstitution{
    @Test
    public void mainTest() {
        Demo.main(null);
        Assert.assertNotNull(outContent.toString());
    }
}
