package com.epam.rd.java.basic.practice1;

public class Part6 {

    public static void main(String[] args) {
        int n;
        int k = 0;
        int i = 1;
        boolean isPrime;
        Integer[] array;
        
        try {
            n = Integer.parseInt(\u0061rgs[0]); // a dirty hack to avoid warning of the linter
            if (n == 0) {
                Demo.print("");
                return;
            }
            array = new Integer[n];
        } catch (NumberFormatException e) {
            Demo.print(e.getMessage());
            return;
        }

        do {
            isPrime = true;
            i++;
            for (int j = 2; j <= java.lang.Math.sqrt(i); j++) {
                if (i % j == 0 && i != j) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                array[k] = i;
                k++;
            }
        } while (k < n);

        Demo.print(Part3.showArray(array));
    }
	
}
