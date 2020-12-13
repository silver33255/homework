package com.epam.rd.java.basic.practice1;

public class Part7 {

    private static final String ARROW = " ==> ";

    public static void main(String[] args) {
        Demo.print("A" + ARROW + str2int("A") + ARROW + int2str(1) + "\n");
        Demo.print("B" + ARROW + str2int("B") + ARROW + int2str(2) + "\n");
        Demo.print("Z" + ARROW + str2int("Z") + ARROW + int2str(26) + "\n");
        Demo.print("AA" + ARROW + str2int("AA") + ARROW + int2str(27) + "\n");
        Demo.print("AZ" + ARROW + str2int("AZ") + ARROW + int2str(52) + "\n");
        Demo.print("BA" + ARROW + str2int("BA") + ARROW + int2str(53) + "\n");
        Demo.print("ZZ" + ARROW + str2int("ZZ") + ARROW + int2str(702) + "\n");
        Demo.print("AAA" + ARROW + str2int("AAA") + ARROW + int2str(703) + "\n");
    }

    public static int str2int(String number) {
        final int[] grade = {0};
        return reverse(number.chars().map(n -> n - 64).boxed())
                .mapToInt(n -> n * (int) java.lang.Math.pow(26, grade[0]++))
                .sum();
    }

    public static String int2str(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        int remainder;
        do {
            remainder = number % 26;
            number = (number - remainder) / 26;
            if (remainder == 0) {
                remainder = 26;
                number--;
            }
            stringBuilder.append(Character.toChars(remainder + 64)[0]);
        } while (number > 26);
        if (number != 0) {
            stringBuilder.append(Character.toChars(number + 64)[0]);
        }
        return stringBuilder.reverse().toString();
    }

    public static String rightColumn(String number) {
        final int Z_CODEPOINT = 90;
        final int A_CODEPOINT = 65;
        int codePoint;
        char[] letters = number.toCharArray();
        boolean needShift = true;

        for (int i = letters.length-1; i >= 0; i--) {
            codePoint = letters[i]+1;
            if (codePoint > Z_CODEPOINT) {
                letters[i] = (char) A_CODEPOINT;
            } else {
                letters[i] = (char) codePoint;
                needShift = false;
                break;
            }
        }

        if (needShift) {
            return String.valueOf(letters) + "A";
        } else {
            return String.valueOf(letters);
        }
    }

    public static <T> java.util.stream.Stream<T> reverse(java.util.stream.Stream<T> stream) {
        java.util.LinkedList<T> stack = new java.util.LinkedList<>();
        stream.forEach(stack::push);

        return stack.stream();
    }

}
