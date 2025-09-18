package com.mac286.stacks;

import java.util.Stack;

/*
A Stackis a data structure in which when you add something to (store) it goes
to the top of the stack and when you remove the top comes out first.
LIFO: Last In First Out.
The standard interface for a stack is the following:
- A default constructor
- size() returns the number of elements in the stack
- isEmpty() return true if stack is empty, false if not.
- void push(T e) adds e to the top of the stack
- T pop() removes the top of the stack and returns it.
- T peek() returns the top of the stack without removing it
- toString() returns the content of the stack as an array.
 */
public class StackTester {
    public static void main(String[] args) {
        //Stack<Integer> S = new Stack<>();
        //OurStack<Integer> S = new OurStack<>();
        wOurStack<Integer> S = new wOurStack<>();
        System.out.println("size: " + S.size() + " S: " + S);
        S.push(-1);
        S.push(-3);
        System.out.println("size: " + S.size() + " S: " + S);
        S.push(-9);
        System.out.println("size: " + S.size() + " S: " + S);
        System.out.println("The top is: " + S.peek());
        System.out.println("size: " + S.size() + " S: " + S);
        System.out.println("poping: " + S.pop());
        System.out.println("size: " + S.size() + " S: " + S);
        S.pop();
        S.pop();
        S.pop();

    }
}
