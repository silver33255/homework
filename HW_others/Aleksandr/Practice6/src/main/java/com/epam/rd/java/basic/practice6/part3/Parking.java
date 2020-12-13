package com.epam.rd.java.basic.practice6.part3;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.epam.rd.java.basic.practice6.Demo;

public class Parking {

	int[] places;

	public Parking(int capacity) {
		this.places = new int[capacity];
	}

	public boolean arrive(int k) {
		if (k < 0 || k >= places.length) {
			throw new IllegalArgumentException("Place out of bounds");
		}
		boolean flag = false;
		do {
			if (this.places[k] == 0) {
				this.places[k] = 1;
				return true;
			} else {
				k++;
			}
			if(flag && k == places.length) {
				return false;
			}
			if(k == places.length) {
				flag = true;
				k = 0;
			}
		} while (k < places.length);
		return false;

	}

	public boolean depart(int k) {
		if (k < 0 || k >= places.length) {
			throw new IllegalArgumentException("Place out of bounds");
		}
		if(this.places[k]==1) {
			this.places[k] = 0;
			return true;
		}
		return false;
	}

	public void print() {
		Demo.println(Arrays.stream(this.places).mapToObj(Integer::toString).collect(Collectors.joining()));
	}
}
