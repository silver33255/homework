package com.epam.rd.java.basic.practice3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class Part1Test {

    String inputText = "Login;Name;Email" + "\n" 
                        + "ivanov;Ivan Ivanov;ivanov@mail.com" + "\n"
                        + "петров;Петр Петров;petrov@google.com" 
                        + "\n" + "obama;Barack Obama;obama@google.com" + "\n"
                        + "bush;Джордж Буш;bush@mail.com";
    @Test
    public void reciveTextWith_SurnameAndMail_AfterConvert1_CurrentText() {
        String outputText = Part1.convert1(inputText);
        String expectedText = "ivanov: ivanov@mail.com" + "\n" 
                            + "петров: petrov@google.com" + "\n"
                            + "obama: obama@google.com" + "\n" 
                            + "bush: bush@mail.com";
        assertEquals(expectedText, outputText);
    }
    
    @Test
    public void reciveTextWith_SurnameNameAndMail_AfterConvert2_CurrentText() {
        String outputText = Part1.convert2(inputText);
        String expectedText = "Ivanov Ivan (email: ivanov@mail.com)" + "\n" 
                            + "Петров Петр (email: petrov@google.com)" + "\n"
                            + "Obama Barack (email: obama@google.com)" + "\n" 
                            + "Буш Джордж (email: bush@mail.com)";
        assertEquals(expectedText, outputText);
    }
    
    @Test
    public void reciveTextWith_DomainAndQuantityPeople_WithDomain_AfterConvert2_CurrentText() {
        String outputText = Part1.convert2(inputText);
        String expectedText = "Ivanov Ivan (email: ivanov@mail.com)" + "\n" 
                            + "Петров Петр (email: petrov@google.com)" + "\n"
                            + "Obama Barack (email: obama@google.com)" + "\n" 
                            + "Буш Джордж (email: bush@mail.com)";
        assertEquals(expectedText, outputText);
    }
    
    @Test
    public void reciveTextWith_AddPasswordToUsers_AfterConvert4_CurrentText() {
        String outputText = Part1.convert4(inputText);
        String expectedText = "Login;Name;Email;Password" + "\n" 
                            + "ivanov;Ivan Ivanov;ivanov@mail.com" + ";" + "1707" + "\n"
                            + "петров;Петр Петров;petrov@google.com" + ";" + "9321" + "\n"  
                            + "obama;Barack Obama;obama@google.com" + ";" + "4623" + "\n"
                            + "bush;Джордж Буш;bush@mail.com" + ";" + "7514";
        assertEquals(expectedText, outputText);
    }
}