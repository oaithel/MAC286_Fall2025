package com.mac286.hashtable;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTableTester {
    public static void main(String[] args) {
        //Map in Java is an interface, HashMap and Hashtable are implementing classes
        //Map<Integer, String> M = new HashMap<>();
        OurHashtable<Integer, String> M = new OurHashtable<>();
        M.put(13, "Hi");
        M.put(17, "Bye");
        M.put(2, "Hello");
        M.put(23, "Hola");
        M.put(4, "How");
        System.out.println("M: " + M);
        System.out.println("The value of 15 is: " + M.get(13));
        System.out.println("The value of 19 is: " + M.get(2));
        //if you add an existing key, the value at that key will
        //be replaced by the new one, no duplicate keys are allowed
        M.put(13, "Bye Bye");
        System.out.println("M: " + M);
        //removing key 16
        System.out.println("removing key 16: " + M.remove(13));
        System.out.println("M: " + M);
        System.out.println("removing key 19: " + M.remove(19));
        M.put(20, "sdfwsd");
        M.put(21, "asdfsdf");
        M.put(31, "sdfasf");
        System.out.println("M: " + M);
        System.out.println("removing 20: " + M.remove(20));
        System.out.println("M: " + M);
        //To go through all elements of a hashMap, you need the set of all
        //keys. You can get the set using .keySet. Remember a set is a collection
        //of different items.
        /*
        Set<Integer> keys = M.keySet();
        //go through the set key by key and get the values and work with them
        for(Integer k : keys){
            String val = M.get(k);
            System.out.println(k + " = " + val);
        }
        */
    }
}
