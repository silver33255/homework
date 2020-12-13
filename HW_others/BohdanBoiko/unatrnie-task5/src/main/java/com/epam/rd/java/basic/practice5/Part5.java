package com.epam.rd.java.basic.practice5;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Part5 {

    private static final String PATH = "part5.txt";
    private static final Logger logger = Logger.getGlobal();

    public static void main(final String[] args) {
        try (RandomAccessFile file = new RandomAccessFile(PATH, "rw");) {
            for (int i = 0; i < 10; i++) {
                ConcurrentWriter currentWriter = new ConcurrentWriter(i, file);
                currentWriter.start();
                currentWriter.join();
            }
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
            Thread.currentThread().interrupt();
        } catch (IOException ex) {
            logger.warning(ex.getMessage());
        }

        Path path = Paths.get(PATH);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                stringBuilder
                        .append(Files.readAllLines(path).get(i))
                        .append(System.lineSeparator());
            }
            System.out.println(stringBuilder.toString().trim());
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }

    private static class ConcurrentWriter extends Thread {
        private final String digit;
        private final RandomAccessFile file;

        private ConcurrentWriter(int digit, RandomAccessFile file) {
            this.digit = String.valueOf(digit);
            this.file = file;
        }

        @Override
        public void run() {
            for (int i = 0; i < 19; i++) {
                write();
            }
            if ("9".equals(digit)) {
                write();
            } else {
                writeln();
            }
        }

        private void writeln() {
            try {
                file.write((digit + System.lineSeparator()).getBytes());
            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }

        private void write() {
            try {
                file.write(digit.getBytes());
            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }
    }
}
