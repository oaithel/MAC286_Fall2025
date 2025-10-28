package com.mac286.binarysearchtrees;

public class bTreeTester {
    public static void main(String[] args) {
        bTree<Integer, String> T = new bTree<>();
        T.insert(25, "Hi25");
        T.insert(30, "Hifgh30");
        T.insert(10, "Hidgvj");
        T.insert(7, "Hidgvnrt");
        T.insert(15, "Hidgvn");
        T.insert(13, "Hi cnbm");
        T.insert(17, "Hibn bnm");
        T.insert(26, "Hicbm");
        T.insert(32, "Hvmbhmni");
        T.insert(35, "Hivm ");
        T.insert(18, "Hinb m");
        T.insert(4, "Hifgbw");
        T.insert(36, "Hsdri");
        T.insert(14, "sdfsf");
        T.preOrdertraversal();
        System.out.println("removing 10: " + T.delete(10));
        T.preOrdertraversal();
        System.out.println("removing 18: " + T.delete(18));
        T.preOrdertraversal();
        System.out.println("removing 25: " + T.delete(25));
        T.preOrdertraversal();

    }
}
