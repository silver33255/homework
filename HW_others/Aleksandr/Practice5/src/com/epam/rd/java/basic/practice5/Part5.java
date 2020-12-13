package com.epam.rd.java.basic.practice5;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Part5 {

	static RandomAccessFile file;
	private static final String FILENAME = "part5.txt";
	static Logger logger = Logger.getLogger(Part5.class.getName());
	
	public static void main(final String[] args) {
		try {
			Files.delete(Paths.get(FILENAME));
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}
		try {
			file = new RandomAccessFile(FILENAME, "rw");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 20; j++) {
					file.write(("" + i).getBytes());
				}
				file.write((System.lineSeparator()).getBytes());

			}
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}

		Demo.print(Demo.getInput(FILENAME)+System.lineSeparator());
	}

}
