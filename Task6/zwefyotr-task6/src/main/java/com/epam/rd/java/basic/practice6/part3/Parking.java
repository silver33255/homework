package com.epam.rd.java.basic.practice6.part3;

public class Parking {
	private int[] places;

	public Parking(int capacity) {
		this.places = new int[capacity];
	}

	public boolean arrive(int k) {
		inputValueValidator(k);
		boolean returnArgument = false;
		int i = k - 1;
		do {
			if (places[i] == 0) {
				places[i] = 1;
				return returnArgument = true;
			}
			if (i == places.length - 1) {
				i = 0;
			}
			i++;
		} while (i != k - 1);
		return returnArgument;
	}

	public boolean depart(int k) {
		inputValueValidator(k);
		boolean returnArgument = false;
		if (places[k - 1] == 1) {
			places[k - 1] = 0;
			return returnArgument = true;
		}
		return returnArgument;
	}

	public void print() {
		for (int parkPlace : places) {
			System.out.print(parkPlace);
		}

	}

	private void inputValueValidator(int value) {
		String message = "Wrong parking number, please choose number betwen 1 - "
				+ places.length;
		if (value < 1) {
			throw new IllegalArgumentException(message);
		}
		if (value > places.length) {
			throw new IllegalArgumentException(message);
		}
	}
}
