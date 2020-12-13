package com.epam.rd.java.basic.practice4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    Matcher match;

    public static void main(String[] args) {
        String simpleText = "Using information from syntax definitions, "
                + "Sublime Text automatically generates a project-wide " + "index of every class, method and function. "
                + "This index powers Goto Definition, which is exposed in " + "three different ways:";
        Pattern patt = Pattern.compile("(.+\\.)|(..+)");
        Part4 p4 = new Part4(); 
        MyIterator it = p4.new MyIterator(simpleText, patt);
        for (String str : it) {
            System.out.println(str);
        }
    }

    class MyIterator implements Iterable<String> {
        Matcher match;
        
        public MyIterator(String text, Pattern patt) {
            this.match = patt.matcher(text);
        }

        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                @Override
                public boolean hasNext() {
                    return match.find();
                }

                @Override
                public String next() {
                    return match.group();
                }

            };
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
