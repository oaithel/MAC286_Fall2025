package com.mac286.heaps;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class OurHeap <T extends Comparable<T>>{
    //We need an array of Ts which are Comparables. Create an array of Comparables
    private T[] H;
    private int size;

    public OurHeap(){
        H = (T[]) new Comparable[10];
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }

    public void add(T e) {
        //if full, then resize
        if(size == H.length){
            H = Arrays.copyOf(H, H.length*2);
        }
        //add e at index size;
        H[size] = e;
        //heapify at index size
        heapify(size);
        //increment size
        size++;
    }

    private void heapify(int i){
        //if i is the root return
        if (i <= 0)
            return;
        //find the parent of i
        int parent = (i-1)/2;
        //compare i to the parent if i is larger, then return
        if(H[i].compareTo(H[parent]) >= 0){
            //i is larger than the parent, return
            return;
        }
        //swap i with parent
        T save = H[i];
        H[i] = H[parent];
        H[parent] = save;
        //heapify at the parent
        heapify(parent);

    }
//TODO: HW7
    public T remove(){
        if(this.isEmpty()){
            throw new NoSuchElementException("Empty Heap");
        }
        //save the top, index 0
        T save = H[0];
        //replace the top 0 by the last (index size-1)
        H[0] = H[size-1];
        //decrement size.
        size--;
        //reheapify(0)
        reheapify(0);
        //retrun save
        return save;
    }
//TODO: HW7
    private void reheapify(int i){
        //if i has no children, return.
        if(2*i+1 >= size){
            return;
        }
        //left child = 2*i + 1, right cxhild = 2*i + 2

        //find the smallest of the children, call it smallest
        //assume the left is the smallest
        int indexSmallest = 2*i + 1;
        //if there is a right may be the right is smaller
        if(2*i+2 < size){
            if(H[2*i + 2].compareTo(H[2*i+1]) < 0){
                indexSmallest = 2*i + 2;
            }
        }
        //compare i to smallest, if i is smaller, then return
        if(H[i].compareTo(H[indexSmallest]) <= 0){
            //The parent is smaller than the smallest of the children, return
            return;
        }
        //swap i with smallest
        T save = H[i];
        H[i] = H[indexSmallest];
        H[indexSmallest] = save;
        //reheapify at smallest
        reheapify(indexSmallest);
    }
    //Another way of dealing with the comma problem
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        String str = "[" + H[0];
        for(int i =1; i < size; i++){
            str += ", "+ H[i];
        }
        str += "]";

        //One solution not advisable
        //str = str.replace(", ]", "]");
        return str;
    }

}
