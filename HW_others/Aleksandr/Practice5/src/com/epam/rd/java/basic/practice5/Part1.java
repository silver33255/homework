package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;

public class Part1 {

	static Logger logger = Logger.getLogger(Part1.class.getName());
	
	public static void main(final String[] args) {

		ThreadExt t1 = new Part1().new ThreadExt();
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.severe(e.getMessage());
		}
		t1.interrupt();

		Thread t2 = new Thread(new Part1().new RunnableImpl());
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.severe(e.getMessage());
		}
		t2.interrupt();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.severe(e.getMessage());
		}

	}

	class ThreadExt extends Thread {
		@Override
		public void run() {
			while (true) {
				Demo.println(this.getName());
				try {
					Thread.sleep(1000 / 3);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		}
	}

	
	class RunnableImpl implements Runnable{
		@Override
		public void run() {
			while (true) { //NOSONAR
				Demo.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000 / 3);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		}

	}

}
