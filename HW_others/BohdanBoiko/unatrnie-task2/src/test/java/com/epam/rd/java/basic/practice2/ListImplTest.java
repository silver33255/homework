package com.epam.rd.java.basic.practice2;

public class ListImplTest extends BasicTest {
    private List list;

    @org.junit.Before
    public void setUp() {
        list = new ListImpl();
    }

    @org.junit.Test
    public void search_default() {
        Object[] expectedValues = new Object[] {
                "zero", 0, null, false
        };
        for (Object value : expectedValues) {
            list.addLast(value);
        }
        for (Object value : expectedValues) {
            org.junit.Assert.assertEquals(value, list.search(value));
        }
        org.junit.Assert.assertNull(list.search(43));
        org.junit.Assert.assertNull(list.search(true));
    }


    @org.junit.Test
    public void removeFirst_default() {
        Object[] expectedValues = new Object[] {
                "exclude", "zero", 0, null, false
        };
        for (Object value : expectedValues) {
            list.addLast(value);
        }
        list.removeFirst();
        org.junit.Assert.assertEquals(getStatement(java.util.Arrays.copyOfRange(expectedValues, 1, expectedValues.length)), list.toString());
        list.removeFirst();
        org.junit.Assert.assertEquals(getStatement(java.util.Arrays.copyOfRange(expectedValues, 2, expectedValues.length)), list.toString());
    }

    @org.junit.Test
    public void addFirst_default() {
        Object[] expectedValues = new Object[] {
                'd', "zero", 0, null, false, 5.6f
        };
        for (Object value : expectedValues) {
            list.addLast(value);
        }

        list.addFirst("first");
        String statement = getStatement(java.util.stream.Stream
                .concat(java.util.Arrays.stream(
                        new String[] {"first"}),
                        java.util.Arrays.stream(expectedValues))
                .toArray(Object[]::new));
        org.junit.Assert.assertEquals(statement, list.toString());

        list.addFirst("second");
        statement = getStatement(java.util.stream.Stream
                .concat(java.util.Arrays.stream(
                        new String[] {"second", "first"}),
                        java.util.Arrays.stream(expectedValues))
                .toArray(Object[]::new));
        org.junit.Assert.assertEquals(statement, list.toString());
    }
}
