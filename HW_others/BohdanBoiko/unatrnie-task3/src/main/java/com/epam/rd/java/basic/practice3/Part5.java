package com.epam.rd.java.basic.practice3;

public class Part5 {

    public static void main(String[] args) {
        Demo.print("PART5");
        Demo.print(' ');
        String roman;
        String arrow = " ==> ";
        for (int i = 1; i <= 10; i++) {
            roman = decimal2Roman(i);
            Demo.print(i + arrow + roman + arrow + roman2Decimal(roman));
        }
        for (int i = 87; i <= 100; i++) {
            roman = decimal2Roman(i);
            Demo.print(i + arrow + roman + arrow + roman2Decimal(roman));
        }
        Demo.print(System.lineSeparator());
    }

    public static String decimal2Roman(int dec) {
        String[] romanNumbers = new String[] {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] decimalNumbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; i < decimalNumbers.length; i++) {
            while (dec >= decimalNumbers[i]) {
                romanNumber.append(romanNumbers[i]);
                dec -= decimalNumbers[i];
            }
        }
        return romanNumber.toString();
    }

    public static int roman2Decimal(String roman) {
        int decimal = 0;
        int i = 0;

        while (i < roman.length()) {
            int firstSymbol = value(roman.charAt(i));
            if (i + 1 < roman.length()) {
                int nextSymbol = value(roman.charAt(i + 1));
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

    private static int value(char r) {
        switch (r) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}
