package com.mac286.heaps;

import java.util.PriorityQueue;

public class PriorityQeueueTester {
    public static void main(String[] args) {
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        Q.add(-2);
        Q.add(-6);
        Q.add(-5);
        Q.add(-13);
        Q.add(-9);
        Q.add(-8);
        System.out.println("Q: " + Q);
        System.out.println("Removing: " + Q.remove());
        System.out.println("Q: " + Q);
        System.out.println("Removing: " + Q.remove());
        System.out.println("Q: " + Q);

    }
}
