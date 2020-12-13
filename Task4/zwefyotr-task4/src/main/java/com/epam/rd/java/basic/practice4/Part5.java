package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String inputText = "";
        ResourceBundle bundle;
        while (!(inputText = scan.nextLine()).contains("Stop")) {
            bundle = ResourceBundle.getBundle("resources", new Locale(inputText.split(" ")[1]));
            System.out.println(bundle.getString(inputText.split("\\s")[0]));
        }
        scan.close();
    }

}
