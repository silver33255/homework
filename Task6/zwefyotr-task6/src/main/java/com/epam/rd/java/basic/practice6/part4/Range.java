package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
	int from;
	int to;
	boolean reverse;

	public Range(int n, int m) {
		this(n, m, false);
	}

	public Range(int firstBound, int secBound, boolean reversedOrder) {
		from = firstBound;
		to = secBound;
		reverse = reversedOrder;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new IteratorImpl();
	}

	private final class IteratorImpl implements Iterator<Integer> {

		@Override
		public boolean hasNext() {
			return (from != to + 1);
		}

		@Override
		public Integer next() {
			if (!reverse) {
				return from++;
			}
			return to--;
		}

	}

}
