package com.epam.rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

	private String content;
	private int frequency;

	public Word(String content, int frequency) {
		this.content = content;
		this.frequency = frequency;
	}

	@Override
	public int compareTo(Word o) {
		if (this.frequency == o.frequency) {
			return 1;
		}
		return this.frequency - o.frequency;
	}

	@Override
	public String toString() {
		return content + " " + frequency;
	}

}
