package com.mac286.midtermReview;

import com.mac286.HW3.HW3Solution;
import com.mac286.linkedlists.OurList;
import com.mac286.stacks.OurStack;

public class MidtermReview {
    public static void main(String[] args) {
        OurStack<Integer> mainStack = HW3Solution.generateStack(20, 200);

        System.out.println("----------Using two additional stacks for help-----------");
        OurStack<Integer> NS = new OurStack<>();
        OurStack<Integer> PS = new OurStack<>();
        System.out.println("Before S: " + mainStack);
        int countN = 0, countP = 0;
        while(!mainStack.isEmpty()){
            if(mainStack.peek() < 0){
                countN++;
                NS.push(mainStack.pop());
            }else{
                countP++;
                PS.push(mainStack.pop());
            }
        }
        for(int i = 0; i < Math.min(countN, countP); i++){
            if(countP > countN){
                mainStack.push(PS.pop());
                mainStack.push(NS.pop());
            }else{
                mainStack.push(NS.pop());
                mainStack.push(PS.pop());
            }
        }
        //empty both, one of them if empty anyways
        while(!PS.isEmpty()){
            mainStack.push(PS.pop());
        }
        while(!NS.isEmpty()){
            mainStack.push(NS.pop());
        }
        System.out.println("After S: " + mainStack);
        System.out.println("--------- Using one List for help---------");
        mainStack = HW3Solution.generateStack(20, 200);
        System.out.println("Before S: " + mainStack);
        OurList<Integer> L = new OurList<>();
    }
}
