package com.epam.rd.java.basic.practice3;

import java.io.*;
import java.util.Scanner;

public class Util {

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            Demo.print(ex.getStackTrace());
        }
        return sb.toString();
    }

    // this method can read file entirely for Part6 despite on inability to get tenth letter of Russian alphabet
    public static String getInputForPart6(String fileName) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            Demo.print(ex.getStackTrace());
        }
        return resultStringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        Demo.print(input);
    }
}