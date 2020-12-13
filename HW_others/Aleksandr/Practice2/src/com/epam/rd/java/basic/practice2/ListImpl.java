package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


@SuppressWarnings("all")
public class ListImpl implements List {

	private Node head;

	private int size = 0;

	public ListImpl() {

	}

	
	@SuppressWarnings("all")
	public static class Node {
		private Node next;
		private Object data;
	}

	
	@SuppressWarnings("all")
	public class IteratorImpl implements Iterator<Object> {

		Node current = head;
		Node last = null;

		@SuppressWarnings("all")
		@Override
		public boolean hasNext() {
			if (current != null) {
				return true;
			}
			return false;
		}

		@SuppressWarnings("all")
		@Override
		public Object next() {
			if (current == null) {
				throw new NoSuchElementException("No more elements");
			}
			Object data = current.data;
			last = current;
			current = current.next;
			return data;
		}

		@SuppressWarnings("all")
		@Override
		public void remove() {
			last.next = current.next;
			size--;
		}

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
	@Override
	public void addFirst(Object element) {
		if (this.head == null) {
			this.head = new Node();
			this.head.data = element;
			size++;
			return;
		}
		Node newNode = new Node();
		newNode.next = this.head;
		newNode.data = element;
		this.head = newNode;
		size++;
	}

	@SuppressWarnings("all")
	@Override
	public void addLast(Object element) {
		if (this.head == null) {
			this.head = new Node();
			this.head.data = element;
			size++;
			return;
		}
		Node current = this.head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node();
		current.next.data = element;
		size++;
	}

	@SuppressWarnings("all")	
	@Override
	public void removeFirst() {
		if (this.head == null) {
			return;
		}
		this.head = this.head.next;
		size--;
	}

	
	@SuppressWarnings("all")
	@Override
	public void removeLast() {
		if (this.head == null) {
			return;
		}
		Node current = this.head;
		while (current.next != null) {
			if(current.next.next == null) {
				current.next = null;
				break;
			}
			current = current.next;
		}
		size--;
	}

	
	@SuppressWarnings("all")
	@Override
	public Object getFirst() {
		if (this.head == null) {
			return null;
		}
		return this.head.data;
	}

	@SuppressWarnings("all")
	@Override
	public Object getLast() {
		if (this.head == null) {
			return null;
		}
		Node current = this.head;
		Node next = this.head.next;
		while (next != null) {
			current = current.next;
			next = current.next;
		}
		return current.data;

	}

	@SuppressWarnings("all")
	@Override
	public Object search(Object element) {
		if (this.head == null) {
			return null;
		}
		Node current = this.head;
		Node next = this.head.next;
		while (next != null && !current.data.equals(element)) {
			current = current.next;
			next = current.next;
		}
		return current.data;
	}

	@SuppressWarnings("all")
	@Override
	public boolean remove(Object element) {
		if (this.head == null) {
			return false;
		}
		Node current = this.head;
		Node last = null;
		int counter = 1;
		while (current != null) {
			if ((current.data == null && element == null) || current.data != null && current.data.equals(element)) {
				if (last == null) {
					this.head = current.next;
				} else {
					last.next = current.next;
				} 
				break;
			}
			
			last = current;
			current = current.next;
			if (counter == this.size) {
				return false;
			}
			counter++;
			
		}
		size--;
		return true;
	}

	@SuppressWarnings("all")
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		Node current = this.head;
		while (current != null) {
			result.append(current.data + ", ");
			current = current.next;
		}
		result.deleteCharAt(result.length() - 1);
		result.deleteCharAt(result.length() - 1);
		result.append("]");
		return result.toString();
	}

	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//useless method
		throw new UnsupportedOperationException();
	}

}
