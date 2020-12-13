package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import sun.applet.Main;

public class Part2 {
	
	private static final Logger logger = Logger.getLogger(Part2.class.getName());

	public static void main(String[] args) {
		ArrayList arrList = (ArrayList) initializationList(
				new ArrayList<Integer>());
		System.out.println("ArrayList removeBy index time is "
				+ removeByIndex(arrList, 3) + " ms");
		LinkedList linkList = (LinkedList) initializationList(
				new LinkedList<Integer>());
		System.out.println("ArrayList removeBy index time is "
				+ removeByIndex(linkList, 3) + " ms");		
		arrList = (ArrayList) initializationList(
				new ArrayList<Integer>());
		System.out.println("ArrayList removeBy iterator time is "
				+ removeByIterator(arrList, 3) + " ms");
		linkList = (LinkedList) initializationList(
				new LinkedList<Integer>());
		System.out.println("ArrayList removeBy iterator time is "
				+ removeByIterator(linkList, 3) + " ms");
	}

	public static long removeByIndex(final List<Integer> list, final int k) {
		long nanosAtStart = System.currentTimeMillis();
		int currentIndex = k - 1;
		while (list.size() != 1) {
			if (currentIndex < list.size()) {
				list.remove(currentIndex);
				currentIndex--;
				currentIndex += k;
			} else {
				while (currentIndex >= list.size())
					currentIndex = currentIndex - list.size();
			}
		}
		return System.currentTimeMillis() - nanosAtStart;
	}

	public static long removeByIterator(final List<Integer> list, int k) {
		long nanosAtStart = System.currentTimeMillis();
		int counter = 1;
		Iterator<Integer> iter = list.iterator();
		
		while (list.size() != 1) {
			while (iter.hasNext()) {
				iter.next();
				if (counter == k) {
					iter.remove();
					counter = 0;
				}
				counter++;
			}
			iter = list.iterator();
		}
		return System.currentTimeMillis() - nanosAtStart;
	}

	private static List<Integer> initializationList(List<Integer> list) {
		for (int i = 0; i < 10_000; i++) {
			list.add(i);
		}
		return list;
	}
}
