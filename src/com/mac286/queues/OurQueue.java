package com.mac286.queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class OurQueue <T>{
    //define a reference to an array of Ts
    private T[] queue;
    //size
    private int size;
    //default constructor
    public OurQueue(){
        queue = (T[]) new Object[10];
        size = 0;
    }
    //getter for size
    public int size(){
        return size;
    }
    //isEmpty
    public boolean isEmpty(){
        return (size == 0);
    }
    private void resize(){
        queue = Arrays.copyOf(queue, queue.length*2);
    }
    //add(T e) add e to the back of the queue
    public void add(T item){
        if(size == queue.length){
            resize();
        }
        //add item at the back
        queue[size] = item;
        size++;
    }
    //T remove() removes the first in the queue and returns it
    public T remove(){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        //save the first
        T save = queue[0];
        for(int i = 0; i < size-1; i++){
            queue[i] = queue[i+1];
        }
        size--;
        return save;
    }
    //T peek() returns the first in the queue without removing it
    public T peek(){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return queue[0];
    }
    //String toString()
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        String str = "[" + queue[0];
        for(int i =1; i < size; i++){
            str += ", "+ queue[i];
        }
        str += "]";

        //One solution not advisable
        //str = str.replace(", ]", "]");
        return str;
    }
}
