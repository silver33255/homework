package com.epam.rd.java.basic.practice2;

public class QueueImpl implements Queue {

    private final Array array;

    public QueueImpl() {
        array = new ArrayImpl(3);
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
        return array.iterator();
    }

    @Override
    public void enqueue(Object element) {
        array.add(element);
    }

    @Override
    public Object dequeue() {
        if (size() == 0) {
            return null;
        } else {
            Object top = top();
            array.remove(0);
            return top;
        }
    }

    @Override
    public Object top() {
        return array.get(0);
    }

    @Override
    public String toString() {
        return array.toString();
    }

    @SuppressWarnings("squid:S1192")
    public static void main(String[] args) {
        Queue queue = new QueueImpl();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Demo.print("* QueueImpl demo:");
        Demo.print("Queue: " + queue.toString());
        Demo.print("* Dequeue");
        Demo.print(queue.dequeue());
        Demo.print("* Top");
        Demo.print(queue.top());
        Demo.print("* Dequeue");
        Demo.print(queue.dequeue());
        Demo.print("* Top");
        Demo.print(queue.top());
        Demo.print("* Size");
        Demo.print(queue.size());
        java.util.Iterator<Object> iterator = queue.iterator();
        Demo.print("* Iterator demo:");
        while (iterator.hasNext()) {
            Demo.print(iterator.next());
        }
        Demo.print("* Clear");
        queue.clear();
        Demo.print("Queue: " + queue.toString());
        Demo.print(System.lineSeparator());
    }

}
