package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.epam.rd.java.basic.practice6.Demo;

public class Part63 {

	String content;

	List<String> words = new ArrayList<>();

	public Part63(String text) {
		this.content = text;
	}

	public void process() {
		Arrays.stream(content.replace(System.lineSeparator(), " ").split(" ")).forEach(word -> words.add(word));
		words.stream().filter(str->Collections.frequency(words, str)>1).limit(3)
				.map(str -> new StringBuilder(str).reverse().toString().toUpperCase()).forEach(Demo::println);
	}
}
