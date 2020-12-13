package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;

public class Part4 {

	static Logger logger = Logger.getLogger(Part4.class.getName());
	
	public static void main(final String[] args) {
		String input = Demo.getInput("part4.txt");
		String[] lines = input.split(System.lineSeparator());
		int[][] matrix = new int[lines.length][];
		int i = 0;
		for (String line : lines) {
			String[] arr = line.split(" ");
			matrix[i] = new int[arr.length];
			int j = 0;
			for (String numberStr : line.split(" ")) {
				matrix[i][j] = Integer.parseInt(numberStr);
				j++;
			}
			i++;
		}
		parallel(matrix);
		sequential(matrix);
	}

	private static void sequential(int[][] matrix) {
		long start = System.currentTimeMillis();
		int sequentialMax = Integer.MIN_VALUE;
		for(int[] arr : matrix) {
			for(int num : arr) {
				if(num>sequentialMax) {
					sequentialMax = num;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					logger.severe(e.getMessage());
				}
			}
		}
		long end = System.currentTimeMillis();
		Demo.println(sequentialMax);
		Demo.println(end-start);
	}
	
	private static void parallel(int[][] matrix) {
		long start = System.currentTimeMillis();
		Worker[] pool = new Worker[matrix.length];
		int k = 0;
		for (int[] arr : matrix) {
			Worker w = new Worker();
			w.data = arr;
			w.start();
			pool[k] = w;
			k++;
		}
		Integer[] results = new Integer[pool.length];
		try {
			for (int m=0; m<pool.length; m++) {
				pool[m].join();
				results[m] = pool[m].max;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.severe(e.getMessage());
		}
		int parallelMax = Integer.MIN_VALUE;
		for(int n : results) {
			if(n>parallelMax) {
				parallelMax = n;
			}
		}
		long end = System.currentTimeMillis();
		Demo.println(parallelMax);
		Demo.println(end-start);
	}
	
	private static class Worker extends Thread {
		int[] data;
		int max = Integer.MIN_VALUE;

		@Override
		public void run() {
			for (int i : data) {
				if (i > max) {
					max = i;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					logger.severe(e.getMessage());
				}
			}
		}
	}

}
