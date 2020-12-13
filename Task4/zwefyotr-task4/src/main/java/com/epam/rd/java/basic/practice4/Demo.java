package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static final String NEW_LINE = System.lineSeparator() + System.lineSeparator();

    public static void main(String[] args) {
        System.out.print("Part1" + NEW_LINE);
        System.out.print("---InnerText---" + System.lineSeparator());
        System.out.print(Demo.getInput("part1.txt") + NEW_LINE);
        System.out.print("---reciveTextAfterMethod---" + System.lineSeparator());
        Part1.main(new String[]{});
    }
    
    public static String getInput(String fileName) {
        String encoding = System.getProperty( "console.encoding", "Cp1251" );
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), encoding);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

}
