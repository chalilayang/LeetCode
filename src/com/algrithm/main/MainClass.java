package com.algrithm.main;

import com.algrithm.sort.InsertSort;
import com.algrithm.sort.PopSort;
import com.algrithm.sort.QuickSort;
import com.algrithm.sort.SelectionSort;
import com.algrithm.utils.DataGenerator;

public class MainClass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] datas = DataGenerator.generateRandomDatas(10);
        
        int[] datas1 = datas.clone();
        int[] datas2 = datas.clone();
        int[] datas3 = datas.clone();
        int[] datas4 = datas.clone();
        int[] datas5 = datas.clone();
        
        DataGenerator.printDatas(datas);
        System.out.print("\n\n");
        
        
        System.out.println("选择排序");
        long time = SelectionSort.sort(datas1);
        DataGenerator.printDatas(datas1);
        System.out.print("\n");
        System.out.println("比较次数 :" + SelectionSort.CountCompare);
        System.out.println("交换次数 :" + SelectionSort.CountSwap);
        System.out.println("消耗时间 :" + time + "纳秒" );
        
        System.out.println("冒泡排序");
        time = PopSort.sort(datas2);
        DataGenerator.printDatas(datas2);
        System.out.print("\n");
        System.out.println("比较次数 :" + PopSort.CountCompare);
        System.out.println("交换次数 :" + PopSort.CountSwap);
        System.out.println("消耗时间 :" + time + "纳秒" );
        
        System.out.println("插入排序");
        time = InsertSort.sort(datas3);
        DataGenerator.printDatas(datas3);
        System.out.print("\n");
        System.out.println("比较次数 :" + InsertSort.CountCompare);
        System.out.println("交换次数 :" + InsertSort.CountSwap);
        System.out.println("消耗时间 :" + time + "纳秒" );
        
        System.out.println("快速排序");
        time = QuickSort.sort(datas4);
        DataGenerator.printDatas(datas4);
        System.out.print("\n");
        System.out.println("比较次数 :" + QuickSort.CountCompare);
        System.out.println("交换次数 :" + QuickSort.CountSwap);
        System.out.println("消耗时间 :" + time + "纳秒" );
        
        System.out.println("非递归快速排序");
        time = QuickSort.sortNotRecursive(datas5);
        DataGenerator.printDatas(datas5);
        System.out.print("\n");
        System.out.println("比较次数 :" + QuickSort.CountCompare);
        System.out.println("交换次数 :" + QuickSort.CountSwap);
        System.out.println("消耗时间 :" + time + "纳秒" );
        
        System.out.print("\n\n");
    }
}
