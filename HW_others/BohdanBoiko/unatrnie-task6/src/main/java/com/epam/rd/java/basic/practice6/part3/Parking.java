package com.epam.rd.java.basic.practice6.part3;

import java.util.Arrays;

public class Parking {
    private final int[] places;

    public Parking(int capacity) {
        places = new int[capacity];
    }
    
    public boolean arrive(int k) {
        if (k >= places.length) {
            throw new IllegalArgumentException("k is outside the range [0, " + places.length + "]");
        }

        for (int i = k; i < places.length; i++) {
            if (places[i] == 0) {
                places[i] = 1;
                return true;
            }
        }

        for (int i = 0; i < k; i++) {
            if (places[i] == 0) {
                places[i] = 1;
                return true;
            }
        }

        return false;
    }
    
    public boolean depart(int k) {
        if (k >= places.length) {
            throw new IllegalArgumentException("k is outside the range [0, " + places.length + "]");
        }

        if (places[k] == 1) {
            places[k] = 0;
            return true;
        }

        return false;
    }
    
    public void print() {
        Arrays.stream(places)
                .forEach(System.out::print);
        System.out.println();
    }
}
