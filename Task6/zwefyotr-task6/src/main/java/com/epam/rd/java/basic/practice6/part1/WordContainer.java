package com.epam.rd.java.basic.practice6.part1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class WordContainer {
	private Set<Word> storeSet;

	public WordContainer() {
		storeSet = new TreeSet<>();
	}

	public static void main(String[] args) {
	}

	public boolean add(Word word) {
		return storeSet.add(word);
	}

	public void clear() {
		storeSet.clear();
	}

	public boolean contains(Word word) {
		return storeSet.contains(word);
	}

	public Iterator<Word> iterator() {
		return storeSet.iterator();
	}

	public boolean remove(Word word) {
		return storeSet.remove(word);
	}

	public int size() {
		return storeSet.size();
	}

	@Override
	public String toString() {
		StringBuilder forReturn = new StringBuilder();
		for (Word word : storeSet) {
			forReturn.append(word + "\n");
		}
		return forReturn.toString();
	}
}
