package com.algrithm.sort;

public class SelectionSort {
    public static int CountCompare = 0;
    public static int CountSwap = 0;
    public static long sort(int[] data) {
        CountCompare = 0;
        CountSwap = 0;
        long time = System.nanoTime();

        if (data == null) {
            return 0;
        }
        for (int index = 0, count = data.length; index < count - 1; index++) {
            int minValue = data[index];
            int indexOfMin = index;
            for (int i = index + 1; i < count; i ++) {
                if (compare(data[i], minValue) < 0) {
                    indexOfMin = i;
                    minValue = data[i];
                }
            }
            if (indexOfMin != index) {
                swap(data, indexOfMin, index);
            }
        }
        return System.nanoTime() - time;
    }
    
    private static void swap(int[] data, int i, int j) {
        CountSwap ++;
        int tmp = data[j];
        data[j] = data[i];
        data[i] = tmp;
    }

    private static int compare(int ori, int obj) {
        CountCompare ++;
        return ori > obj ? 1 : (ori == obj ? 0 : -1);
    }
}
