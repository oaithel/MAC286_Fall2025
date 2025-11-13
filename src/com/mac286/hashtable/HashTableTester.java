package com.mac286.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTableTester {
    public static void main(String[] args) {
        //Map in Java is an interface, HashMap and Hashtable are implementing classes
        Map<Integer, String> M = new HashMap<>();
        M.put(10, "Hi");
        M.put(12, "Bye");
        M.put(15, "Hello");
        M.put(16, "Hola");
        M.put(18, "How");
        System.out.println("M: " + M);
        System.out.println("The value of 15 is: " + M.get(15));
        System.out.println("The value of 19 is: " + M.get(19));
        //if you add an existing key, the value at that key will
        //be replaced by the new one, no duplicate keys are allowed
        M.put(12, "Bye Bye");
        System.out.println("M: " + M);
        //removing key 16
        System.out.println("removing key 16: " + M.remove(16));
        System.out.println("M: " + M);
        System.out.println("removing key 19: " + M.remove(19));
        //To go through all elements of a hashMap, you need the set of all
        //keys. You can get the set using .keySet. Remember a set is a collection
        //of different items.
        Set<Integer> keys = M.keySet();
        //go through the set key by key and get the values and work with them
        for(Integer k : keys){
            String val = M.get(k);
            System.out.println(k + " = " + val);
        }
    }
}
