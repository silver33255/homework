package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Part2 {

	public static void main(String[] args) {
		File part2 = new File("part2.txt");
		File part2Sorted = new File("part2_sorted.txt");
		try {
			try (FileWriter fw1 = new FileWriter(part2); FileWriter fw2 = new FileWriter(part2Sorted);) {
				Random rand = new Random();//NOSONAR
				int[] numbers = new int[10];
				Demo.print("input ==> ");
				for (int i = 0; i < 10; i++) {
					int num = rand.nextInt(51);
					fw1.write("" + num + (i == 9 ? "" : " "));
					numbers[i] = num;
					Demo.print(num + (i == 9 ? "\n" : " "));
				}
				sort(numbers, 0, numbers.length - 1);
				Demo.print("output ==> ");
				for (int i = 0; i < 10; i++) {
					fw2.write("" + numbers[i] + (i == 9 ? "" : " "));
					Demo.print(numbers[i] + (i == 9 ? "\n" : " "));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();//NOSONAR
		}

	}

	public static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for (int i = 0; i < n1; ++i) {
			left[i] = arr[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			right[j] = arr[m + 1 + j];
		}
		int i = 0;
		int j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

}
