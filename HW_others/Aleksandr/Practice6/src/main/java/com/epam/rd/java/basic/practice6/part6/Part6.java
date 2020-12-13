package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.Demo;

public class Part6 {

	public static void main(String[] args) {//NOSONAR
		String filename = "";
		String taskname = "";
		if (args[0].equals("-i") || args[0].equals("--input")) {
			filename = args[1];
			taskname = args[3];
		} else {
			filename = args[3];
			taskname = args[1];
		}
		String fileContents = Demo.getInput(filename);
		switch (taskname) {
		case "frequency":
			Part61 task1 = new Part61(fileContents);
			task1.process();
			break;
		case "length":
			Part62 task2 = new Part62(fileContents);
			task2.process();
			break;
		case "duplicates":
			Part63 task3 = new Part63(fileContents);
			task3.process();
			break;
		default:
			throw new IllegalArgumentException("No such task type");
		}
	}

}
