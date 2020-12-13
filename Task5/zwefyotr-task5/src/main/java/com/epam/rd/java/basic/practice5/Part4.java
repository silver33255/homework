package com.epam.rd.java.basic.practice5;

public class Part4 {
    int max;
    int min;

    public static void main(final String[] args) {
        String inputFile = Demo.getInput("part4.txt");
        Part4 part4 = new Part4();

        String[] mass = inputFile.split("\n");

        System.out.println(part4.getMax());
    }

    public int reciveMAX(int[] massive) {
        int max = massive[0];
        for (int i = 1; i < massive.length; i++) {
            if (max < massive[i]) {
                max = massive[i];
            }
        }
        return max;
    }

    public synchronized int getMax() {
        return max;
    }

    public synchronized void setMax(int newMax) {
        max = newMax;
    }

    class MyThread extends Thread {
        int maxCurrentThread;
        int[] masseDigits;

        public MyThread(int[] lineMsss) {
            masseDigits = lineMsss;
            maxCurrentThread = masseDigits[0];
        }

        @Override
        public void run() {
            for (int element : masseDigits) {
                if (element > maxCurrentThread) {
                    maxCurrentThread = element;
                }
            }
        }
        
    }
}
