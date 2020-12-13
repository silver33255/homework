package com.epam.rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

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
