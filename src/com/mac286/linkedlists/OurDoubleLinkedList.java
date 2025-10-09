package com.mac286.linkedlists;

import java.util.NoSuchElementException;

/*
TODO: HW4
Modify OurList to impelemnt a double linked list. Use this code, do not write your
own.
 */
public class OurDoubleLinkedList <T>{
    private class Node<D>{
        private D mData;
        private Node<D> next, previous;

        public Node(){
            mData = null;
            next = null;
        }
        public Node(D d){
            mData = d;
            next = null;
        }
        public Node(D d, Node<D> n){
            mData = d;
            next = n;
        }
        public D getmData() {
            return mData;
        }

        public void setmData(D mData) {
            this.mData = mData;
        }

        public Node<D> getNext() {
            return next;
        }
        public Node<D> getPrevious() {
            return previous;
        }

        public void setNext(Node<D> next) {
            this.next = next;
        }
        public void setPrevious(Node<D> prev) {
            this.previous = prev;
        }
        public String toString(){
            return mData.toString();
        }
    }

    private Node<T> Head, Tail;
    private int size;
    //default constructor
    public OurDoubleLinkedList(){
        Head = Tail = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }

    //TODO: Modify add to include the previous

    public void add(T e){
        //Create a node with data e
        Node<T> newNode = new Node<>(e);
        if(this.isEmpty()){
            Head = Tail = newNode;
        }else{
            Tail.setNext(newNode);
            Tail = newNode;
        }
        size++;
    }
    //TODO
    //remove removes the first element of the list and returns it.
    public T remove() {
        if(this.isEmpty()){
            throw new NoSuchElementException("Empty list");
        }
        T save = Head.getmData();
        //move head to tnext
        Head = Head.getNext();
        size--;
        if(size == 0){
            Head = Tail = null;
        }
        return save;
    }
    //TODO
    public T removeFirst(){

        return this.remove();
    }

    public void addLast(T e){

        this.add(e);
    }
    public T removeLast(){
        return this.remove(this.size-1);
    }
    public void addFirst(T e){
        if(this.isEmpty()){
            this.add(e);
        }else{
            //create a new node
            Node<T> newNode = new Node<>(e);
            //set next of newNode to Head
            newNode.setNext(Head);
            //set Head to newNode
            Head = newNode;
            size++;
        }
    }
    //remove specific index
    public T remove(int ind){
        if(ind < 0 || ind > size-1){
            throw new IndexOutOfBoundsException();
        }
        if(ind == 0){
            return remove();
        }
        //go to the node at index ind-1
        Node<T> temp = Head;
        //advance ind-1 times
        for(int i = 0; i <ind-1; i++){
            temp = temp.getNext();
        }
        T save = temp.getNext().getmData();
        //lilnk temp to the next of the next node
        temp.setNext(temp.getNext().getNext());
        size--;
        return save;
    }
    //add T at index ind
    public void add(int ind, T e){
        //check if the index is valid
        if(ind < 0 || ind > size){
            throw new IndexOutOfBoundsException();
        }
        if(ind == size){
            this.add(e);
        } else if(ind == 0){
            this.addFirst(e);
        } else{
            Node<T> temp = Head;
            for(int i = 0; i < ind - 1; i++){
                temp = temp.getNext();
            }
            //1- create a new Node
            Node<T> newNode = new Node<>(e);
            //2- ALWAYS update fist the links in the new node
            //before changing any other link
            newNode.setNext(temp.getNext());
            //set next of temp to newNode
            temp.setNext(newNode);
            size++;
        }
    }
    public T get(int ind){
        //check if index is valid
        if(ind < 0 || ind > size-1){
            throw new IndexOutOfBoundsException();
        }
        //start at Head and loop (advance) ind times
        Node<T> temp = Head;
        for(int i =0; i < ind; i++){
            temp = temp.getNext();
        }
        return temp.getmData();
    }
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        Node<T> temp = Head;
        String st = "[" + temp.getmData();
        //move to next
        temp = temp.getNext();
        while(temp != null){
            //add the data to the string
            st += ", " + temp.getmData();
            //move to next node
            temp = temp.getNext();
        }
        //add "]" to st
        st += "]";
        return st;
    }
}
