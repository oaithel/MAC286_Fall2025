package com.mac286.linkedlists;

public class NodeTester {
    public static void main(String[] args) {
        //create a Node N1 for Integers.
        Node<Integer> N1 = new Node<>();
        //assign to the data -1
        N1.setmData(-1);
        //Create a Node N2 with -3 data.
        Node<Integer> N2 = new Node<>(-3);
        // reate a Node N3 with -5 as data.
        Node<Integer> N3 = new Node<>(-5);
        //Link the nodes so that N1 is first, then comes N3, then comes N2.
        //N3 is next of N1.
        N1.setNext(N3); //make N3 next of N1
        //N2 is next of N3
        N3.setNext(N2);
        //using N1, show the content of all the nodes, N1, N2 and N3 only using N1.
        System.out.println("N1: " + N1.getmData());
        //show N3 using N1. N1.getNext() is N3, we can use that
        System.out.println("N3: " + N1.getNext().getmData());
        //show N2 using N1, go to N3 first then get the next of N3 which is N2
        //N1.getNext() is N3, because N2 is next of N3 then N1.getNext().getNext() is N2.
        System.out.println("N2: " + N1.getNext().getNext().getmData());

        //Let's do the same with a temporary reference temp.
        Node<Integer> temp = N1;
        System.out.println("N1: " + temp.getmData());
        //What to do to temp.
        temp = temp.getNext();
        System.out.println("N3: " + temp.getmData());
        temp = temp.getNext();
        System.out.println("N3: " + temp.getmData());

        System.out.println("------------Using a loop to traverse a list----------");
        temp = N1; //set temp to the head of the list
        while(temp != null){
            System.out.println(" " + temp.getmData());
            temp = temp.getNext(); //move to next Node
        }
    }
}
