package com.epam.rd.java.basic.practice4;

import java.security.SecureRandom;

public class Part2 {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        Part2.IntArray intArray = new Part2.IntArray(array);

        Demo.Utils.writeToFile("part2.txt", intArray.toString());
        intArray.printArray("input ==>");
        intArray.bubbleSort();
        Demo.Utils.writeToFile("part2_sorted.txt", intArray.toString());
        intArray.printArray( "output ==>");
    }

    private static class IntArray {
        private int[] array;

        IntArray(int[] array) {
            this.array = array;
        }

        void bubbleSort() {
            boolean isSorted = false;
            while (!isSorted) {
                isSorted = true;
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < array[i - 1]) {
                        swap(i, i - 1);
                        isSorted = false;
                    }
                }
            }
        }

        private void swap(int index1, int index2) {
            int tmp = array[index1];
            array[index1] = array[index2];
            array[index2] = tmp;
        }

        void printArray(String description) {
            Demo.println(description + " " + toString());
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for(int element : array) {
                stringBuilder.append(' ').append(element);
            }
            return stringBuilder.toString().trim();
        }
    }
}
