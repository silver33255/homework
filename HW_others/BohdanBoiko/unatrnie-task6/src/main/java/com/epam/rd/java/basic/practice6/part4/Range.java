package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer>{
    private final int[] numbers;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        if (firstBound > secBound) {
            throw new IllegalArgumentException("firstBound > secBound");
        }
        numbers = new int[secBound - firstBound + 1];

        if (reversedOrder) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = secBound--;
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = firstBound++;
            }
        }
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }
    
    private final class IteratorImpl implements Iterator<Integer> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != numbers.length;
        }

        @Override
        public Integer next() {
            if (cursor >= numbers.length) {
                throw new NoSuchElementException("iteration beyond the collection");
            }
            return numbers[cursor++];
        }
    }
}
