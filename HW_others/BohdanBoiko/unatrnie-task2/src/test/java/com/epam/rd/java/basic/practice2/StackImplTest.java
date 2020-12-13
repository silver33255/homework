package com.epam.rd.java.basic.practice2;

public class StackImplTest extends BasicTest{

    private Stack stack;

    @org.junit.Before
    public void setUpDefault() {
        stack = new StackImpl();
    }

    @org.junit.Test
    public void iterator_forEachTest() {
        String statement = "In The Shadow Of Our Pale Companion";
        String reverseStatement = "CompanionPaleOurOfShadowTheIn";
        for (String statementPart : statement.split(" ")) {
            stack.push(statementPart);
        }
        stack.iterator().forEachRemaining(System.out::print);
        org.junit.Assert.assertEquals(reverseStatement, outContent.toString());
    }

    @org.junit.Test
    public void pop_default() {
        Object[] expectedValues = new Object[] {
                "features", '5', false, null, 54, "LEO"
        };
        for (Object value : expectedValues) {
            stack.push(value);
        }

        org.junit.Assert.assertEquals(expectedValues[5], stack.pop());
        org.junit.Assert.assertEquals(expectedValues[4], stack.pop());
        org.junit.Assert.assertEquals(getStatement(java.util.Arrays.copyOfRange(expectedValues, 0, expectedValues.length - 2)), stack.toString());
    }
}
