package com.algrithm.sort;

import java.util.Stack;

public class InsertSort {
    public static int CountCompare = 0;
    public static int CountSwap = 0;
    private Stack<Integer> fff;

    public static long sort(int[] data) {
        CountCompare = 0;
        CountSwap = 0;
        long time = System.nanoTime();

        if (data == null) {
            return 0;
        }
        for (int index = 1, count = data.length; index < count; index++) {
            int value = data[index];
            int indexObj = index;
            for (int i = 0; i < index; i++) {
                int valueObj = data[index - i - 1];
                if (compare(value, valueObj) >= 0) {
                    indexObj = index - i;
                    break;
                } else {
                    indexObj--;
                }
            }
            if (indexObj != index) {
                int k = index;
                while(k > indexObj) {
                    data[k] = data[k-1];
                    k--;
                }
                data[k] = value;
            }
        }
        return System.nanoTime() - time;
    }
    
    private static int compare(int ori, int obj) {
        CountCompare++;
        return ori > obj ? 1 : (ori == obj ? 0 : -1);
    }
}
