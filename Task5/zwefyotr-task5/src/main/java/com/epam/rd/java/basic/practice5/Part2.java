package com.epam.rd.java.basic.practice5;

import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        String[] messages = new String[] { "@@@", "bbbbbbb" };
        int[] times = new int[] { 333, 222 };

        Spam spam = new Spam(messages, times);
        Thread t = new Thread() {
            @Override
            public void run() {
                spam.start();
                Scanner sc = new Scanner(System.in);
                while (!sc.nextLine().equals("")) {
                }
                spam.stop();
            }
        };
        t.start();
        try {
        t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
