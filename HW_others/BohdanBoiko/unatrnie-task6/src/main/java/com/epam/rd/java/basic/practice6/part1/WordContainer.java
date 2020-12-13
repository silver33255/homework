package com.epam.rd.java.basic.practice6.part1;

import java.util.*;

public class WordContainer {
	private final Map<String, Word> words;

	public WordContainer() {
		words = new HashMap<>();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String[] wordsInLine = scanner.nextLine().split("\\s+");
			if ("stop".equals(wordsInLine[0])) {
				break;
			}

			processInputWords(wordsInLine);
		}
		words.values().stream().sorted().forEach(System.out::println);
	}

	private void processInputWords(String[] wordsInLine) {
		for (String word : wordsInLine) {
			if ("stop".equals(word)) {
				break;
			}
			if (words.containsKey(word)) {
				words.get(word).increaseFrequency();
			} else {
				words.put(word, new Word(word));
			}
		}
	}

	public static void main(String[] args) {
		new WordContainer().start();
	}
	
}
