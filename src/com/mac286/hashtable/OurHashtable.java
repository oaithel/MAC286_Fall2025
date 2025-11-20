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

    //TODO: HW9
    /*
    Implement double hashing
     */
    public int doubleHashFunction(K k, int j){
        //fid Q, find d(k), compute index
        return 0;
    }
    /*
    TODO: Implement the put using double hashing call it hPut
     */
    public void hPut(K k, T t){

    }
    public int hashFunction(K k){
        return Math.abs(k.hashCode())%H.length;
    }
    public void put(K k, T val){
        int index = hashFunction(k);
        while(H[index] != null){
            if(H[index].getKey().compareTo(k) == 0){
                //replace the value at the key and get out
                H[index].setValue(val);
                return;
            }
            index = (index+1)%H.length;
        }
        //make a node
        Node<K, T> n = new Node<>(k, val);
        H[index] = n;
        size++;
    }

    public T get(K k){
        int index = hashFunction(k);
        while(H[index] != null){
            if(H[index].getKey().compareTo(k) == 0) {
                return H[index].getValue();
            }
            index = (index+1)%H.length;
        }
        return null;
    }
    private void shift(int i){
        int s = 1;
        while(H[(i+s)%H.length] != null){
            int j = hashFunction(H[(i+s)%H.length].getKey());
            //does j belong to the interval ]i, i+s]
            if((i+s)%H.length > i){
                if(!(j > i && j <= (i+s)%H.length)){
                    //j does not belong to the interval
                    H[i] = H[(i+s)%H.length];
                    H[(i+s)%H.length] = null;
                    i = (i+s)%H.length;
                    s = 1;
                }else{
                    s++;
                }
            }else{
                if(!(j > i || j <= (i+s)%H.length)){
                    //j does not belong to interval (circular interval)
                    H[i] = H[(i+s)%H.length];
                    H[(i+s)%H.length] = null;
                    i = (i+s)%H.length;
                    s = 1;
                }else{
                    s++;
                }
            }
        }
    }
    public T remove(K k){
        int index = hashFunction(k);
        while(H[index] != null){
            if(H[index].getKey().compareTo(k) == 0){
                T temp = H[index].getValue();
                H[index] = null;
                shift(index);
                size--;
                return temp;
            }
        }
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
