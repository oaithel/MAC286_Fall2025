package com.mac286.queues;

public class CircularQueue <T>{
    private T[] queue;
    //size
    private int size;
    private int first, last;
    //default constructor
    public CircularQueue(){
        queue = (T[]) new Object[10];
        size = 0;
        first = last = -1;
    }
    public int size(){
        return size;
    }
    //isEmpty
    public boolean isEmpty(){
        return (size == 0);
    }
    private void resize(){
        //Create a temporary array twice the size.

        //copy queue array starting from first going to last, in a circular way to temp.
        //queue[first] should go to temp[0]
        //and queue[last] should go to temp[size-1]
        //reset first to 0, last to size -1 and rename temp by queue..
    }
    public void add(T item){
        //if queue is full, resize.

        //increment last in a circular way (last = (last + 1)%queue.length

        //save item at index last.

        //increment size
    }
    public T remove(){
        //if queue empty throw an exception

        //save element at index first.

        //increment first in a circular way (first = (first + 1)%queue.length

        //decrement the size

        //returned the saved.
        return null;
    }

    public T peek(){
        //if empty throw an exception

        //return element at index first
        return null;
    }

    public String toString(){
        //if empty return empty brackets []

        //create a string with open bracket "["

        //loop for size-1 times
            //add element at index (first + i) in a circular way and ", " to the string

        //at the end of the loop, add element at index last and a closing bracket "]" to the string

        //return the string.
        return null;
    }
}
