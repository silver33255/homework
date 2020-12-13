package com.epam.rd.java.basic.practice5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Spam {

    private static final Logger logger = Logger.getGlobal();
    private final Thread[] threads;
    private volatile boolean continueExecuting;
    private final int maxDelay;

    public Spam(final String[] messages, final int[] delays) {
        maxDelay = Arrays.stream(delays).max().orElse(500);
        int numberOfThreads = messages.length;
        threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Worker(messages[i], delays[i]);
        }
    }

    public static void main(final String[] args) {
        Spam spam = new Spam(new String[]{"Hello", "World"}, new int[]{250, 500});
        spam.start();

        Scanner scanner = new Scanner(System.in);
        String input = null;

        while (!"".equals(input)) {
            input = scanner.nextLine();
            if ("".equals(input)) {
                spam.stop();
            }
        }
        scanner.close();
    }

    public void start() {
        continueExecuting = true;
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void stop() {
        continueExecuting = false;
        try {
            Thread.sleep(maxDelay);
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
            Thread.currentThread().interrupt();
        }
        logger.info("all threads are stopped");
    }

    private class Worker extends Thread {
        private final String message;
        private final int delay;

        private Worker(final String message, final int delay) {
            this.message = message;
            this.delay = delay;
        }

        @Override
        public void run() {
            while (continueExecuting) {
                System.out.println(message);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    logger.warning(e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
