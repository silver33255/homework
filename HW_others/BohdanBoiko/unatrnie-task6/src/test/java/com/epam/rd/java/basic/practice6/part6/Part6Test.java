package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.OutputSubstitution;
import org.junit.Assert;
import org.junit.Test;

public class Part6Test extends OutputSubstitution {
    private static final String FILEPATH = "part6.txt";
    private static final String SHORT_INPUT = "-i";
    private static final String SHORT_TASK = "-t";
    private static final String FULL_INPUT = "--input";
    private static final String FULL_TASK = "--task";
    private static final String FREQUENCY_TASK = "frequency";
    private static final String LENGTH_TASK = "length";
    private static final String DUPLICATES_TASK = "duplicates";
    
    @Test
    public void fullParameters_frequency() {
        test(FULL_INPUT, FULL_TASK, FREQUENCY_TASK);
        Assert.assertEquals("whale ==> 3" + System.lineSeparator() +
                "cheetah ==> 4" + System.lineSeparator() +
                "bison ==> 3" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void fullParameters_length() {
        test(FULL_INPUT, FULL_TASK, LENGTH_TASK);
        Assert.assertEquals("chimpanzee ==> 10" + System.lineSeparator() +
                        "mongoose ==> 8" + System.lineSeparator() +
                        "tortoise ==> 8" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void fullParameters_duplicates() {
        test(FULL_INPUT, FULL_TASK, DUPLICATES_TASK);
        Assert.assertEquals("RAUGAJ" + System.lineSeparator()  +
                        "NOSIB" + System.lineSeparator()  +
                        "ELAHW" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void shortParameters_frequency() {
        test(SHORT_INPUT, SHORT_TASK, FREQUENCY_TASK);
        Assert.assertEquals("whale ==> 3" + System.lineSeparator() +
                        "cheetah ==> 4" + System.lineSeparator() +
                        "bison ==> 3" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void shortParameters_length() {
        test(SHORT_INPUT, SHORT_TASK, LENGTH_TASK);
        Assert.assertEquals("chimpanzee ==> 10" + System.lineSeparator() +
                        "mongoose ==> 8" + System.lineSeparator() +
                        "tortoise ==> 8" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void shortParameters_duplicates() {
        test(SHORT_INPUT, SHORT_TASK, DUPLICATES_TASK);
        Assert.assertEquals("RAUGAJ" + System.lineSeparator()  +
                        "NOSIB" + System.lineSeparator()  +
                        "ELAHW" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void first_wrongParameter() {
        test("--test", SHORT_TASK, DUPLICATES_TASK);
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void second_wrongParameter() {
        test(SHORT_INPUT, "--test", SHORT_TASK, DUPLICATES_TASK);
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void third_wrongParameter() {
        test(SHORT_INPUT, "--test", DUPLICATES_TASK);
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void fourth_wrongParameter() {
        test(SHORT_INPUT, SHORT_TASK, "--test");
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void zeroParametersTest() {
        test();
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void notEnoughParametersTest() {
        test(FULL_INPUT);
        Assert.assertEquals("", outContent.toString());
    }

    private void test(String param1) {
        Part6.main(new String[] {param1, FILEPATH});
    }

    private void test(String param1, String param3, String param4) {
        Part6.main(new String[] {param1, FILEPATH, param3, param4});
    }

    private void test(String param1, String param2, String param3, String param4) {
        Part6.main(new String[] {param1, param2, param3, param4});
    }

    private void test() {
        Part6.main(null);
    }
}
