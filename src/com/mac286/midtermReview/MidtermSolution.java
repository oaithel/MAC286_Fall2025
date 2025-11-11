package com.mac286.midtermReview;

import com.mac286.HW3.HW3Solution;
import com.mac286.linkedlists.OurList;
import com.mac286.stacks.OurStack;

public class MidtermSolution {
    public static void main(String[] args) {
        OurStack<Integer> mainStack = HW3Solution.generateStack(20, 300);
        System.out.println("---------Using two stacks -------------");
        System.out.println("Before Stack: " + mainStack);

        OurStack<Integer> StackLarge = new OurStack<>();
        OurStack<Integer> StackSmall = new OurStack<>();

        while (!mainStack.isEmpty()) {
            if (mainStack.peek() < -100) {
                StackSmall.push(mainStack.pop());
            } else {
                StackLarge.push(mainStack.pop());
            }
        }
        //put the small number back
        while (!StackSmall.isEmpty()) {
            mainStack.push(StackSmall.pop());
        }
        while (!StackLarge.isEmpty()) {
            if (StackLarge.peek() > 100) {
                StackSmall.push(StackLarge.pop());
            } else {
                mainStack.push(StackLarge.pop());
            }
        }
        //to restore order of the large numbers we put all numbers back into LargeStack
        while (!StackSmall.isEmpty()) {
            StackLarge.push(StackSmall.pop());
        }
        //emptu the large stack into the main
        while (!StackLarge.isEmpty()) {
            mainStack.push(StackLarge.pop());
        }
        System.out.println("After Stack: " + mainStack);
        System.out.println("-------------Using one list--------");
        mainStack = HW3Solution.generateStack(20, 300);
        System.out.println("Before stack: " + mainStack);

        OurList<Integer> list = new OurList<>();
        int countSmall = 0, countMid = 0;
        while(!mainStack.isEmpty()){
            if(mainStack.peek() < -100){
                countSmall++;
                list.addFirst(mainStack.pop());
            }else if(mainStack.peek() <= 100){
                countMid++;
                list.add(countSmall, mainStack.pop());
            }else{
                list.add(countSmall+countMid, mainStack.pop());
            }
        }
        //empty the list into the stack from the front
        while(!list.isEmpty()){
            mainStack.push(list.removeFirst());
        }
        System.out.println("After Stack: " + mainStack);
    }
}
