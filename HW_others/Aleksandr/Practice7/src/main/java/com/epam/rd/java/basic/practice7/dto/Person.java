package com.epam.rd.java.basic.practice7.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"id", "name", "gender", "pets"})
public class Person {

	private int id;
	private String name;
	private String gender;
	private Pets pets;
	

	
	public Person(int id, String name, String gender, Pets pets) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.pets = pets;
	}
		
	public Person() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Pets getPets() {
		return pets;
	}

	public void setPets(Pets pets) {
		this.pets = pets;
	}
	
	
	
	
}
