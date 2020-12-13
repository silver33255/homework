package com.epam.rd.java.basic.practice2;

public class ListImpl implements List {

    private final Array array;

    public ListImpl() {
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
        return array.iterator();
    }

    @Override
    public void addFirst(Object element) {
        Array oldArray = new ArrayImpl(array);
        array.clear();
        array.add(element);
        oldArray.forEach(array::add);
    }

    @Override
    public void addLast(Object element) {
        array.add(element);
    }

    @Override
    public void removeFirst() {
        array.remove(0);
    }

    @Override
    public void removeLast() {
        array.remove(size() - 1);
    }

    @Override
    public Object getFirst() {
        return array.get(0);
    }

    @Override
    public Object getLast() {
        if (size() == 0) {
            return null;
        }
        return array.get(size() - 1);
    }

    @Override
    public Object search(Object element) {
        if (array.indexOf(element) == -1) {
            return null;
        } else {
            return element;
        }
    }

    @Override
    public boolean remove(Object element) {
        int index = array.indexOf(element);
        if (index == -1) {
            return false;
        } else {
            array.remove(index);
            return true;
        }
    }

    @Override
    public String toString() {
        return array.toString();
    }

    @SuppressWarnings("squid:S1192")
    public static void main(String[] args) {
        List list = new ListImpl();
        for (int i = 0; i < 6; i++) {
            list.addLast(i);
        }
        for (int i = -1; i >= -4; i--) {
            list.addFirst(i);
        }
        Demo.print("* ListImpl demo:");
        Demo.print("List: " + list.toString());
        Demo.print("The first element: " + list.getFirst());
        Demo.print("The last element: " + list.getLast());
        Demo.print("* Remove element '5'");
        Demo.print(list.remove(5));
        Demo.print("* Remove last element");
        list.removeLast();
        Demo.print("* Remove first element");
        list.removeFirst();
        Demo.print("* Search 'null'");
        Demo.print(list.search(null));
        Demo.print("* Search '-3'");
        Demo.print(list.search(-3));
        Demo.print("List: " + list.toString());
        Demo.print("* Size");
        Demo.print(list.size());
        Demo.print("* Iterator demo:");
        java.util.Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Demo.print(iterator.next());
        }
        Demo.print("* Clear");
        list.clear();
        Demo.print("List: " + list.toString());
        Demo.print(System.lineSeparator());
    }

}