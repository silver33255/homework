package com.epam.rd.java.basic.practice6.part3;

public class Part3 {
    private static Parking parking;
    public static void main(String[] args) {
        parking = new Parking(4);
        printArrive(2);
        printArrive(3);
        printArrive(2);
        printArrive(2);
        printArrive(2);
        printDepart(1);
        printDepart(1);
    }

    private static void printArrive(int k) {
        System.out.print(parking.arrive(k) + " ");
        parking.print();
    }
    private static void printDepart(int k) {
        System.out.print(parking.depart(k) + " ");
        parking.print();
    }
}
