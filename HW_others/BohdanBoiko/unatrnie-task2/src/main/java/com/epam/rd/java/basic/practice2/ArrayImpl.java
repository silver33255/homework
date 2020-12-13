package com.epam.rd.java.basic.practice2;

public class ArrayImpl implements Array {

    private Object[] elements;

    private int size;

    public ArrayImpl() {
        elements = new Object[10];
        size = 0;
    }

    public ArrayImpl(Array array) {
        elements = new Object[array.size()];
        array.forEach(this::add);
    }

    public ArrayImpl(int capacity) {
        elements = new Object[capacity];
    }

	@Override
    public void clear() {
        size = 0;
    }

	@Override
    public int size() {
        return size;
    }
	
	@Override
    public java.util.Iterator<Object> iterator() {
	    return new IteratorImpl();
    }

	@Override
    public void add(Object element) {
        ensureCapacity();
        elements[size++] = element;
    }

	@Override
    public void set(int index, Object element){
        if (index < 0 || size == 0 || index > size) {
            throw new IndexOutOfBoundsException("Can not set: " + index);
        }
        elements[index] = element;
    }

	@Override
    public Object get(int index) {
        if (size == 0 && index >= 0) {
            return null;
        }
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Can not get: " + index);
        }
        return elements[index];
    }

	@Override
    public int indexOf(Object element) {
        int index = -1;
        if (element == null) {
            for (int i = 0; i < elements.length; i++) {
                if (null == elements[i]) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (element.equals(elements[i])) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

	@Override
    public void remove(int index) {
        if (index < 0 || size == 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Can not remove: " + index);
        }
        if (index == size - 1) {
            size--;
            return;
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]).append(", ");
        }
        int length = stringBuilder.length();
        stringBuilder.delete(length - 2, length).append("]");

        return stringBuilder.toString();
    }

    @SuppressWarnings("squid:S1192")
    public static void main(String[] args) {
        Array array = new ArrayImpl();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        Demo.print("* ArrayImpl demo:");
        Demo.print("Array: " + array.toString());
        Demo.print("The second element: " + array.get(1));
        Demo.print("* Remove 3 index");
        array.remove(3);
        Demo.print("* Size");
        Demo.print(array.size());
        Demo.print("* Set 'null' with index 5");
        array.set(5, null);
        Demo.print("Array: " + array.toString());
        Demo.print("Index of null: " + array.indexOf(null));
        Demo.print("* Iterator demo:");
        java.util.Iterator<Object> iterator = array.iterator();
        while (iterator.hasNext()) {
            Demo.print(iterator.next());
        }
        Demo.print("* Clear");
        array.clear();
        Demo.print("Array: " + array.toString());
        Demo.print(System.lineSeparator());
    }

    private void ensureCapacity() {
        if (size < elements.length) {
            return;
        }
        Object[] tempElements = new Object[elements.length];
        System.arraycopy(elements, 0, tempElements, 0, elements.length);
        elements = new Object[2 * tempElements.length];
        System.arraycopy(tempElements, 0, elements, 0, tempElements.length);
    }

    private class IteratorImpl implements java.util.Iterator<Object> {
        private int index;

        IteratorImpl() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException(String.valueOf(index));
            }
            return elements[index++];
        }

        @Override
        public void remove() {
            ArrayImpl.this.remove(index - 1);
        }
    }

}
