package com.epam.rd.java.basic.practice4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Part2 {

	public static void main(String[] args) {

		try (FileWriter writer = new FileWriter("part2.txt", false)) {
			writer.write(tenRandomNumbers());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String toSorted = Demo.getInput("part2.txt");
		try (FileWriter writer2 = new FileWriter("part2_sorted.txt", false)) {
			writer2.write(bubbleSortedValues(parseToIntArray(toSorted)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(formatingIOData(Demo.getInput("part2.txt"), Demo.getInput("part2_sorted.txt")));

	}

	private static String tenRandomNumbers() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			sb.append(rand.nextInt(50) + " ");
		}
		return sb.toString();
	}

	private static int[] parseToIntArray(String input) {
		String[] inputValues = input.split(" ");
		int[] massive = new int[inputValues.length];
		for (int i = 0; i < inputValues.length; i++) {
			massive[i] = Integer.parseInt(inputValues[i]);
		}
		return massive;
	}

	private static String bubbleSortedValues(int[] input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				if (input[i] > input[j]) {
					int buffer = input[i];
					input[i] = input[j];
					input[j] = buffer;
				}
			}
		}
		for (int i : input) {
			sb.append(i + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	private static String formatingIOData(String input, String sortedInput) {
		StringBuilder output = new StringBuilder();
		output.append("input ==> " + input + "\n" );
		output.append("output ==> " + sortedInput);
		return output.toString();
	}

}
