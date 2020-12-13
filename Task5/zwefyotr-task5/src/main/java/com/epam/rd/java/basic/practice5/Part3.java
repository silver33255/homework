package com.epam.rd.java.basic.practice5;

public class Part3 {
    private int counter;
    private int counter2;
    private int numberIterations;
    private Thread[] threads;

    public Part3(int numberThreads, int numberIterations) {
        this.threads = new Thread[numberThreads];
        counter = 0;
        counter2 = 0;
        this.numberIterations = numberIterations;
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3(3, 5);
        part3.compareSync();
    }

    public void compare() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public void compareSync() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Thread());
            threads[i].run();
            {
                synchronized (this) {
                    for (int j = 0; j < numberIterations; j++) {
                        System.out.println(counter + " == " + counter2);
                        counter++;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter2++;
                    }
                }
            }
            threads[i].start();
            ;
        }
    }
}