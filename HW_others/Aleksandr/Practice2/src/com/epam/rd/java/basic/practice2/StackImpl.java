package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


@SuppressWarnings("all")
public class StackImpl implements Stack{

	private Object[] data;
	
	private int capacity = 0;
	
	private static final String INDEX = "Index ";
	private static final String TOO_BIG = " is too big for length ";
	
	public StackImpl(int size) {
		this.data = new Object[size];
	}
	
	public StackImpl() {
		this.data = new Object[0];
	}
	
	@SuppressWarnings("all")
	public class IteratorImpl implements Iterator<Object> {

		int lastIndex = -1;

		@Override
		public boolean hasNext() {
			return data.length-1 > lastIndex;
		}

		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No next element");
			}
			lastIndex++;
			return data[lastIndex];
		}

		@Override
		public void remove() {
			if (lastIndex >= size()) {
				throw new IndexOutOfBoundsException(INDEX + lastIndex + TOO_BIG + size());
			}
			removedupl(lastIndex);
		}

	}
	
	@Override
	public void clear() {
		this.data = new Object[0];
		this.capacity=0;
	}

	@Override
	public int size() {
	    return this.capacity;
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	public void add(Object element) {
		extendIfNeeded(0);
		this.data[capacity] = element;
		capacity++;
	}

	public Object get(int index) {
		if (index >= size()) {
			return null;
		}
		return this.data[index];
	}
	
	
	public void remove(int index) {
		if (index+1 > size()) {
			return;
		}
		removedupl(index);
	}
	

	public void removedupl(int index) {
		Object[] newData = new Object[size()-1];
		System.arraycopy(data, 0, newData, 0, index);
		System.arraycopy(data, index+1, newData, index, size()-index-1);
		data = newData;
		capacity--;
	}
	
	@Override
	public void push(Object element) {
		extendIfNeeded(1);
		this.data[0] = element;
		capacity++;
	}

	private void extendIfNeeded(int index) {
		if(capacity<=size()) {
			Object[] newData = new Object[size() + 1];
			System.arraycopy(this.data, 0, newData, index, size());
			this.data = newData;
		}
	}
	
	
	@Override
	public Object pop() {
		Object top = get(0);
		remove(0);
		return top;
	}

	@Override
	public Object top() {
		return get(0);
	}
	
	@Override
	public String toString() {
	StringBuilder result = new StringBuilder();
		result.append("[");
		for (int i=data.length-1; i>=0; i--) {
			result.append(data[i]!=null?data[i].toString() + ", ":"null, ");
		}
		for(int i=0; i<2; i++) {
			result.deleteCharAt(result.length()-1);
		}
		result.append("]");
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		//useless method
		throw new UnsupportedOperationException();
	}

}
