package com.epam.rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

	private String content;

	private int frequency;

	public int compareTo(Word o) {
		int innerOperator = o.frequency - this.frequency == 0 ? 0 : -1;
		return o.frequency - this.frequency > 0 ? 1 : innerOperator;
	}

	public Word(String word) {
		this.content = word;
		this.frequency = 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		return true;
	}

	public void incrementFrequency() {
		this.frequency++;
	}

	@Override
	public String toString() {
		return content + " : " + frequency;
	}

}
