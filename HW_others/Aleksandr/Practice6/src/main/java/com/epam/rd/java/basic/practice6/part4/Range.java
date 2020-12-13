package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

	boolean reverse;
	int n;
	int m;
	int[] data;

	public Range(int n, int m) {
		this(n, m, false);
	}

	public Range(int firstBound, int secBound, boolean reversedOrder) {
		if (firstBound >= secBound) {
			throw new IllegalArgumentException("n should be less than m");
		}
		this.reverse = reversedOrder;
		this.n = firstBound;
		this.m = secBound;
		this.data = new int[m - n + 1];
		for (int i = 0; i < this.data.length; i++) {
			this.data[i] = n + i;
		}
	}

	public Iterator<Integer> iterator() {
		return new IteratorImpl();
	}

	private final class IteratorImpl implements Iterator<Integer> {

		int lastIndex = reverse?data.length-1:0;
		int currentIndex = reverse?data.length-1:0;

		public boolean hasNext() {
			return reverse ? lastIndex > 0 : lastIndex < data.length - 1;
		}

		public Integer next() {
			if(reverse ? lastIndex <= 0 : lastIndex >= data.length - 1) {
				throw new NoSuchElementException();
			}
			if (reverse) {
				this.lastIndex = this.currentIndex;
				this.currentIndex--;
				return data[lastIndex];
			} else {
				this.lastIndex = this.currentIndex;
				this.currentIndex++;
				return data[lastIndex];
			}
			
		}

	}

}
