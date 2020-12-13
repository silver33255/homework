package com.epam.rd.java.basic.practice2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListImplTest {
    ListImpl list;

    @Test
    void size_Expect_ListSize_Is_Zero_IfDont_AddElements() {
        list = new ListImpl();
        int result = list.size();
        int expected = 0;
        assertEquals(expected, result);
    }
    
    @Test
    void addFirst_Expect_SizeOfList_Is_One_If_AddOne_Element() {
        list = new ListImpl();
        list.addFirst("A");;
        int result = list.size();
        int expected = 1;
        assertEquals(expected, result);
    }
    
    @Test
    void addLast_Expect_SizeOfList_Is_One_If_AddOne_Element() {
        list = new ListImpl();
        list.addLast("B");
        int result = list.size();
        int expected = 1;
        assertEquals(expected, result);
    }
    
    @Test
    void clear_Recive_List_SizeIsZero_IfUseClear() {
        list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.clear();
        int result = list.size();
        int expected = 0;
        assertEquals(expected, result);
    }
}
