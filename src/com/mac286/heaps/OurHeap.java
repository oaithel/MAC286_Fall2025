package com.mac286.heaps;

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

        //add e at index size;

        //heapify at index size

        //increment size
    }

    private void heapify(int i){
        //if i is the root return
        //find the parent of i

        //compare i to the parent if i is larger, then return

        //swap i with parent

        //heapify at the parent

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
