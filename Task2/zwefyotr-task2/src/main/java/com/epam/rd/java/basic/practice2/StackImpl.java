package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private Node first;
    private Node last;
    private int stackSize;

    public StackImpl() {
        stackSize = 0;
        first = null;
        last = null;
    }

    @Override
    public void clear() {
        stackSize = 0;
        first.element = null;
        last.element = null;
    }

    @Override
    public int size() {
        return stackSize;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private Node elementStack = first;
        private int currentIndexElement = 0;

        @Override
        public boolean hasNext() {
            return (currentIndexElement != stackSize);
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (currentIndexElement == 0) {
                currentIndexElement++;
                return elementStack.element;
            }
            elementStack = elementStack.prev;
            currentIndexElement++;
            return elementStack.element;
        }
    }

    @Override
    public void push(Object element) {
        if (stackSize == 0) {
            first = last = new Node(element, null);
            first.prev = last.prev = first;

        } else {
            first = new Node(element, first);
        }
        stackSize++;
    }

    @Override
    public Object pop() {
        if (stackSize != 0) {
            Node buffer = first;
            first = first.prev;
            stackSize--;
            return buffer.element;
        } else {
            return first.element;
        }
    }

    @Override
    public Object top() {
        if (stackSize == 0) {
            return null;
        } else {
            return first.element;
        }
    }

    @Override
    public String toString() {
        IteratorImpl iterElements = new IteratorImpl();
        StringBuilder outputtString = new StringBuilder().append("[");

        while (iterElements.hasNext()) {
            outputtString.insert(1, iterElements.next() + ", ");
        }
        if (size() == 0) {
            outputtString.append("]");
        } else {
            outputtString.replace(outputtString.length() - 2, outputtString.length(), "]");
        }
        return outputtString.toString();
    }

    public static void main(String[] args) {
        StackImpl sImpl = new StackImpl();
        sImpl.push("A");
        sImpl.push(null);
        sImpl.push("C");
        sImpl.push(null);

        sImpl.clear();
        sImpl.pop();
        sImpl.pop();

        sImpl.push(null);

        sImpl.pop();

        sImpl.clear();

        sImpl.size();

    }

    private static class Node {
        private Object element;
        private Node prev;

        Node(Object element, Node prev) {
            this.element = element;
            this.prev = prev;
        }
    }
}
