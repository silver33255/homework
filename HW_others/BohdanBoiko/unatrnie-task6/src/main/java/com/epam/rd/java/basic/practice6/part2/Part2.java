package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        initList(arrayList);
        System.out.println("ArrayList#Index: " + removeByIndex(arrayList, 4) + " ms");
        initList(linkedList);
        System.out.println("LinkedList#Index: " + removeByIndex(linkedList, 4) + " ms");
        initList(arrayList);
        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayList, 4) + " ms");
        initList(linkedList);
        System.out.println("LinkedList#Iterator: " + removeByIterator(linkedList, 4) + " ms");
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long startTime = System.currentTimeMillis();
        int currentIndex = 0;

        while (!list.isEmpty()) {
            currentIndex += k;

            // a loop to enable cyclic counting
            while (currentIndex > list.size()) {
                currentIndex -= list.size();
            }

            list.remove(currentIndex - 1);
            currentIndex--; // as element has been removed current index decreased by 1
        }

        return System.currentTimeMillis() - startTime;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long startTime = System.currentTimeMillis();
        int currentIndex = 0;
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            currentIndex++;

            iterator.next();
            if (currentIndex == k) {
                iterator.remove();
                currentIndex = 0;
            }

            // enables further looping
            if (!iterator.hasNext()) {
                iterator = list.iterator();
            }
        }

        return System.currentTimeMillis() - startTime;
    }

    private static void initList(List<Integer> list) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
    }
}
