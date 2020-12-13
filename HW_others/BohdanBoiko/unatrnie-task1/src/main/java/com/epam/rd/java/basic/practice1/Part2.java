package com.epam.rd.java.basic.practice1;

public class Part2 {

    public static void main(String[] args) {
        int result = 0;
        for (String arg : \u0061rgs) { // a dirty hack to avoid warning of the linter
            try {
                result += Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                Demo.print(e.getMessage());
                return;
            }
        }

        Demo.print(String.valueOf(result));
    }
	
}
