package com.mac286.stacks;

import java.util.EmptyStackException;

public class OurStack <T>{
    private T[] array;
    private int size;
    //Default constructor
    public OurStack(){
        array = (T[]) new Object[10];
        size = 0;
    }

    //getter for size
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    private void resize(){
        //create an array of length, old array's length
        //augmented by increment
        T[] newArray = (T[]) new Object[array.length*2];
        //copy all elements of old array into new array
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        //rename new array to old array
        array = newArray;
    }
    public void push(T item){
        //check if full
        if(size == array.length){
            resize();
        }
        //add the item at index size
        array[size] = item;
        //increment the size
        size++;
    }
    public T pop(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        T save = array[size-1];
        size--;
        return save;
    }

    public T peek(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return array[size-1];
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
