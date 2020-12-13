package com.epam.rd.java.basic.practice2;

public class StackImpl implements Stack {

    private final Array array;

    public StackImpl() {
        array = new ArrayImpl();
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public int size() {
        return array.size();
    }

    public java.util.Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void push(Object element) {
        array.add(element);
    }

    @Override
    public Object pop() {
        if (size() == 0) {
            return null;
        } else {
            Object element = top();
            array.remove(size() - 1);
            return element;
        }
    }

    @Override
    public Object top() {
        if (size() == 0) {
            return null;
        }
        return array.get(size() - 1);
    }

    @Override
    public String toString() {
        return array.toString();
    }

    @SuppressWarnings("squid:S1192")
    public static void main(String[] args) {
        Stack stack = new StackImpl();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        Demo.print("* StackImpl demo:");
        Demo.print("Stack: " + stack.toString());
        Demo.print("* Pop");
        Demo.print(stack.pop());
        Demo.print("* Pop");
        Demo.print(stack.pop());
        Demo.print("Stack: " + stack.toString());
        Demo.print("* Size");
        Demo.print(stack.size());
        Demo.print("* Push 'null'");
        stack.push(null);
        java.util.Iterator<Object> iterator = stack.iterator();
        while (iterator.hasNext()) {
            Demo.print(iterator.next());
        }
        Demo.print("* clear");
        stack.clear();
        Demo.print("Stack: " + stack.toString());
        Demo.print(System.lineSeparator());
    }


    private class IteratorImpl implements java.util.Iterator<Object> {
        private int index;

        IteratorImpl() {
            index = size();
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException(String.valueOf(index));
            }
            return array.get(--index);
        }

        @Override
        public void remove() {
            array.remove(index);
        }
    }

}
