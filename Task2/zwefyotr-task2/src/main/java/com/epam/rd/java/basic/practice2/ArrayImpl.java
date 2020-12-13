package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private static final int CAPACITY = 10;
    private int size;
    Object[] elements;

    public ArrayImpl() {
        this.size = 0;
        this.elements = new Object[CAPACITY];
    }

    public ArrayImpl(int size) {
        this.size = 0;
        this.elements = new Object[size];
    }

    @Override
    public void clear() {
        this.size = 0;
        this.elements = new Object[CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            boolean nextElementNull = true;
            nextElementNull = currentIndex < size();
            return nextElementNull;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return elements[currentIndex++];
            }
        }
    }

    @Override
    public void add(Object element) {
        if (this.size == elements.length-1) {
            this.elements = extendSize(elements);
        }
        elements[size++] = element;
    }

    @Override
    public void set(int index, Object element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        this.elements[index] = element;
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public int indexOf(Object element) {
        int index = -1;
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (elements[i] == (element))
                    index = i;
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (elements[i] != null && elements[i].equals(element)) {
                    index = i;
                }
            }
        }
        return index;
    }

    @Override
    public void remove(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i != size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                returnString.append(elements[i] + ", ");
            } else {
                returnString.append(elements[i]);
            }

        }
        returnString.append("]");
        return returnString.toString();
    }

    public static void main(String[] args) {
        ArrayImpl aImp = new ArrayImpl();

        aImp.add("A");
        aImp.add("B");
        aImp.add("C");
        aImp.add("D");
        aImp.add("E");
        aImp.add("F");
        aImp.add("G");
        aImp.add("H");
        aImp.add("J");
        aImp.add("K");
    }

    private Object[] extendSize(Object[] extendable) {
        Object[] extending = new Object[(extendable.length * 3) / 2 + 1];
            System.arraycopy(extendable, 0, extending, 0, extendable.length-1);
        return extending;
    }
}
