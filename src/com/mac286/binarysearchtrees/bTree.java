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
        Node<K, T> newNode = new Node<K, T>(k, d);
        //if the tree is empty then set root to the newNode,
        //set size to 1 and return
        if(this.isEmpty()){
            root = newNode;
            size = 1;
            return;
        }

        //start temp at root
        Node<K, T> temp = root;
        //forever do the following:
        while(true) {
            //if k is smaller than key of temp
            if(k.compareTo(temp.key) < 0) {
                //if there is a left, then go to left (temp = temp.getLeft())
                if(temp.getLeft() != null){
                    temp = temp.getLeft();
                    continue; //go back to the while
                }else {
                    //else link the node to the left of temp, increase the
                    //size and return.
                    temp.setLeft(newNode);
                    size++;
                    return;
                }
            }else {
                //else (if k is larger than key of temp)
                //if there is a right, go to the right
                if(temp.getRight() != null){
                    temp = temp.getRight();
                    continue;
                }else {
                    //else, link the node to the right of temp
                    //increment size and return.
                    temp.setRight(newNode);
                    size++;
                    return;
                }
            }
        }

    }

    public void preOrdertraversal(){
        System.out.println("PreOrder: ");
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node<K, T> n){
        if(n == null)
            return;
        //visit n
        System.out.print(n.toString());
        //explore the left
        preOrder(n.getLeft());
        //explore the right
        preOrder(n.getRight());
    }

    //TODO: find reference to node with key k, null if it does not exist
    private Node<K, T> findNode(K k){

        Node<K, T> temp = root;
        while(true){
            if(temp == null){
                return null;
            }
            if(temp.getKey().compareTo(k) == 0){
                return temp;
            }
            if(k.compareTo(temp.getKey()) < 0){
                //go left
                temp = temp.getLeft();
            }else{
                temp = temp.getRight();
            }
        }

    }
    //TODO: returns the refrence to parent of node with key k.
    private  Node<K, T> parentOf(K k){
        if(root.getKey().compareTo(k) == 0){
            return null;
        }
        Node<K, T> temp = root;
        while(true){
            if(temp == null){
                return null;
            }
            if((temp.getLeft() != null && temp.getLeft().getKey().compareTo(k) == 0)
                    || (temp.getRight()!= null && temp.getRight().getKey().compareTo(k) == 0)){
                return temp;
            }
            if(k.compareTo(temp.getKey()) < 0){
                //go left
                temp = temp.getLeft();
            }else{
                temp = temp.getRight();
            }
        }
    }
    //TODO: find the smallest node on the right
    private Node<K, T> smallestOnRight(Node<K, T> n){
        //go once right, then keep going left until the left is null, you have your node
        Node<K, T> temp = n;
        if (temp.getRight() == null){
            return null;
        }
        //go once right
        temp = temp.getRight();
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }
    //TODO:
    private Node<K, T> largestOnLeft(Node<K, T> n){
        //go once left, then keep going right until the right is null, you have your node
        Node<K, T> temp = n;
        if (temp.getLeft() == null){
            return null;
        }
        //go once left
        temp = temp.getLeft();
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp;
    }

    public T delete(K k){
        //finad node to delete
        Node<K, T> nodeToDelete = findNode(k);
        if(nodeToDelete == null){
            System.out.println("Node does not exist");
            return null;
        }
        //save the data to be returned
        T save = nodeToDelete.getmData();
        //delete the node.
        if(nodeToDelete.getRight() == null && nodeToDelete.getLeft() == null){
            //this is a leaf.
            //find the parent of nodeToDelete, prune the link.
            if(nodeToDelete == root){
                root = null;
                size = 0;
                return save;

            }else{
                //find the parent
                Node<K, T> parentDelete = parentOf(nodeToDelete.getKey());
                if(parentDelete.getLeft()!= null && parentDelete.getLeft().getKey().compareTo(nodeToDelete.getKey()) == 0){
                    //the node is connected through the left
                    parentDelete.setLeft(null);
                    size--;
                    return save;
                }else{
                    parentDelete.setRight(null);
                    size--;
                    return save;
                }
            }
        }
        //The node is not a leaft, it has a left or a right
        if(nodeToDelete.getRight() != null){
            //repalce with smallest on the right
            Node<K, T> replacement = smallestOnRight(nodeToDelete);
            Node<K, T> parentReplacement = parentOf(replacement.getKey());
            if(parentReplacement.getLeft().getKey().compareTo(replacement.getKey()) == 0){
                //replacment is connected to the oparent through the left
                parentReplacement.setLeft(replacement.getRight());
            }else{
                //replacement is connected through the right
                parentReplacement.setRight(replacement.getRight());
            }
            //copy replacment to nodeTodelete
            nodeToDelete.setKey(replacement.key);
            nodeToDelete.setmData(replacement.mData);
            size--;
            return save;
        }else{
            //replace with largest on the left
            Node<K, T> replacement = largestOnLeft(nodeToDelete);
            Node<K, T> parentReplacement = parentOf(replacement.getKey());
            if(parentReplacement.getLeft().getKey().compareTo(replacement.getKey()) == 0){
                //replacment is connected to the parent through the left
                parentReplacement.setLeft(replacement.getLeft());
            }else{
                //replacement is connected through the right
                parentReplacement.setRight(replacement.getLeft());
            }
            //copy replacment to nodeTodelete
            nodeToDelete.setKey(replacement.key);
            nodeToDelete.setmData(replacement.mData);
            size--;
            return save;
        }
    }
    public K smallestKey(){
        Node<K, T> temp = root;
        //keep going left, if there is left
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp.getKey();
    }
    public K largestKey(){
        Node<K, T> temp = root;
        //keep going right, if there is right
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp.getKey();
    }

}
