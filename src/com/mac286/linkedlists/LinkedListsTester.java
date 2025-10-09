package com.mac286.linkedlists;

import java.util.ArrayList;

public class LinkedListsTester {
    public static void main(String[] args) {
        //ArrayList<Integer> A = new ArrayList<>();
        OurList<Integer> A = new OurList<>();
        OurDoubleLinkedList<Integer> A = new OurDoubleLinkedList<>();
        A.add(-1);
        A.add(-3);
        A.add(-5);
        System.out.println("A.size: " + A.size() + " A: " + A);
        System.out.println("removing: " + A.remove());
        System.out.println("A.size: " + A.size() + " A: " + A);
        A.addFirst(-9);
        System.out.println("Added -9 first" + " A: " + A);
        A.add(1, -7);
        System.out.println("added -7 index 1 " + " A: " + A);
        System.out.println("element at index 2 is: " + A.get(2));
        A.addLast(-11);
        System.out.println("added -11 last " + " A: " + A);
        System.out.println("Removing element at index 2: " + A.remove(2));
        System.out.println("A.size: " + A.size() + " A: " + A);
        System.out.println("Removing first: " + A.removeFirst());
        System.out.println("A.size: " + A.size() + " A: " + A);
        System.out.println("Removing last: " + A.removeLast());
        System.out.println("A.size: " + A.size() + " A: " + A);


    }
}
