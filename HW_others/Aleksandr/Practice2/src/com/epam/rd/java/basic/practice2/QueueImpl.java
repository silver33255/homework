package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("all")
public class QueueImpl implements Queue{

	
	private Node head;

	private int size = 0;
	
	
	@SuppressWarnings("all")
	public static class Node {
		
		@Override
		public String toString() {
			return this.data.toString();
		}
		
		private Node next;
		private Object data;
		
	}
	
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//useless method
		throw new UnsupportedOperationException();
	}

	
	@SuppressWarnings("all")
	public class IteratorImpl implements Iterator<Object> {

		
		@SuppressWarnings("all")
		@Override
		public Object next() {
			if (current != null) {
				Object temp = current.data;
				last = current;
				current = current.next;
				return temp;
			}
			throw new NoSuchElementException("No more elements");
		}

		
		@SuppressWarnings("all")
		@Override
		public boolean hasNext() {
			return current != null;
		}

		
		@SuppressWarnings("all")
		@Override
		public void remove() {
			size--;
			last.next = current.next;
		}
		Node current = head;
		Node last = null;
	}
	
	@SuppressWarnings("all")
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@SuppressWarnings("all")
	@Override
	public int size() {
		return this.size;
	}

	
	@SuppressWarnings("all")
	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	@SuppressWarnings("all")
	private boolean check() {
		return this.head != null;
	}
	
	
	@SuppressWarnings("all")
	@Override
	public void enqueue(Object element) {
		if (this.head != null) {
			Node current = this.head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node();
			current.next.data = element;
			size++;
			return;
		}
		this.head = new Node();
		this.head.data = element;
		size++;
	}

	
	@SuppressWarnings("all")
	@Override
	public Object dequeue() {
		Object res = check() ? this.head.data : null;
		if (check()) {
			this.head = this.head.next;
			size--;
		}
		return res;
	}

	
	@SuppressWarnings("all")
	@Override
	public Object top() {
		return check() ? this.head.data : null;
	}
	
	
	@SuppressWarnings("all")
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		iterator().forEachRemaining(e->result.append(e+", "));
		result.deleteCharAt(result.length() - 1);
		result.deleteCharAt(result.length() - 1);
		result.append("]");
		return result.toString();
	}
	
	

}
