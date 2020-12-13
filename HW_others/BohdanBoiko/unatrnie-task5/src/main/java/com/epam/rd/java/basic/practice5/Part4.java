package com.epam.rd.java.basic.practice5;

import java.util.Arrays;
import java.util.logging.Logger;

public class Part4 {

    private static final Logger logger = Logger.getGlobal();

    public static void main(final String[] args) {
        int[][] matrix = getMatrix();

        executeInMultiThread(matrix);
        executeInOneThread(matrix);
    }

    private static void executeInOneThread(int[][] matrix) {
        long startTime = System.nanoTime();
        final int[] maxValue = {0};

        Arrays.stream(matrix)
                .forEach(row -> Arrays.stream(row)
                        .forEach(value -> {if (maxValue[0] < value) {
                            maxValue[0] = value;
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                logger.warning(e.getMessage());
                                Thread.currentThread().interrupt();
                            }
                        }}));

        System.out.println(maxValue[0]);
        System.out.println((System.nanoTime() - startTime) / 1000000);
    }

    private static void executeInMultiThread(int[][] matrix) {
        long startTime = System.nanoTime();
        RowProcessor[] rowProcessors = new RowProcessor[matrix.length];
        int maxValue = 0;

        for (int i = 0; i < matrix.length; i++) {
            RowProcessor rowProcessor = new RowProcessor(matrix[i]);
            rowProcessors[i] = rowProcessor;
            rowProcessors[i].start();
        }
        for (RowProcessor rowProcessor : rowProcessors) {
            if (maxValue < rowProcessor.getMaxValueInRow()) {
                maxValue = rowProcessor.getMaxValueInRow();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                logger.warning(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(maxValue);
        System.out.println((System.nanoTime() - startTime) / 1000000);
    }

    private static int[][] getMatrix() {
        String part4 = Demo.Utils.getInputFromFile("part4.txt");
        String[] rows = part4.split(System.lineSeparator());
        int[][] matrix = new int[rows.length][rows[0].split("\\s+").length];

        for (int i = 0; i < rows.length; i++) {
            String[] numbersInRow = rows[i].split("\\s+");
            for (int j = 0; j < numbersInRow.length; j++) {
                matrix[i][j] = Integer.parseInt(numbersInRow[j]);
            }
        }

        return matrix;
    }

    private static class RowProcessor extends Thread {
        private final int[] row;
        private int maxValueInRow = 0;
        private boolean isFinished = false;

        RowProcessor(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            for (int number : row) {
                if (maxValueInRow < number) {
                    maxValueInRow = number;
                }
            }
            isFinished = true;
        }
        public int getMaxValueInRow() {
            while (!isFinished) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    logger.warning(e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
            return maxValueInRow;
        }
    }
}
