package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;

public class Part3 {

    private static final Logger logger = Logger.getGlobal();
    private int counter;
    private int counter2;
    private final int iterations;
    private final int threads;
    private final Thread[] threadsArray;

    public Part3(int threads, int iterations) {
        this.iterations = iterations;
        this.threads = threads;
        counter = 0;
        counter2 = 0;
        threadsArray = new Thread[threads];
    }

    public static void main(final String[] args) {
        Part3 part3 = new Part3(2, 5);
        part3.compare();
        System.out.println();
        part3 = new Part3(2, 5);
        part3.compareSync();
    }

    public void compare() {
        for (int i = 0; i < threads; i++) {
            threadsArray[i] = new Thread(this::threadRun);
            threadsArray[i].start();
        }
        waitForFinishOfThreads();
    }

    private void threadRun() {
        for(int j = 1; j <= iterations; j++) {
            System.out.println(counter + " " + counter2);
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.warning(e.getMessage());
                Thread.currentThread().interrupt();
            }
            counter2++;
        }
    }

    public void compareSync() {
        for (int i = 0; i < threads; i++) {
            threadsArray[i] = new Thread(() -> {
                synchronized (this) {
                    threadRun();
                }
            });
            threadsArray[i].start();
        }
        waitForFinishOfThreads();
    }

    private void waitForFinishOfThreads() {
        for (Thread currentThread : threadsArray) {
            try {
                currentThread.join();
            } catch (InterruptedException e) {
                logger.warning(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
