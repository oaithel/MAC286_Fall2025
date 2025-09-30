package com.mac286.queues;

import com.mac286.stacks.wOurStack;
//Change this tester to make it work with our queue
public class QueueTester {
    public static void main(String[] args) {
        //OurQueue<Integer> Q = new OurQueue<>();
        CircularQueue<Integer> Q = new CircularQueue<>();
        System.out.println("size: " + Q.size() + " S: " + Q);
        Q.add(-1);
        Q.add(-3);
        System.out.println("size: " + Q.size() + " S: " + Q);
        Q.add(-9);
        System.out.println("size: " + Q.size() + " S: " + Q);
        System.out.println("The first in line is: " + Q.peek());
        System.out.println("size: " + Q.size() + " S: " + Q);
        System.out.println("removing: " + Q.remove());
        System.out.println("size: " + Q.size() + " S: " + Q);
        Q.remove();
        Q.remove();
        System.out.println("size: " + Q.size() + " S: " + Q);
        Q.remove();
    }
}
