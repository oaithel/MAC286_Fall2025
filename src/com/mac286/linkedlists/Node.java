package com.mac286.linkedlists;

public class Node <T> {
    //The node has two fields: one for the data and the second is the reference to the next
    //node.
    private T mData;
    private Node<T> next;

    public Node(){
        mData = null;
        next = null;
    }
    public Node(T d){
        mData = d;
        next = null;
    }
    public Node(T d, Node n){
        mData = d;
        next = n;
    }
    public T getmData() {
        return mData;
    }

    public void setmData(T mData) {
        this.mData = mData;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    public String toString(){
        return mData.toString();
    }
}
