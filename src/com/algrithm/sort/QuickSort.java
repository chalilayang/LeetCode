package com.algrithm.sort;

import java.util.Stack;

public class QuickSort {
    public static int CountCompare = 0;
    public static int CountSwap = 0;

    public static long sort(int[] data) {
        CountCompare = 0;
        CountSwap = 0;
        long time = System.nanoTime();

        if (data == null) {
            return 0;
        }
        sort(data, 0, data.length-1);
        return System.nanoTime() - time;
    }
    
    public static long sortNotRecursive(int[] data) {
        CountCompare = 0;
        CountSwap = 0;
        long time = System.nanoTime();

        if (data == null) {
            return 0;
        }
        sortNotRecursive(data, 0, data.length-1);
        return System.nanoTime() - time;
    }
    
    private static void sort(int[] data, int start, int end) {
        if (data == null || start >= end || start < 0 || end >= data.length) {
            return;
        }
        int i = start, j = end;
        int tmp = data[start];
        while(i != j) {
            while(data[j] >= tmp && i < j) {
                j--;
            }
            while(data[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                swap(data, i, j);
            }
        }
        data[start] = data[i];
        data[i] = tmp;
        sort(data, start, i -1);
        sort(data, i+1, end);
    }
    
    private static class Region {
        int high;
        int low;
    }
    
    public static void sortNotRecursive(int[] data, int start, int end) {
        if (data == null || start >= end || start < 0 || end >= data.length) {
            return;
        }
        Stack<Region> stack = new Stack<Region>();
        Region region = new Region();
        region.high = end;
        region.low = start;
        stack.push(region);
        while(!stack.isEmpty()) {
            Region regionTmp = stack.pop();
            int p = partion(data, regionTmp.low, regionTmp.high);
            if (p-1 > regionTmp.low) {
                Region regionTmp1 = new Region();
                regionTmp1.low = regionTmp.low;
                regionTmp1.high = p - 1;
                stack.push(regionTmp1);
            }
            if (p+1 < regionTmp.high) {
                Region regionTmp2 = new Region();
                regionTmp2.low = p+1;
                regionTmp2.high = regionTmp.high;
                stack.push(regionTmp2);
            }
        }        
    }
    
    private static int partion(int[] data, int start, int end) {
        if (data == null || start >= end || start < 0 || end >= data.length) {
            return -1;
        }
        int i = start, j = end;
        int tmp = data[start];
        while(i != j) {
            while(data[j] >= tmp && i < j) {
                j--;
            }
            while(data[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                swap(data, i, j);
            }
        }
        data[start] = data[i];
        data[i] = tmp;
        return i;
    }
    
    private static void swap(int[] data, int i, int j) {
        CountSwap ++;
        int tmp = data[j];
        data[j] = data[i];
        data[i] = tmp;
    }
    
    private static int compare(int ori, int obj) {
        CountCompare++;
        return ori > obj ? 1 : (ori == obj ? 0 : -1);
    }
}
