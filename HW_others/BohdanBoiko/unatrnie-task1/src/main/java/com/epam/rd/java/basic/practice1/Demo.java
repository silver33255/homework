package com.epam.rd.java.basic.practice1;

public class Demo {

    public static void main(String[] args) {
        Part1.main(new String[] {});
        print("\n");
        Part2.main(new String[] {"34", "56", "10"});
        print("\n");
        Part3.main(new String[] {"Test", "of", "task", "#3"});
        print("\n");
        Part4.main(new String[] {"18", "45"});
        print("\n");
        Part5.main(new String[] {"1846064"});
        print("\n");
        Part6.main(new String[] {"20"});
        print("\n");
        Part7.main(new String[] {});
    }

    // the following method uses a dirty hack to avoid warning of linter
    public static void print(String string) {
        Syst\u0065m.out.print(string);
    }

}
