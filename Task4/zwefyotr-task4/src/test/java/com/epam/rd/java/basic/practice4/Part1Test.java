package com.epam.rd.java.basic.practice4;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Part1Test {

    @Test
    public void testDeleteTwoCharsInLongWords_Expected_Recive_TheSameWord_IfWordLess4() {
        String word = "Our";
        String expected = "Our";
        assertEquals(expected, Part1.deleteTwoCharsInLongWords(word));
    }

    @Test
    public void testDeleteTwoCharsInLongWords_Expected_DeleteTwoFirstChars_ifWord_MoreThanFour() {
        String word = "Castle";
        String expected = "stle";
        assertEquals(expected, Part1.deleteTwoCharsInLongWords(word));
    }
    
    @Test
    public void testDeleteTwoCharsInLongWords_Expected_DeleteTwoFirstChars_InWords_MoreThanFour() {
        String word = "Two roads diverged in a yellow wood,\r\n" + 
                "And sorry I could not travel both\r\n" + 
                "� ���� ����������� ������� �������";
        
        String expected = "Two ads verged in a llow od,\r\n" + 
                "And rry I uld not avel th\r\n" + 
                "� �� ��������� ����� �����";
        assertEquals(expected, Part1.deleteTwoCharsInLongWords(word));
    }
}