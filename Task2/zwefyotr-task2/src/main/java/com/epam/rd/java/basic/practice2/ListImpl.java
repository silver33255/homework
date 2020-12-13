package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    Node head;

    private int size;

    public ListImpl() {
        size = 0;
        head = new Node(null, null, null);
        head.next = head;
        head.prev = head.next;
    }

    @Override
    public void clear() {
        head.next = head;
        head.prev = head.next;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private Node currentNode = head;
        int checkSize = 0;

        @Override
        public boolean hasNext() {
            return (checkSize != size());
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            checkSize++;
            currentNode = currentNode.next;
            return currentNode.element;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newElem = new Node(element, head.next, head);
        newElem.prev.next = newElem;
        newElem.next.prev = newElem;
        size++;
    }

    @Override
    public void addLast(Object element) {
        Node newElem = new Node(element, head, head.prev);
        newElem.prev.next = newElem;
        newElem.next.prev = newElem;
        size++;
    }

    @Override
    public void removeFirst() {
        head.next = head.next.next;
        head.next.prev = head;
        size--;
    }

    @Override
    public void removeLast() {
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
    }

    @Override
    public Object getFirst() {
        return head.next.element;
    }

    @Override
    public Object getLast() {
        return head.prev.element;
    }

    @Override
    public Object search(Object element) {
        IteratorImpl it = new IteratorImpl();
        Object concurrency;
        if (element == null) {
            return null;
        }
        while (it.hasNext()) {
            concurrency = it.next();
            if (concurrency != null && concurrency.equals(element)) {
                return concurrency;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        Node buffer = head;
        boolean elementExist = false;
        int i = 0;

        if (element == null) {
            while (i != size) {
                buffer = buffer.next;
                if (buffer.element == element) {
                    buffer.prev.next = buffer.next;
                    buffer.next.prev = buffer.prev;
                    size--;
                    elementExist = true;
                    return elementExist;
                }
                i++;
            }
        } else {
            while (i != size) {
                buffer = buffer.next;

                if (buffer.element != null && buffer.element.equals(element)) {
                    buffer.prev.next = buffer.next;
                    buffer.next.prev = buffer.prev;
                    size--;
                    elementExist = true;
                    return elementExist;
                }
                i++;
            }
        }
        return elementExist;
    }

    @Override
    public String toString() {
        IteratorImpl it = new IteratorImpl();
        StringBuilder resultString = new StringBuilder().append("[");
        if (size == 0) {
            resultString.append("]");
        } else {
            while (it.hasNext()) {
                resultString.append(it.next() + ", ");
            }
            resultString.replace(resultString.length() - 2, resultString.length(), "]");
        }
        return resultString.toString();
    }

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addFirst(null);
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("W");
    }

    private static class Node {
        Object element;
        Node prev;
        Node next;

        Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
