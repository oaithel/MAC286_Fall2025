package com.mac286.hashtable;

public class OurHashtable <K extends Comparable, T>{
    private class Node<KK, TT>{
        private KK key;
        private TT value;

        public Node(){
            key = null;
            value = null;
        }
        public Node(KK aKey, TT val){
            key = aKey;
            value = val;
        }

        public KK getKey() {
            return key;
        }

        public void setKey(KK key) {
            this.key = key;
        }

        public TT getValue() {
            return value;
        }

        public void setValue(TT value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private Node<K, T>[] H;
    private int size;
    private float loadFactor;

    public OurHashtable(){
        H = new Node[11];
        size = 0;
        loadFactor = 0.75f;
    }
    private static boolean isPrime(int a){
        if(a < 2){
            return false;
        }
        if (a == 2){
            return true;
        }
        if (a % 2 == 0){
            return false;
        }
        for(int i = 3; i <= Math.sqrt(a); i+= 2){
            if(a%i == 0){
                return false;
            }
        }
        return true;

    }
    public OurHashtable(int s){
        while(!isPrime(s)){
            s++;
        }
        H = new Node[s];
        size = 0;
        loadFactor = 0.75f;
    }
    public OurHashtable(int s, float l){
        while(!isPrime(s)){
            s++;
        }
        H = new Node[s];
        size = 0;
        loadFactor = l;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public int hashFunction(K k){
        return Math.abs(k.hashCode())%H.length;
    }
    public void put(K k, T val){
        int index = hashFunction(k);
        while(H[index] != null){
            index = (index+1)%H.length;
        }
        //make a node
        Node<K, T> n = new Node<>(k, val);
        H[index] = n;
        size++;
    }

    public T remove(K k){
return null;
    }

    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        String st = "[";
        int i = 0;
        while(H[i] == null){
            i++;
        }
        st += H[i].toString();
        for(i=i+1; i<H.length; i++){
            if(H[i] != null){
                st += ", " + H[i];
            }
        }
        st += "]";
        return st;
    }
}
