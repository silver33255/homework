package com.epam.rd.java.basic.practice6.part4;

public class Part4 {

    public static void main(String[] args) {
       Range defaultRange = new Range(3, 10);
       printRange(defaultRange);
       Range reverseRange = new Range(3, 10, true);
       printRange(reverseRange);
    }

    private static void printRange(Range range) {
        for (int num : range) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }
}
