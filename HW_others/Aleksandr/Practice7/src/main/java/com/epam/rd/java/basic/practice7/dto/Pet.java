package com.epam.rd.java.basic.practice7.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pet{
	
	@XmlElement(name = "pet-id")
	private int id;
	@XmlElement(name = "pet-name")
	private String name;
	@XmlElement(name = "pet-age")
	private int age;
	
	
	public Pet(int id, int age, String name) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Pet() {
		
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
}
