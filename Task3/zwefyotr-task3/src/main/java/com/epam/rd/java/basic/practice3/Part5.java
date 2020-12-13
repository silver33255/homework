package com.epam.rd.java.basic.practice3;

public class Part5 {

    private static String[] ROMAN_LETTERS = { "I", "IV", "V", "IX", "X", "XL", "L", "LC", "C", "CD", "D", "CM", "M" };
    private static int[] LETTERS_INDEXES = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

    public static void main(String[] args) {

    }

    public static String decimal2Roman(int dec) {
        int enteredNumber = dec;
        StringBuilder sb = new StringBuilder();
        for (int i = 12; i >= 0; i--) {
            while (enteredNumber >= LETTERS_INDEXES[i]) {
                enteredNumber -= LETTERS_INDEXES[i];
                sb.append(ROMAN_LETTERS[i]);
            }
        }
        return sb.toString();
    }

    public static int roman2Decimal(String roman) {
        int decimal = 0;
        int i = 0;

        while (i < roman.length()) {
            int firstSymbol = LETTERS_INDEXES[roman.charAt(i)];
            if (i + 1 < roman.length()) {
                int nextSymbol = LETTERS_INDEXES[roman.charAt(i + 1)];
                if (firstSymbol >= nextSymbol) {
                    decimal += firstSymbol;
                } else {
                    decimal += nextSymbol - firstSymbol;
                    i++;
                }
            } else {
                decimal += firstSymbol;
            }
            i++;
        }
        return decimal;
    }
}
