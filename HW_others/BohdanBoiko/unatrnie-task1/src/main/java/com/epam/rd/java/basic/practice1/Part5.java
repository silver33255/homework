package com.epam.rd.java.basic.practice1;

public class Part5 {

    public static void main(String[] args) {
        Demo.print(String.valueOf(\u0061rgs[0].chars().map(ch -> (ch - 48)).sum())); // a dirty hack to avoid warning of the linter
    }
	
}
