package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    private Node head;
    private Node tail;
    private int currentSize;

    public QueueImpl() {
        currentSize = 0;
        head = null;
        tail = null;
    }

    @Override
    public void clear() {
        head.element = null;
        tail.element = null;
        currentSize = 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private Node elementQueue = head;
        private int currentIndexElement = 0;

        @Override
        public boolean hasNext() {
            return (currentIndexElement != currentSize);
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (currentIndexElement == 0) {
                currentIndexElement++;
                return elementQueue.element;
            }
            currentIndexElement++;
            elementQueue = elementQueue.next;
            return elementQueue.element;
        }
    }

    @Override
    public void enqueue(Object element) {
        if (currentSize == 0) {
            head = tail = new Node(element, null);
            head.next = tail.next = tail;

        } else {
            tail.next = new Node(element, null);
            tail = tail.next;
        }
        currentSize++;
    }

    @Override
    public Object dequeue() {
        if (currentSize == 0) {
            return null;
        }
        Node buffer = head;
        head = head.next;
        currentSize--;
        return buffer.element;
    }

    @Override
    public Object top() {
        return head.element;
    }

    @Override
    public String toString() {
        IteratorImpl iterElements = new IteratorImpl();
        StringBuilder outputtString = new StringBuilder().append("[");

        while (iterElements.hasNext()) {
            outputtString.append(iterElements.next() + ", ");
        }
        if (size() == 0) {
            outputtString.append("]");
        } else {
            outputtString.replace(outputtString.length() - 2, outputtString.length(), "]");
        }
        return outputtString.toString();
    }

    public static void main(String[] args) {
        QueueImpl qImpl = new QueueImpl();
        qImpl.enqueue("First");
        qImpl.enqueue("Second");
        qImpl.enqueue("Four");
    }

    private static class Node {
        Object element;
        Node next;

        Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
