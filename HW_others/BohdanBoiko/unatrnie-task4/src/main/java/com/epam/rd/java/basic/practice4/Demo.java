package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Demo {

    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) {
        println("=========== Part1 ===========");
        Part1.main(new String[]{});

        println("=========== Part2 ===========");
        Part2.main(new String[]{});

        System.setIn(new ByteArrayInputStream("char^String^int^double^stop"
                .replace("^", System.lineSeparator())
                .getBytes(StandardCharsets.UTF_8)));
        println("=========== Part3 ===========");
        Part3.main(new String[]{});
        System.setIn(STD_IN);

        println("=========== Part4 ===========");
        Part4.main(new String[]{});

        System.setIn(new ByteArrayInputStream("table ru^table en^apple ru^stop"
                .replace("^", System.lineSeparator())
                .getBytes(StandardCharsets.UTF_8)));
        println("=========== Part5 ===========");
        Part5.main(new String[]{});
        System.setIn(STD_IN);

        System.setIn(new ByteArrayInputStream("Latn^Cyrl^asdf^latn^cyrl^stop"
                .replace("^", System.lineSeparator())
                .getBytes(StandardCharsets.UTF_8)));
        println("=========== Part6 ===========");
        Part6.main(new String[]{});
        System.setIn(STD_IN);
    }

    public static void print(Object o) {
        Syst\u0065m.out.print(o);
    }

    public static void println(Object o) {
        print(o + System.lineSeparator());
    }

    static class Utils {

        private Utils() {
        }

        static String getInputFromFile(String fileName) {
            StringBuilder sb = new StringBuilder();

            try {
                Scanner scanner = new Scanner(new File(fileName), "cp1251");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    sb.append(line).append(System.lineSeparator());
                }
                scanner.close();
                return sb.toString().trim();
            } catch (IOException ex) {
                Demo.println(ex.getStackTrace());
            }

            return sb.toString();
        }

        static void writeToFile(String fileName, String content) {
            File file = new File(fileName);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "cp1251"))) {
                writer.write(content);
            } catch (IOException e) {
                Demo.println(e.getStackTrace());
            }
        }
    }
}
