package com.epam.rd.java.basic.practice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {
	public static String getInput(String fileName) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(new File(fileName), "cp1251");
		while (scanner.hasNextLine()) {
			sb.append(scanner.nextLine()).append(System.lineSeparator());
		}
		scanner.close();
		return sb.toString().trim();
	}

	public static void main(String[] args){
	}
}
