package com.epam.rd.java.basic.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String> {

    private String content;

    public Part4() {
        content = Demo.Utils.getInputFromFile("part4.txt");
        content = content.replaceAll(System.lineSeparator(), " ");
    }

    public static void main(String[] args) {
        new Part4().forEach(Demo::println);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private Matcher matcher = Pattern.compile("[\"’]?\\p{Lu}[^.?!]+((?![.?!][’\"]?\\s[\"’]?\\p{Lu}[^.?!]).)+[.?!’\"]+").matcher(content + " ");

            @Override
            public boolean hasNext() {
                return matcher.find();
            }

            @Override
            public String next() {
                if (matcher.end() > content.length()) {
                    throw new NoSuchElementException("Iteration beyond the collection." +
                            " Matcher end: " +
                            matcher.end() +
                            " .Content length: " +
                            content.length());
                }
                return matcher.group();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove is unsupported");
            }
        };
    }


}
