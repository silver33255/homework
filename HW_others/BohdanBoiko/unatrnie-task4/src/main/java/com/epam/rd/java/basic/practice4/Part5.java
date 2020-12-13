package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Syst\u0065m.in);
        String nextLine;

        while (scanner.hasNext() && !"stop".equals(nextLine = scanner.nextLine())) {
            String field = nextLine.split("\\s")[0];
            String language = nextLine.split("\\s")[1];
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language));
            Demo.println(resourceBundle.getString(field));
        }
        scanner.close();
    }

}
