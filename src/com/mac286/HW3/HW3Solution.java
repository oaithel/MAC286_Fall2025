package com.mac286.HW3;

import com.mac286.arrays.OurArray;
import com.mac286.queues.OurQueue;
import com.mac286.stacks.OurStack;

import java.util.Random;

public class HW3Solution {
    public static OurStack<Integer> generateStack(int howMany, int max){
        //create a stack
        OurStack<Integer> S = new OurStack<>();
        Random generator = new Random();
        for(int i = 0; i < howMany; i++){
            S.push(generator.nextInt(-max, max));
        }
        return S;
    }
    public static void main(String[] args) {
        OurStack<Integer> mainStack = generateStack(20, 300);
        System.out.println("mainStack: " + mainStack);
        System.out.println("---------Using two additional stacks, sort it negatives down ...-----");
        OurStack<Integer> negatives = new OurStack<>();
        OurStack<Integer> positives = new OurStack<>();
        while(!mainStack.isEmpty()){
            if(mainStack.peek() < 0){
                negatives.push(mainStack.pop());
            }else{
                positives.push(mainStack.pop());
            }
        }
        //Put back negatives first then positives
        while(!negatives.isEmpty()){
            mainStack.push(negatives.pop());
        }
        while(!positives.isEmpty()){
            mainStack.push(positives.pop());
        }
        System.out.println("mainStack: " + mainStack);
        System.out.println("-----------Using one queue and one stack --------");
        mainStack = generateStack(20, 300);
        System.out.println("mainStack: " + mainStack);
        //put negatives in queue and positives in stack.
        positives = new OurStack<>();
        OurQueue<Integer> Q = new OurQueue<>();
        while(!mainStack.isEmpty()){
            if(mainStack.peek() < 0){
                Q.add(mainStack.pop());
            }else{
                negatives.push(mainStack.pop());
            }
        }
        //empty the queue in the new stack to reverse order.
        while(!Q.isEmpty()){
            negatives.push(Q.remove());
        }
        //finally empty the new stack into the original
        while(!negatives.isEmpty()){
            mainStack.push(negatives.pop());
        }
        System.out.println("mainStack: " + mainStack);
        System.out.println("-----------Using one OurArray Object --------");
        mainStack = generateStack(20, 300);
        System.out.println("mainStack: " + mainStack);
        OurArray<Integer> A = new OurArray<>();
        //count positives
        int posCount = 0;
        while(!mainStack.isEmpty()){
            if(mainStack.peek() < 0){
                A.add(mainStack.pop());
            }else{
                A.add(posCount, mainStack.pop());
                posCount++;
            }
        }
        //empty ourArray from the back
        while(!A.isEmpty()){
            mainStack.push(A.remove());
        }
        System.out.println("mainStack: " + mainStack);
        System.out.println("-----------Using one Queue --------");
        mainStack = generateStack(20, 300);
        System.out.println("mainStack: " + mainStack);
        Q = new OurQueue<>();
        //empty the stack into the queue while counting negatives and positives
        int countN = 0, countP = 0;
        while(!mainStack.isEmpty()){
            if(mainStack.peek() < 0){
                countN++;
            }else{
                countP++;
            }
            Q.add(mainStack.pop());
        }
        int pBack = 0, nBack = 0;
        while (pBack < countP || nBack < countN) {
            if(Q.peek() >= 0){
                mainStack.push(Q.remove());
                pBack++;
            }else{
                Q.add(Q.remove());
                nBack++;
            }
        }
        //The loop will stop when all positive numbers are back in the stack
        //and only negatives are left. And all negatives would have looped back to
        // the queue once. The second condition makes sure of that
        //empty the queue back to stack
        while(!Q.isEmpty()){
            mainStack.push(Q.remove());
        }
        //empty the stack back to queue to restore order/reverse
        while(!mainStack.isEmpty()){
            Q.add(mainStack.pop());
        }
        //finally empty the queue back to the stack
        while(!Q.isEmpty()){
            mainStack.push(Q.remove());
        }
        System.out.println("mainStack: " + mainStack);


    }

}
