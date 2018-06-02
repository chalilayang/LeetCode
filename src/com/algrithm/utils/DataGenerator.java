package com.algrithm.utils;

import java.util.Random;

public class DataGenerator {

    public static int[] generateRandomDatas(int count) {
        int[] datas = new int[count];
        Random seed = new Random(System.currentTimeMillis());
        for (int index = 0; index < count; index ++) {
            datas[index] = seed.nextInt(10000);
        }
        return datas;
    }
    
    public static int[] generateAscDatas(int count) {
        int[] datas = new int[count];
        for (int index = 0; index < count; index ++) {
            datas[index] = index;
        }
        return datas;
    }
    
    public static int[] generateDesDatas(int count) {
        int[] datas = new int[count];
        for (int index = count-1; index >= 0; index --) {
            datas[index] = count - index - 1;
        }
        return datas;
    }
    
    public static void printDatas(int[] datas) {
        System.out.print("\n\n");
        for (int index = 0, count = datas.length; index < count; index ++) {
            System.out.print(datas[index]);
            if (index != (count-1)) {
                System.out.print(",");
            }
        }
        System.out.print("\n\n");
    }
}
