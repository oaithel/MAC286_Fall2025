package com.mac286.stacks;

import com.mac286.arrays.OurArray;

/*
    OurArray class has everything needed to implement a Stack.
    We can implement a Stack as a wrapper class around an OurArray object

 */
public class wOurStack<T> {
    //have a reference to an OurArray
    private OurArray<T> A;
    //default constructor. Create an OurArray object
    public wOurStack(){
        A = new OurArray<>();
    }

    //implement size(), isEmpty forwarding the calls to OurArray object
    public int size(){
        return A.size();
    }
    public boolean isEmpty(){
        return A.isEmpty();
    }
    //implement pop() calling remove in OurArray object
    public T pop(){
        return A.remove();
    }
    //implement push calling add, same for peek() and toString()
    public void push(T e){
        A.add(e);
    }
    public T peek(){
        return A.get(A.size()-1);
    }
    public String toString(){
        return A.toString();
    }
}
