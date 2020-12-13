package com.epam.rd.java.basic.practice7.example.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Root container. Implements the Test entity.
 * 
 * @author D.Kolesnikov
 * 
 */
public class Test {

	private List<Question> questions;

	public List<Question> getQuestions() {
		if (questions == null) {
			questions = new ArrayList<>();
		}
		return questions;
	}
	
	@Override
	public String toString() {
		if (questions == null || questions.isEmpty()) {
			return "Test contains no questions";
		}
		StringBuilder result = new StringBuilder();
		for (Question question : questions) {
			result.append(question).append('\n');
		}
		return result.toString();
	}
}