package com.mac286.binarysearchtrees;

import com.mac286.stacks.OurStack;

import java.util.Arrays;
import java.util.Random;

public class TreePractice {
    public static int[] generateArray(int howMany, int max){
        //create a stack
        int[] S = new int[howMany];
        Random generator = new Random();
        for(int i = 0; i < howMany; i++){
            S[i] = generator.nextInt(-max, max);
        }
        return S;
    }
    public static void main(String[] args) {
        //generate an array of 20 integers.
        int[] A = generateArray(20, 300);
        //using a binarysearch tree for help, sort your array
        System.out.println("Before A: " + Arrays.toString(A));
        bTree<Integer, String> T = new bTree<>();
        for(int i = 0; i < A.length; i++){
            T.insert(A[i], "");
        }
        //in ascending order. (using smallestKey or largestKey methods)
        for(int i = 0; i < A.length; i++){
            int small = T.smallestKey();
            A[i] = small;
            //delete the key
            T.delete(small);
        }
        System.out.println("After A: " + Arrays.toString(A));
    }
}
