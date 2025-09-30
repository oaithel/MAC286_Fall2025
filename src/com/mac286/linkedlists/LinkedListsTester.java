package com.mac286.linkedlists;

import java.util.ArrayList;

public class LinkedListsTester {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-1);
        A.add(-3);
        A.add(-5);
        System.out.println("A.size: " + A.size() + " A: " + A);
        A.add(1, -7);
        System.out.println("A.size: " + A.size() + " A: " + A);
        System.out.println("element at index 2 is: " + A.get(2));
        A.addFirst(-9);
        System.out.println("A.size: " + A.size() + " A: " + A);
        A.addLast(-11);
        System.out.println("A.size: " + A.size() + " A: " + A);
        System.out.println("Removing element at index 0: " + A.remove(0));
        System.out.println("A.size: " + A.size() + " A: " + A);
        System.out.println("Removing first: " + A.removeFirst());
        System.out.println("A.size: " + A.size() + " A: " + A);
        System.out.println("Removing first: " + A.removeLast());
        System.out.println("A.size: " + A.size() + " A: " + A);
    }
}
