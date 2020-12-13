package com.epam.rd.java.basic.practice2;

public class QueueImplTest extends BasicTest {

    private Queue queue;

    @org.junit.Before
    public void setUp() {
        queue = new QueueImpl();
    }

    @org.junit.Test
    public void iterator_forEachTest() {
        String statement = "The Smoke of Many Fires";
        for (String statementPart : statement.split(" ")) {
            queue.enqueue(statementPart);
        }

        statement = statement.replaceAll("\\s+",""); // removing all spaces
        queue.iterator().forEachRemaining(System.out::print);
        org.junit.Assert.assertEquals(statement, outContent.toString());
    }

    @org.junit.Test
    public void dequeue_default() {
        Object[] expectedValues = new Object[] {
                "apple", "weakness", null, "car", 54, false, "-=/"
        };
        for (Object value : expectedValues) {
            queue.enqueue(value);
        }
        org.junit.Assert.assertEquals(expectedValues[0], queue.dequeue());
        org.junit.Assert.assertEquals(getStatement(java.util.Arrays.copyOfRange(expectedValues, 1, expectedValues.length)), queue.toString());
    }
}
