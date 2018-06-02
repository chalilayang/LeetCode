package com.cases;

public class NumTrees {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 0;
        int treeHeight = 0;
        int value = 1;
        while(value - 1 < n) {
            value = value * 2;
            treeHeight ++;
        }
        return result;
    }
}
