package com.epam.rd.java.basic.practice5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Logger;

public class Part2 {

    private static final Logger logger = Logger.getGlobal();

    public static void main(final String[] args) {
        final InputStream stdIn = System.in;
        System.setIn(new ByteArrayInputStream(System.lineSeparator()
                .getBytes(StandardCharsets.UTF_8)));
        Spam spam = new Spam(new String[] { "@@@", "bbbbbbb" },  new int[] { 333, 222 });
        spam.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
            Thread.currentThread().interrupt();
        }
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            spam.stop();
        }
        System.setIn(stdIn);
        scanner.close();
    }
}
