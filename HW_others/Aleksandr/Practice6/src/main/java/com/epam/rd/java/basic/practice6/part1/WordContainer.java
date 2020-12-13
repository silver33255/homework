package com.epam.rd.java.basic.practice6.part1;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Logger;

import com.epam.rd.java.basic.practice6.Demo;

public class WordContainer {

	static Logger logger = Logger.getLogger(WordContainer.class.getName());
	
	public static void main(String[] args) {
		Map<String, Word> wordsMap = new TreeMap<>();
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in, "utf8");
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			sb.append(nextLine).append(" ");
			if(nextLine.contains("stop")) {
				break;
			}
		}
		scanner.close();
		String inputText = sb.toString().trim();
		try {
			Arrays.asList(inputText.split(" ")).stream().filter(word -> !word.trim().isEmpty()).forEach(word -> {
				if ("stop".equals(word)) {
					throw new RuntimeException("Break"); //NOSONAR
				}
				if (wordsMap.containsKey(word)) {
					wordsMap.get(word).incrementFrequency();
				} else {
					wordsMap.put(word, new Word(word));
				}
			});
		} catch (RuntimeException e) {
			logger.severe(e.getMessage());
		}
		wordsMap.values().stream().sorted().forEach(Demo::println);
	}

}
