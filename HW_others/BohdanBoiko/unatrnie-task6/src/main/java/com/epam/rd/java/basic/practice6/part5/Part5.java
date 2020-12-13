package com.epam.rd.java.basic.practice6.part5;

public class Part5 {
    
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(new Integer[] {3, 7, 1, 8, 6, 2, 5, 2, 43, 0, 4, 11});
        System.out.println("========= add(3, 7, 1, 8, 6, 2, 5, 2, 43, 0, 4, 11):");
        tree.print();
    }
}
