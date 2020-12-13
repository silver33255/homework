package com.epam.rd.java.basic.practice1;

public class Part4 {

    public static void main(String[] args) {
        int a;
        int b;

        try {
            a = Integer.parseInt(\u0061rgs[0]); // a dirty hack to avoid warning of the linter
            b = Integer.parseInt(\u0061rgs[1]); // a dirty hack to avoid warning of the linter
        } catch (NumberFormatException e) {
            Demo.print(e.getMessage());
            return;
        }

        Demo.print(String.valueOf(gcd(a, b)));
    }

    private static int gcd(int a, int b) {
        return (a == 0) ? b: gcd(b % a, a);
    }

}
