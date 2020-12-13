package com.epam.rd.java.basic.practice2;

public class ArrayImplTest extends BasicTest {
    private Array array;

    @org.junit.Before
    public void setUpDefault() {
        array = new ArrayImpl();
    }

    private void setUpCustom(int capacity) {
        array = new ArrayImpl(capacity);
    }

    @org.junit.Test
    public void size_zero() {
        org.junit.Assert.assertEquals(0, array.size());
    }

    @org.junit.Test
    public void size_two() {
        array.add(1);
        array.add(2);
        org.junit.Assert.assertEquals(2, array.size());
    }

    @org.junit.Test
    public void size_nullValues() {
        array.add(null);
        array.add(null);
        org.junit.Assert.assertEquals(2, array.size());
    }

    @org.junit.Test
    public void add_values() {
        Object[] expectedValues = new Object[] {
                "apple", "weakness", null, "car", 54, false, "-=/"
        };
        for (Object value : expectedValues) {
            array.add(value);
        }
        org.junit.Assert.assertEquals(getStatement(expectedValues), array.toString());
    }

    @org.junit.Test
    public void add_overflow() {
        setUpCustom(6);
        Object[] expectedValues = new Object[] {
                true, null, 985, 0 ,"Sunday", "property", "size", "test", 0
        };
        for (Object value : expectedValues) {
            array.add(value);
        }
        org.junit.Assert.assertEquals(getStatement(expectedValues), array.toString());
    }

    @org.junit.Test
    public void iterator_forEachTest() {
        String statement = "Bone for dog";
        for (String statementPart : statement.split(" ")) {
            array.add(statementPart);
        }
        array.iterator().forEachRemaining(System.out::print);
        statement = statement.replaceAll("\\s+",""); // removing all spaces
        org.junit.Assert.assertEquals(statement, outContent.toString());
    }

    @org.junit.Test
    public void iterator_hasNextEmpty() {
        org.junit.Assert.assertFalse(array.iterator().hasNext());
    }

    @org.junit.Test
    public void iterator_default() {
        String statement = "Beautiful color schemes supporting a vast majority of languages";
        for (String statementPart : statement.split(" ")) {
            array.add(statementPart);
        }
        java.util.Iterator<Object> iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        statement = statement.replaceAll("\\s+",""); // removing all spaces
        org.junit.Assert.assertEquals(statement, outContent.toString());
    }

    @org.junit.Test
    public void indexOf_default() {
        Object[] expectedValues = new Object[] {
                "zero", 0, null, false
        };
        for (Object value : expectedValues) {
            array.add(value);
        }
        for (int i = 0; i < expectedValues.length - 1; i++) {
            org.junit.Assert.assertEquals(i, array.indexOf(expectedValues[i]));
        }
    }

    @org.junit.Test
    public void indexOf_notFound() {
        Object[] expectedValues = new Object[] {
                "test", "JRE", 1, 5L
        };
        for (Object value : expectedValues) {
            array.add(value);
        }
        org.junit.Assert.assertEquals(-1, array.indexOf("not found"));
    }

    @org.junit.Test
    public void set_default() {
        Object[] expectedValues = new Object[] {
                "reset", 54, "=", true
        };
        for (Object value : expectedValues) {
            array.add(value);
        }
        array.set(3, "set");
        expectedValues[3] = "set";
        org.junit.Assert.assertEquals(getStatement(expectedValues), array.toString());
    }

    @org.junit.Test
    public void set_indexOutOfBoundsException() {
        Object[] expectedValues = new Object[] {
                "features", '5', false, null, 54, "LEO"
        };
        for (Object value : expectedValues) {
            array.add(value);
        }

        boolean isPassed = false;
        try {
            array.set(-4, "EXCEPTION");
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
        isPassed = false;

        try {
            array.set(10, "EXCEPTION");
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
        isPassed = false;

        org.junit.Assert.assertEquals(getStatement(expectedValues), array.toString());

        array.clear();
        try {
            array.set(1, "EXCEPTION");
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
    }

    @org.junit.Test
    public void get_default() {
        Object[] expectedValues = new Object[] {
                1, 4, 6, "seven"
        };
        for (Object value : expectedValues) {
            array.add(value);
        }
        org.junit.Assert.assertEquals("seven", array.get(3));
    }

    @org.junit.Test
    public void get_indexOutOfBoundsException() {
        Object[] expectedValues = new Object[] {
                "task", true, null, null, 3.5f, 56
        };
        for (Object value : expectedValues) {
            array.add(value);
        }

        boolean isPassed = false;
        try {
            array.get(-5);
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
        isPassed = false;

        try {
            array.get(9);
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
        isPassed = false;

        org.junit.Assert.assertEquals(getStatement(expectedValues), array.toString());

        array.clear();
        try {
            array.get(-5);
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
    }

    @org.junit.Test
    public void clear_default() {
        Object[] expectedValues = new Object[] {
                "something"
        };
        for (Object value : expectedValues) {
            array.add(value);
        }

        array.clear();
        org.junit.Assert.assertEquals("[]", array.toString());
    }

    @org.junit.Test
    public void remove_default() {
        Object[] expectedValues = new Object[] {
                null, "node", "prefix", 56, 'g', null
        };
        for (Object value : expectedValues) {
            array.add(value);
        }
        array.remove(0);
        String statement = getStatement(java.util.Arrays.copyOfRange(expectedValues, 1, expectedValues.length));
        org.junit.Assert.assertEquals(statement, array.toString());

        array.remove(0);
        statement = getStatement(java.util.Arrays.copyOfRange(expectedValues, 2, expectedValues.length));
        org.junit.Assert.assertEquals(statement, array.toString());
    }

    @org.junit.Test
    public void remove_indexOutOfBoundsException() {
        Object[] expectedValues = new Object[] {
                54, 21, "get", 'r', true, null
        };
        for (Object value : expectedValues) {
            array.add(value);
        }

        boolean isPassed = false;
        try {
            array.remove(-3);
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
        isPassed = false;

        try {
            array.remove(7);
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
        isPassed = false;

        org.junit.Assert.assertEquals(getStatement(expectedValues), array.toString());

        array.clear();
        try {
            array.remove(2);
        } catch (IndexOutOfBoundsException e) {
            isPassed = true;
        }
        org.junit.Assert.assertTrue(isPassed);
    }

}