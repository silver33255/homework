package com.epam.rd.java.basic.practice5;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Demo {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        System.out.println("======Part1======");
        Part1.main(new String[] {});
        System.out.println("======Part2======");
        Part2.main(new String[] {});
        System.out.println("======Part3======");
        Part3.main(new String[] {});
        System.out.println("======Part4======");
        Part4.main(new String[] {});
        System.out.println("======Part5======");
        Part5.main(new String[] {});
    }

    static class Utils {

        private Utils() {
        }

        static String getInputFromFile(String fileName) {
            StringBuilder sb = new StringBuilder();

            try {
                Scanner scanner = new Scanner(new File(fileName), "cp1251");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    sb.append(line).append(System.lineSeparator());
                }
                scanner.close();
                return sb.toString().trim();
            } catch (IOException e) {
                logger.warning(e.getMessage());
            }

            return sb.toString();
        }
    }
}
