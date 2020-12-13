package com.epam.rd.java.basic.practice5;

import java.util.Scanner;

public class Spam {

	private Thread[] threads;
	private static int[] delays;

	public Spam(final String[] messages, final int[] delays) {
		threads = new Worker[messages.length];
		for (int i = 0; i < messages.length; i++) {
			threads[i] = new Worker();
			threads[i].setName(messages[i]);
		}
		Spam.delays = delays; //NOSONAR
	}

	public static void main(final String[] args) {
		String[] messages = new String[] { "@@@", "bbbbbbb" };
		int[] times = new int[] { 333, 222 };
		Spam s = new Spam(messages, times);
		s.start();
		Scanner sc = new Scanner(System.in);
		if (sc.nextLine().isEmpty()) {
			s.stop();
		}
		sc.close();
	}

	public void start() {
		for (Thread t : threads) {
			t.start();
		}
	}

	public void stop() {
		for (Thread t : threads) {
			t.interrupt();
		}
	}

	private static class Worker extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < Spam.delays.length; i++) {
				try {
					Thread.sleep(Spam.delays[i]);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
				Demo.println(this.getName());
			}

		}
	}

}
