package com.cases;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PokerFlipCase {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] poker = new int[]{1,2,3,4};
        Deque<Integer> deque = new LinkedList<>();
        for (int index = poker.length - 1; index >=0; index --) {
            reverseFlip(deque, poker[index]);
        }
        while(!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
        }
    }

    private static void reverseFlip(Deque<Integer> deque, int value) {
        if (deque  != null) {
            if (!deque.isEmpty()) {
                int tailValue = deque.pollLast();
                deque.offerFirst(tailValue);
            }
            deque.offerFirst(value);
        }
    }
}
