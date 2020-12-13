package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.epam.rd.java.basic.practice6.Demo;

public class Part62 {
	
	String content;

	List<String> words = new ArrayList<>();
	
	public Part62(String text) {
		this.content = text;
	}

	public void process() {
		Arrays.stream(content.replace(System.lineSeparator(), " ").split(" ")).forEach(word->{
			if(!words.contains(word)) {
				words.add(word);
			}
		});
		Comparator<String> comp = ((o1, o2)->{
			if(Integer.compare(o2.length(), o1.length())!=0) {
				return Integer.compare(o2.length(), o1.length());
			}
			return Integer.compare(words.indexOf(o1), words.indexOf(o2));
		});
		words.stream().sorted(comp).limit(3).forEach(entry->Demo.println(entry+" ==> "+entry.length()));
	}
}
