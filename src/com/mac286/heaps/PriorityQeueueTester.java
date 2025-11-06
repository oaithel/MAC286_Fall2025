package com.mac286.heaps;

import java.util.PriorityQueue;

public class PriorityQeueueTester {
    public static void main(String[] args) {
        //PriorityQueue<Integer> Q = new PriorityQueue<>();
        OurHeap<Integer> Q = new OurHeap<>();
        Q.add(-2);
        Q.add(-6);
        Q.add(-5);
        System.out.println("Q: " + Q);
        Q.add(-13);
        Q.add(-9);
        Q.add(-8);
        System.out.println("Q: " + Q);
        /*System.out.println("Removing: " + Q.remove());
        System.out.println("Q: " + Q);
        System.out.println("Removing: " + Q.remove());
        System.out.println("Q: " + Q);
         */

    }
}
