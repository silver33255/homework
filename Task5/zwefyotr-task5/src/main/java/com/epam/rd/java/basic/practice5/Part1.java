package com.epam.rd.java.basic.practice5;

public class Part1 {

    public static void main(String[] args) {

        Thread thread = new MyThread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new MyThread();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println(this.getName());
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
