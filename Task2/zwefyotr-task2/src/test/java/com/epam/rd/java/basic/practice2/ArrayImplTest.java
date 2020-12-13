package com.epam.rd.java.basic.practice2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayImplTest {
    ArrayImpl array;

    @Test
    void size_Expect_ArraySize_Is_Zero_IfDont_AddElements() {
        array = new ArrayImpl();
        int result = array.size();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void add_Expect_SizeOfArray_Is_One_If_AddOne_Element() {
        array = new ArrayImpl();
        array.add("A");
        int result = array.size();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    void add_Expect_SizeOfArray_Is_Two_If_AddTwo_Elements() {
        array = new ArrayImpl();
        array.add("First");
        array.add("Second");
        int result = array.size();
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    void add_Expect_SizeOfArray_Is_Eleven_If_AddEleven_Elements() {
        array = new ArrayImpl();
        array.add("First");
        array.add("Second");
        array.add("Third");
        array.add("Four");
        array.add("Five");
        array.add("Six");
        array.add("Seven");
        array.add("Eight");
        array.add("Nine");
        array.add("Ten");
        array.add("Eleven");
        int result = array.size();
        int expected = 11;
        assertEquals(expected, result);
    }

    @Test
    void get_Expect_Get_String_B_If_getElement_WithIndex_1() {
        array = new ArrayImpl();
        array.add("A");
        array.add("B");
        String result = (String) array.get(1);
        String expected = "B";
        assertEquals(expected, result);
    }

    @Test
    void set_Expect_Get_String_W_If_Set_W_On_Element_WithIndex_0() {
        array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.set(0, "W");
        String result = (String) array.get(0);
        String expected = "W";
        assertEquals(expected, result);
    }
       
    @Test
    void indexOf_Expect_Recive_MinusOne_IfSearch_NotExistElement() {
        array = new ArrayImpl();
        array.add("First");
        array.add("Second");
        int expected = -1;
        int result = array.indexOf("Third");
        assertEquals(expected, result);
    }
    
    @Test
    void indexOf_Expect_Recive_IndexFour_IfSearch_Null_InArray() {
        array = new ArrayImpl();
        array.add("First");
        array.add("Second");
        array.add("Second");
        array.add("Second");
        array.add(null);
        int expected = 4;
        int result = array.indexOf(null);
        assertEquals(expected, result);
    }
    
    @Test
    void indexOf_Expect_Recive_IndexTwo_IfSearch_C_InArray() {
        array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.add(null);
        int expected = 2;
        int result = array.indexOf("C");
        assertEquals(expected, result);
    }
    
    @Test
    void remove_Expect_ArraySizeIs_Five_IfRemove_OneElement_FromArray_WithSizeSix() {
        array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.add(null);
        array.add("D");
        array.add("E");
        array.remove(5);
        int expected = 5;
        int result = array.size();
        assertEquals(expected, result);
    }
    
    @Test
    void clear_Expect_ArraySizeZero_IfClear_ArrayWith_One_Element() {
        array = new ArrayImpl();
        array.add("A");
        array.clear();
        int expected = 0;
        int result = array.size();
        assertEquals(expected, result);
    }
    
    @Test
    void clear_Expect_ArraySizeZero_IfClear_ArrayThree_Two_Elements() {
        array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.clear();
        int expected = 0;
        int result = array.size();
        assertEquals(expected, result);
    }
    
    @Test
    void toString_Expect_EmptyQuotes_toString_EmptyArray() {
        array = new ArrayImpl();
        String expected = "[]";
        String result = array.toString();
        assertEquals(expected, result);
    }
    
    @Test
    void toString_Expect_QuotesWith_ABCnull_IftoString_ArrayWithCurrentElements() {
        array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.add(null);
        String expected = "[A, B, C, null]";
        String result = array.toString();
        assertEquals(expected, result);
    }
}
