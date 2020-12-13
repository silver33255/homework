package com.epam.rd.java.basic.practice2;

import java.util.Iterator;


@SuppressWarnings("all")
public class ArrayImpl implements Array {

	private Object[] data;

	private int capacity = 0;
	
	public ArrayImpl(int size) {
		this.data = new Object[size];
	}
	
	public ArrayImpl() {
		this.data = new Object[0];
	}
	
	@SuppressWarnings("all")
	public class IteratorImpl implements Iterator<Object> {

		int lastIndex = -1;

		@Override
		public boolean hasNext() {
			return !(data.length-1 <= lastIndex);
		}

		@Override
		public Object next() {
			lastIndex++;
			return data[lastIndex];
		}

		@Override
		public void remove() {
			removedupl(lastIndex);
		}

	}

	@Override
	public void clear() {
		this.capacity=0;
		this.data = new Object[0];
	}

	@Override
	public int size() {
	    return this.capacity;
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	@Override
	public void add(Object element) {
		if(capacity<=size()) {
			Object[] newData = new Object[size() + 1];
			System.arraycopy(this.data, 0, newData, 0, size());
			this.data = newData;
		}
		this.data[capacity] = element;
		capacity++;
	}

	@Override
	public void set(int index, Object element) {
		if (index >= size()) {
			throw new IndexOutOfBoundsException("Index " + index + " is too big for length " + size());
		}
		this.data[index] = element;
	}

	@Override
	public Object get(int index) {
		return index > size()?null:this.data[index];
	}

	@Override
	public int indexOf(Object element) {
		int i = -1;
		for (Object obj : this.data) {
			if (obj!=null && obj.equals(element)) {
				i++;
				return i;
			}
			i++;
		}
		return -1;
	}

	@Override
	public void remove(int index) {
		removedupl(index);
	}
	
	private void removedupl(int index) {
		if (index >= size()) {
			throw new IndexOutOfBoundsException("Index " + index + " is too big for length " + size());
		}
		Object[] newData = new Object[size()-1];
		System.arraycopy(data, 0, newData, 0, index);
		System.arraycopy(data, index+1, newData, index, size()-index-1);
		data = newData;
		capacity--;
	}
	

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (Object obj : this.data) {
			result.append(obj!=null?obj.toString() + ", ":"null, ");
		}
		result.deleteCharAt(result.length()-1);
		result.deleteCharAt(result.length()-1);
		result.append("]");
		return result.toString();
	}

    public static void main(String[] args) {
    	//useless method
    	throw new UnsupportedOperationException();
    }

}
