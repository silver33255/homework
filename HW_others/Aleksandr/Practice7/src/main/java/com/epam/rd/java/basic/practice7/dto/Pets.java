package com.epam.rd.java.basic.practice7.dto;

import java.util.ArrayList;
import java.util.List;

public class Pets {
	
	private List<Pet> pet = new ArrayList<>();


	public List<Pet> getPet() {
		return pet;
	}

	public void setPet(List<Pet> pet) {
		this.pet = pet;
	}
	
	
	
}
