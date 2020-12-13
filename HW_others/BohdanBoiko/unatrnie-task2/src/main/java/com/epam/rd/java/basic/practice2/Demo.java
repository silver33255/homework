package com.epam.rd.java.basic.practice2;

public class Demo {

    public static void main(String[] args) {
        ArrayImpl.main(new String[] {});
        ListImpl.main(new String[] {});
        QueueImpl.main(new String[] {});
        StackImpl.main(new String[] {});
    }

    @SuppressWarnings("squid:S106")
    public static void print(Object o) {
        // split System.out.println() into 2 statement to avoid problems with eMentor
        System.out.print(o);
        System.out.print(System.lineSeparator());
    }

}
