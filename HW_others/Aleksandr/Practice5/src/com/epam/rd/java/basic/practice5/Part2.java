package com.epam.rd.java.basic.practice5;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class Part2 {

	static Logger logger = Logger.getLogger(Part2.class.getName());
	
	public static void main(final String[] args) {
		
		InputStream cache = System.in;
		System.setIn(new Part2().new StreamMock());
		Thread t = new Thread() {
			@Override
			public void run() {
				Spam.main(null);
			}
		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.severe(e.getMessage());
		}
		System.setIn(cache);
	}

	private class StreamMock extends InputStream { //NOSONAR
		String s = System.lineSeparator();
		boolean firstCall = false;
		@Override
		public int read() throws IOException {
			if(!firstCall) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					logger.severe(e.getMessage());
				}
				firstCall = true;
			}
			
			for (char c : s.toCharArray()) {
				return (int) c; //NOSONAR
			}
			return -1;
		}

	}

}
