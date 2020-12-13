package com.epam.rd.java.basic.practice6.part2;

import com.epam.rd.java.basic.practice6.OutputSubstitution;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Part2Test extends OutputSubstitution {
    @Test
    public void index_timeForArrayListShouldBeLowerThanForLinkedList() {
        Part2.main(null);
        int[] timeArray = getTime();
        Assert.assertTrue("time: " + timeArray[0] + ", " + timeArray[1], timeArray[0] < timeArray[1]);
    }

    @Test
    public void iterator_timeForLinkedListShouldBeLowerThanForArrayList() {
        Part2.main(null);
        int[] timeArray = getTime();
        Assert.assertTrue("time: " + timeArray[3] + ", " + timeArray[2], timeArray[3] <= timeArray[2]);
    }

    private int[] getTime() {
        int[] timeArray = new int[4];
        int i = 0;
        Scanner scanner = new Scanner(outContent.toString());
        while (scanner.hasNextLine()) {
            String stringTime = scanner.nextLine().split("\\s+")[1];
            timeArray[i] = Integer.parseInt(stringTime);
            i++;
        }
        return timeArray;
    }
}