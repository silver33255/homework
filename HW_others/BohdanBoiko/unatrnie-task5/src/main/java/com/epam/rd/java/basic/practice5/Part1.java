package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;

public class Part1 {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread2();
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            thread1.interrupt();
            logger.warning(e.getMessage());
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            thread2.interrupt();
            logger.warning(e.getMessage());
        }
        thread1.interrupt();
        thread2.interrupt();
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                System.out.println(this.getClass().getSimpleName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.warning(e.getMessage());
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                System.out.println(this.getClass().getSimpleName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.warning(e.getMessage());
                }
            }
        }
    }
}
