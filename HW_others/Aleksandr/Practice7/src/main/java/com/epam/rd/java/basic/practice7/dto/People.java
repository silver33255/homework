package com.epam.rd.java.basic.practice7.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class People {

	private List<Person> person;

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	
	
	
}
