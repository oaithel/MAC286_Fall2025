package com.mac286.linkedlists;

import com.mac286.stacks.OurStack;

import java.util.Random;

/*
Write a program that generates a stack of 20 random numbers between -300 and +300
Using one single linkedList reorganize the stack so that
numbers less than -100 go to the bottom, numbers between -100 and +100 in the middle and
numbers larger +100 on the top, while maintaining the order in which numbers
were in the stack originally.
 */
public class PracticeLists {
    public static OurStack<Integer> generateStack(int howMany, int max){
        //create a stack
        OurStack<Integer> S = new OurStack<>();
        Random generator = new Random();
        for(int i = 0; i < howMany; i++){
            S.push(generator.nextInt(-max, max));
        }
        return S;
    }
}
