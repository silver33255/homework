package com.epam.rd.java.basic.practice6.part1;

import java.util.Objects;

public class Word implements Comparable<Word> {
    private final String content;
    private Integer frequency;

    public Word(String content) {
        this.content = content;
        this.frequency = 1;
    }

    public void increaseFrequency() {
        frequency++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return content.equals(word.content) &&
                frequency.equals(word.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, frequency);
    }

    @Override
    public int compareTo(Word o) {
        int compareFrequency = o.frequency.compareTo(frequency);
        if (compareFrequency == 0) {
            return content.compareTo(o.content);
        } else {
            return compareFrequency;
        }
    }

    @Override
    public String toString() {
        return content + " : " + frequency;
    }
}
