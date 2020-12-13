package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;

public class Part3 {

	static Logger logger = Logger.getLogger(Part3.class.getName());
	
	private int counter;

	private int counter2;

	public static void main(final String[] args) {
		Part3 p = new Part3();
		p.compare();
		p.compareSync();
	}

	public void compare() {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		runTask(c1, c2, c3);
	}
	
	public void compareSync() {
		CounterSync c1 = new CounterSync();
		CounterSync c2 = new CounterSync();
		CounterSync c3 = new CounterSync();
		runTask(c1, c2, c3);
	}

	private void runTask(Thread c1, Thread c2, Thread c3) {
		c1.start();
		c2.start();
		c3.start();
		try {
			c1.join();
			c2.join();
			c3.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.severe(e.getMessage());
		}
	}
	
	

	private class Counter extends Thread {
		@Override
		public void run() {
			Demo.println(Integer.compare(counter, counter2));
			counter++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				logger.severe(e.getMessage());
			}
			counter2++;
		}
	}

	
	
	private class CounterSync extends Thread {
		@Override
		public void run() {
			compareData();
			modifyCounter1();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				logger.severe(e.getMessage());
			}
			modifyCounter2();
		}
		
		private synchronized void compareData() {
			Demo.println(Integer.compare(counter, counter2));
		}
		
		private synchronized void modifyCounter1() {
			counter++;
		}
		
		private synchronized void modifyCounter2() {
			counter2++;
		}
	}

}
