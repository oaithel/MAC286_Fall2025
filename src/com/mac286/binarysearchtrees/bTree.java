package com.mac286.binarysearchtrees;

public class bTree <K extends Comparable<K>, T>{
    private static class Node<K extends Comparable<K>, T>{
        private K key;
        private T mData;
        private Node<K, T> left, right;

        public Node(){
            key = null;
            mData = null;
            left = right = null;

        }
        public Node(K k, T d){
            key = k;
            mData = d;
            left = right = null;

        }
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;

        }

        public T getmData() {
            return mData;
        }

        public void setmData(T mData) {
            this.mData = mData;
        }

        public Node<K, T> getLeft() {
            return left;
        }

        public void setLeft(Node<K, T> left) {
            this.left = left;
        }

        public Node<K, T> getRight() {
            return right;
        }

        public void setRight(Node<K, T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + mData + ")";
        }
    }

    private Node<K, T> root;
    private int size;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }

    public void insert(K k, T d){

        //create a new Node with k and d
        //if the tree is empty then set root to the newNode,
        //set size to 1 and return

        //start temp at root
        //forever do the following:
            //if k is smaller than key of temp
                //if there is a left, then go to left (temp = temp.getLeft())
                //else link the node to the left of temp, increase the
                //size and return.
            //else (if k is larger than key of temp)
                //if there is a right, go to the right
                //else, link the node to the right of temp
                //increment size and return.

    }

}
