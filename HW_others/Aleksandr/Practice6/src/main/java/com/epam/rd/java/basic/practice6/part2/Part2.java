package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.epam.rd.java.basic.practice6.Demo;

public class Part2 {

	public static void main(String[] args) {
		int n = 1000;
		int k = 4;
		final ArrayList<Integer> numbersArray = IntStream.range(0, n).mapToObj(Integer::valueOf)
				.collect(Collectors.toCollection(ArrayList::new));
		final LinkedList<Integer> numbersList = IntStream.range(0, n).mapToObj(Integer::valueOf)
				.collect(Collectors.toCollection(LinkedList::new));
		final ArrayList<Integer> numbersArray1 = IntStream.range(0, n).mapToObj(Integer::valueOf)
				.collect(Collectors.toCollection(ArrayList::new));
		final LinkedList<Integer> numbersList1 = IntStream.range(0, n).mapToObj(Integer::valueOf)
				.collect(Collectors.toCollection(LinkedList::new));

		
		long arrayIndexTime = removeByIndex(numbersArray1, k);
		long arrayIteratorTime = removeByIterator(numbersArray, k);
		long listIndexTime = removeByIndex(numbersList1, k);
		long listIteratorTime = removeByIterator(numbersList, k);
		
		Demo.println("ArrayList#Index: "+arrayIndexTime);
		Demo.println("LinkedList#Index: "+listIndexTime);
		Demo.println("ArrayList#Iterator: "+arrayIteratorTime);
		Demo.println("LinkedList#Iterator: "+listIteratorTime);

	}

	public static long removeByIndex(final List<Integer> list, final int k) {
		long start = System.currentTimeMillis();
		int index = k - 1;
		while (list.size() > 1) {
			list.remove(index);
			index = (index + k - 1) % list.size();
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static long removeByIterator(final List<Integer> list, int k) {
		long start = System.currentTimeMillis();
		int index = k - 1;
		while (list.size() > 1) {
			int counter = 0;
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				if (counter == index) {
					iterator.remove();
					break;
				}
				counter++;
			}
			index = (index + k - 1) % list.size();
		}

		long end = System.currentTimeMillis();
		return end - start;
	}
}
