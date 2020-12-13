package com.epam.rd.java.basic.practice1;

public class Part3 {

    public static void main(String[] args) {
        Demo.print(showArray(\u0061rgs)); // a dirty hack to avoid warning of the linter
    }

    public static <T> String showArray(T[] array) {
        StringBuilder result = new StringBuilder();
        int arrayCapacity = array.length;
        for(int i = 0; i < arrayCapacity; i++) {
            result.append(array[i]);
            if (i != arrayCapacity-1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
