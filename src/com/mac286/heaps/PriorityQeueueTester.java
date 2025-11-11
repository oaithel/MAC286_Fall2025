package com.mac286.heaps;

import java.util.PriorityQueue;

public class PriorityQeueueTester {
    public static void main(String[] args) {
        //PriorityQueue<Integer> Q = new PriorityQueue<>();
        OurHeap<Integer> Q = new OurHeap<>();
        Q.add(10);
        Q.add(12);
        Q.add(14);
        Q.add(6);
        Q.add(8);
        Q.add(9);
        Q.add(4);
        Q.add(2);
        Q.add(5);
        Q.add(1);
        Q.add(3);
        System.out.println("Q: " + Q);
        System.out.println("Removing: " + Q.remove());
        System.out.println("Q: " + Q);
        System.out.println("Removing: " + Q.remove());
        System.out.println("Q: " + Q);

        //TODO: HW8 Practice: Generate a random aray of 10 integers.
        //Use a heap to sort the array from the largest to the smallest value.
    }
}
