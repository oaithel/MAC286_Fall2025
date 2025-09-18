package com.mac286.arrays;

// Use this editor to write, compile and run your Java code online

// Use this editor to write, compile and run your Java code online
//Design a class OurArray that has the following properties.
//1- A reference to an array of integers
// 2- an integer to keep track of the size of the array
// 3- default constructor that creates an array of 10 integers and sets size to 0
//3- A constructor that accepts the intial capacity. Create an array of that specific capacity and set size to 0
// 4- Method void add(int item) adds item to the back of the array. Assign item to index size and increase size by 1
// 5- toString returns content of the arrayin the form [-2, -5]

import java.util.EmptyStackException;

public class OurArray <T>{
    private T[] array;
    private int size;
    private int Increment;

    //Default constructor
    public OurArray(){
        array = (T[]) new Object[10];
        size = 0;
        Increment = 10;
    }
    public OurArray(int c){
        array = (T[]) new Object[c];
        size = 0;
        Increment = 10;
    }
    public OurArray(int c, int incr){
        array = (T[]) new Object[c];;
        size = 0;
        Increment = incr;
    }
    //getter for size
    public int size(){
        return size;
    }
    //getter for capacity
    public int capacity(){
        return array.length;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    private void resize(){
        //create an array of length, old array's length
        //augmented by increment
        T[] newArray = (T[]) new Object[array.length + Increment];
        //copy all elements of old array into new array
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        //rename new array to old array
        array = newArray;
    }
    public void add(T item){
        //check if full
        if(size == array.length){
            resize();
        }
        //add the item at index size
        array[size] = item;
        //increment the size
        size++;
    }
    public void add(int ind, T item){
        //check if ind in a valid index
        if(ind < 0 || ind > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(size == array.length){
            resize();
        }
        //shift up all items starting from size-1 down to ind
        for(int i = size - 1; i >= ind; i--){
            array[i+1] = array[i];
        }
        array[ind] = item;
        size++;

    }
    //HW1 complete the remove method that removes the top of the array and returns it. Test it
    public T remove(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        T save = array[size-1];
        size--;
        return save;
    }
    public T remove(int ind){
        //if empty throw an exception
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        //if invalid index, throw IndexOutOfBoundsException
        if(ind < 0 || ind >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        //save element at ind
        T save = array[ind];
        //push all elements down by one starting at ind
        //up until size-1
        for(int i = ind; i < size-1; i++){
            array[i] = array[i+1];
        }
        //return the saved data.
        size--;
        return save;
    }
    public T get(int ind){
        if(ind < 0 || ind >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[ind];
    }
    /*
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        String str = "[";
        for(int i = 0; i < size-1; i++){
            str += array[i] + ", ";
        }
        str += array[size-1]+"]";

        //One solution not advisable
        //str = str.replace(", ]", "]");
        return str;
    }
    */
    //Another way of dealing with the comma problem
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        String str = "[" + array[0];
        for(int i =1; i < size; i++){
            str += ", "+ array[i];
        }
        str += "]";

        //One solution not advisable
        //str = str.replace(", ]", "]");
        return str;
    }

}