package com.epam.rd.java.basic.practice5;

public class Spam {

    private Thread[] threads;

    public Spam(final String[] messages, final int[] delays) {
        threads = new Thread[messages.length];
        for (int i = 0; i < messages.length; i++) {
            threads[i] = new Worker(messages[i], delays[i]);
        }
    }

    public static void main(final String[] args) {

    }

    public void start() {
        for (Thread th : threads) {
            th.start();
        }
    }

    public void stop() {
        for (Thread th : threads) {
            th.interrupt();
        }
    }

    public Thread[] reciveThreads() {
        return threads;
    }

    private static class Worker extends Thread {
        String messgae;
        int delay;

        boolean isIterrupted = Thread.interrupted();

        public Worker(String message, int delay) {
            this.messgae = message;
            this.delay = delay;
        }

        @Override
        public void run() {
            while (!isIterrupted) {
                System.out.println(messgae);
                try {
                    sleep(delay);
                } catch (InterruptedException e) {
                    isIterrupted = true;
                }
            }
        }
    }
}
